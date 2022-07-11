package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.endsWith

class SavedArticlesScreen {
    fun clickOnList() {
        step("Нажимаем на наш список") {
            onView(
                allOf(
                    withClassName(endsWith("ReadingListItemView")),
                    hasDescendant(withText("Name of list"))
                )
            ).perform(click())
        }
    }
}