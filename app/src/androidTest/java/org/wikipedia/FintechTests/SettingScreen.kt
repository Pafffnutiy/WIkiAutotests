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
            onView(
                allOf(
                    withText(R.string.preference_title_customize_explore_feed),
                    isDisplayed()
                )
            ).perform(click())
        }
    }

    fun clickAbout() {
        step("Нажимаем на \"О приложении «Википедия»\""){
            onView(
                withText(R.string.about_description)
            ).perform(click())
        }
    }

    fun scrollToBottom(){
            onView(withId(R.id.recycler_view)).perform(ScrollToBottomAction())
    }
}