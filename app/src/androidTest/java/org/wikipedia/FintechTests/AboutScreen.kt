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
        checkSth(R.id.about_contributors,R.string.about_contributors_heading)
    }

    fun checkTranslators() {
        checkSth(R.id.about_translators,R.string.about_translators_heading)
    }

    fun checkLicense() {
        checkSth(R.id.about_app_license,R.string.about_app_license_heading)
    }

    fun checkSth(identifier: Int, text: Int) {
        step("Проверяем, что на экране есть блок \"$text\"") {
            onView(withId(identifier)).check(matches(isDisplayed()))
            onView(withText(text)).check(matches(isDisplayed()))
        }
    }
}