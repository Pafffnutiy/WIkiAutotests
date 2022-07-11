package org.wikipedia.FintechTests

import android.content.res.ColorStateList
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
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
        closeKeyboard()
    }

    private fun fillUsernameField() {
        step("Заполняем поле имени") {
            onView(
                allOf(
                    anyOf (
                        withHint("Имя участника"),
                        withHint("Username")
                    ),
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
                    anyOf(
                        withHint("Password"),
                        withHint("Пароль")
                    ),
                    isDisplayed()
                )
            ).perform(click(), typeText(PASSWORD))
        }
    }

    fun fillRepeatPasswordField() {
        step("Заполняем поле повтора пароля") {
            onView(
                allOf(
                    anyOf(
                        withHint("Repeat password"),
                        withHint("Повторите пароль")
                    ),
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
                    anyOf(
                        withHint("Password"),
                        withHint("Пароль")
                    ),
                    isDisplayed()
                )
            ).check(matches(not(isPasswordHidden())))
        }
    }

    fun checkPasswordTransformationToDots() {
        step("Проверяем что отображается введенный пароль") {
            onView(
                allOf(
                    anyOf(
                        withHint("Password"),
                        withHint("Пароль")
                    ),
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
                allOf(
                    //withId(R.id.create_account_password_repeat),
                    anyOf(
                        withHint("Repeat password"),
                        withHint("Повторите пароль")
                    ),
                    isDisplayed()
                )
            ).check(matches(isHeaderRed(R.color.red50)))
        }
    }

    private fun isHeaderRed(expectedColor: Int): Matcher<View?>? {
        return object : BoundedMatcher<View?, EditText>(EditText::class.java) {

            override fun describeTo(description: Description) {
                description.appendText("header is red")
            }

            override fun matchesSafely(editText: EditText): Boolean {
                val t1 = editText.hintTextColors
                val t2 = ColorStateList.valueOf(R.color.red50)
                return editText.hintTextColors == ColorStateList.valueOf(R.color.red50)
            }
        }
    }

    fun closeKeyboard() {
        onView(
            isRoot()
        ).perform((closeSoftKeyboard()))
    }

    /*fun isHeaderRed(expectedColor: Int): Matcher<View> = object : TypeSafeMatcher<View>() {

        override fun describeTo(description: Description?) {
            description?.appendText("header is red")
        }

        override fun matchesSafely(item: View?): Boolean {
            if (item !is TextInputLayout) return false
            val t1 = item.hintTextColor
            val t2 = ColorStateList.valueOf(expectedColor)
            return true
        }
    }*/


/*    fun hasTextInputLayoutHintText(expectedErrorText: String): Matcher<View?> =
        object : TypeSafeMatcher<View?,TextInputLayout>() {
            //private fun isHeaderRed(): Matcher<View?>? {
            //  return object : BoundedMatcher<View?, TextInputLayout>(TextInputLayout::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("Header is red")
            }

            override fun matchesSafely(item: TextInputLayout): Boolean {
                val t = item.context.getColor(R.color.red50)
                //item.setHintTextColor(R.color.red50)
                item.defaultHintTextColor = ColorStateList(null, R.color.red50)

                val error = item.hint ?: return false
                val hint = error.toString()
                return expectedErrorText == hint
            }
            /*
            override fun matchesSafely(editText: EditText): Boolean {
                //println(editText.hintTextColors.defaultColor)
                //return true
                //editText.hint

                //R.attr.colorError
                //val sth1 = editText.getHint()
                //editText.setHintTextColor(R.color.red50)
                val sth = editText.hintTextColors//.getColorForState(null,R.attr.colorError);
                return true
                //return (editText.hintTextColors.getColorForState(null, R.attr.colorError) == -6116943)
            }*/
        }
    //}*/
}

