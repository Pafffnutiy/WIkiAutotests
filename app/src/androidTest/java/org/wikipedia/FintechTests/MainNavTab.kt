package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class MainNavTab {
    fun clickMore() {
        step("Нажатие на кнопку \"Ещё\"") {
            onView(
                allOf(
                    withId(R.id.menu_icon),
                    isDisplayed()
                )
            ).perform(ViewActions.click())
        }
    }
}