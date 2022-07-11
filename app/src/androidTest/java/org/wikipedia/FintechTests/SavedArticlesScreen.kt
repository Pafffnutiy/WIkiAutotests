package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.*
import org.wikipedia.R

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

    fun clickNotNow() {
        onView(withText(R.string.reading_lists_ignore_button)).perform(click())
    }
}