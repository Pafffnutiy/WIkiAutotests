package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.anyOf
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
        onView(withId(R.id.reading_list_item_share)).perform(swipeUp(), swipeUp())
    }

    fun deleteItem() {
        step("Выбираем кнопку удалить") {
            onView(
                anyOf(
                    withText("Remove from Name of list"),
                    withText("Удалить из Name of list")
                )
            ).perform(click())
        }
    }

    fun checkAlert() {
        step("Проверяем, что появляется уведомление о том, что список удален") {
            onView(
                anyOf(
                    withText("Российская премьер-лига удалена из Name of list"),
                    withText("Российская премьер-лига removed from Name of list")
                )
            ).check(matches(isDisplayed()))
        }
    }
}