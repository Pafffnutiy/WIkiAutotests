package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class ListOfArticlesScreen {
    fun checkTitleName() {
        step("Проверяем, что название статьи отображается в нем") {
            onView(withText("Российская премьер-лига")).check(matches(isDisplayed()))
        }
    }

    fun longClickOnArticle() {
        step("Лонг-тап по статье из списка") {
            onView(withText("Российская премьер-лига")).perform(longClick())
        }
    }

    fun scrollDown() {
        onView(withId(R.id.reading_list_item_add_to_other)).perform(swipeUp(), swipeUp())
    }

    fun deleteItem() {
        step("Выбираем кнопку удалить") {
            onView(withId(R.id.reading_list_item_remove)/*deleteMatcher()*/).perform(click())
        }
    }

    fun checkAlert() {
        step("Проверяем, что появляется уведомление о том, что список удален") {
            onView(
                allOf(
                    withId(R.id.snackbar_text),
                    isDisplayed()
                )
            ).check(matches(isDisplayed()))
        }
    }
}