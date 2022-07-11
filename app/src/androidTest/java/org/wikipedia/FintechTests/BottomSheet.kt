package org.wikipedia.FintechTests

import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.matcher.IntentMatchers.anyIntent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.allOf
import org.wikipedia.R


class BottomSheet {
    fun clickLogIn() {
        step("Нажимаем на \"Войти / Присоединиться\"") {
            onView(allOf(withId(R.id.main_drawer_account_container), isDisplayed())).perform(click())
        }
    }

    fun clickSetting() {
        step("Нажимаем на \"Настройки\"") {
            onView(allOf(withId(R.id.main_drawer_settings_container), isDisplayed())).perform(click())
        }
    }

    fun clickDonate() {
        step("Нажимаем на \"Пожертвовать\"") {
            onView(allOf(withId(R.id.main_drawer_donate_container), isDisplayed())).perform(click())
        }
    }

    fun checkToBrowser() {
        step("Переходим в браузер") {
            anyIntent().matches(hasData(Uri.parse("https://donate.wikimedia.org")))
        }
    }
}