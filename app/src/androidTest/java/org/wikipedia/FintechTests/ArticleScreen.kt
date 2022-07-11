package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.wikipedia.R

class ArticleScreen {
    fun clickSave() {
        step("Нажимаем на кнопку \"Сохранить\"") {
            onView(withId(R.id.page_save)).perform(click())
        }
    }

    fun clickAddToList() {
        step("Нажимаем в диалоговом окне \"Добавить в список\"") {
            onView(withText(R.string.reading_list_add_to_list_button)).perform(click())
        }
    }

    fun writeListName() {
        step("В новом окне вводим название списка") {
            onView(
                allOf(
                    withId(R.id.text_input),
                    isDisplayed()
                )
            ).perform(typeText("Name of list"))
        }
    }

    fun clickOkButton() {
        step("Нажимаем ОК") {
            onView(
                allOf(
                    withText(R.string.reading_list_split_dialog_ok_button_text),
                    isDisplayed()
                )
            ).perform(click())
        }
    }
}