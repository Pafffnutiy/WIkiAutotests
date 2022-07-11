package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
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
            ).perform(click())
        }
    }

    fun clickSaved() {
        step("Нажимаем кнопку \"Сохранено\"") {
            onView(
                withId(R.id.nav_tab_reading_lists)
            ).perform(click())
        }
    }
}