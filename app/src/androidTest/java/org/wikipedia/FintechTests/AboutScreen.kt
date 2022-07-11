package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.anyOf
import org.wikipedia.R

class AboutScreen {
    fun checkBlocks() {
        checkContributors()
        checkTranslators()
        checkLicense()
    }

    fun checkContributors() {
        checkSth(R.id.about_contributors,"Авторы","Contributors")
    }

    fun checkTranslators() {
        checkSth(R.id.about_translators,"Переводчики","Translators")
    }

    fun checkLicense() {
        checkSth(R.id.about_app_license,"Лицензия","License")
    }

    fun checkSth(identifier: Int, ru: String, en: String) {
        step("Проверяем, что на экране есть блок \"$ru\"") {
            onView(withId(identifier)).check(matches(isDisplayed()))
            onView(
                anyOf(
                    withText(ru),
                    withText(en)
                )
            ).check(matches(isDisplayed()))
        }
    }
}