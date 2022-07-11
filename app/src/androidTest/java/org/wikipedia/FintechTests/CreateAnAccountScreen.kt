package org.wikipedia.FintechTests

import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import com.google.android.material.textfield.TextInputLayout
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.wikipedia.R


class CreateAnAccountScreen {
    fun fillForm() {
        fillUsernameField()
        fillPasswordField()
        fillRepeatPasswordField()
    }

    private fun fillUsernameField() {
        step("Заполняем поле имени") {
            onView(
                allOf(
                    withHint(R.string.create_account_username_hint),
                    isDisplayed()
                )
            ).perform(click(), typeText(USERNAME))
        }
    }

    val USERNAME = "SomeUsername"
    val PASSWORD = "1234"

    fun fillPasswordField() {
        step("Заполняем поле пароля") {
            onView(
                allOf(
                    withHint(R.string.account_creation_password_hint),
                    isDisplayed()
                )
            ).perform(click(), typeText(PASSWORD))
        }
    }

    fun fillRepeatPasswordField() {
        step("Заполняем поле повтора пароля") {
            onView(
                allOf(
                    withHint(R.string.create_account_password_repeat_hint),
                    isDisplayed()
                )
            ).perform(click(), typeText(PASSWORD))
        }
    }

    fun clickEyeOnPassword() {
        step("Нажимаем иконку \"глазик\"") {
            onView(
                allOf(
                    withId(R.id.text_input_end_icon),
                    withParent(withParent(hasSibling(hasFocus())))
                )
            ).perform(click())
        }
    }

    fun checkPasswordTransformationFromDots() {
        step("Проверяем что отображается введенный пароль") {
            onView(
                allOf(
                    withHint(R.string.account_creation_password_hint),
                    isDisplayed()
                )
            ).check(matches(not(isPasswordHidden())))
        }
    }

    fun checkPasswordTransformationToDots() {
        step("Проверяем что отображается введенный пароль") {
            onView(
                allOf(
                    withHint(R.string.account_creation_password_hint),
                    isDisplayed()
                )
            ).check(matches(isPasswordHidden()))
        }
    }

    private fun isPasswordHidden(): Matcher<View?>? {
        return object : BoundedMatcher<View?, EditText>(EditText::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("Password is hidden")
            }

            override fun matchesSafely(editText: EditText): Boolean {
                return editText.transformationMethod is PasswordTransformationMethod
            }
        }
    }

    fun clickNext() {
        step("Нажимаем кнопку \"Далее\"") {
            onView(withId(R.id.create_account_submit_button)).perform(click())
        }
    }

    fun checkRedHintVisible() {
        step("Проверяем, что появилось красное сообщение об ошибке: \"Пароль должен состоять не менее чем из 8 символов\"") {
            onView(withId(R.id.textinput_error)).check(matches(isDisplayed()))
        }
    }

    fun checkRedHeader() {
        step("Проверяем, что у поля \"пароль\" красный заголовок") {
            onView(
                withId(R.id.create_account_password_input)
            ).check(matches(isHeaderRed()))
        }
    }

    fun isHeaderRed(): Matcher<View?>? {
        return object : BoundedMatcher<View?, TextInputLayout>(TextInputLayout::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("is header Red")
            }

            override fun matchesSafely(view: TextInputLayout): Boolean {
                val expectedColor = ContextCompat.getColor(view.context, R.color.red50)
                val factColor = view.errorCurrentTextColors

                return expectedColor == factColor
            }
        }
    }
}