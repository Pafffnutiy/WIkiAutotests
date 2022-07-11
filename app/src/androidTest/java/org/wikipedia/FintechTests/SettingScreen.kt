package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.wikipedia.R

class SettingScreen {
    fun clickFeedSettings() {
        step("Нажимаем на кнопку \"Настройка ленты\"") {
            onView(allOf(
                anyOf(
                    withText("Исследователь ленту"),
                    withText("Explore Feed")
                ),
                isDisplayed())).
            perform(click())
        }
    }

    fun clickAbout() {
        step("Нажимаем на \"О приложении «Википедия»\""){
            onView(
                anyOf(
                    withText("О приложении «Википедия»"),
                    withText("About the Wikipedia app")
                )
            ).perform(click())
        }
    }

    fun scrollToBottom(){
            onView(withId(R.id.recycler_view)).perform(ScrollToBottomAction())
    }
}