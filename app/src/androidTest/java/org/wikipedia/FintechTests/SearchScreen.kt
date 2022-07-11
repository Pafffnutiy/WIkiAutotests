package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.allOf

class SearchScreen {
    fun clickOnArticle() {
        step("Открываем статью") {
            onView(
                allOf(
                    withText("Российская премьер-лига"),
                    isDisplayed()
                )
            ).perform(click())
        }
    }
}