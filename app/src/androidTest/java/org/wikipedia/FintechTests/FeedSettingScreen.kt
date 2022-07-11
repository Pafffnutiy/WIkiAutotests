package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.wikipedia.R

class FeedSettingScreen {
    fun isCheckedAll() {
        isCheckedFeaturedArticle()
        isCheckedTopRead()
        isCheckedPictureOfTheDay()
        isCheckedBecauseYouRead()
        isCheckedInTheNews()
        isCheckedOnThisDay()
        isCheckedRandomizer()
        scrollDown()
        isCheckedTodayOnWiki()
    }

    private fun scrollDown() {
        onView(withId(R.id.content_types_recycler)).perform(ScrollToBottomAction())
    }

    private fun isCheckedSth(ru: String, en: String) {
        step("Проверяем включен ли \"$ru\"") {
            onView(
                allOf(
                    withId(R.id.feed_content_type_checkbox),
                    hasSibling(
                        hasDescendant(
                            anyOf(
                                withText(ru),
                                withText(en)
                            )
                        )
                    ),
                )
            ).check(matches(isChecked()))
        }
    }

    private fun isCheckedFeaturedArticle() {
        isCheckedSth("Избранная статья","Featured article")
    }

    private fun isCheckedTopRead() {
        isCheckedSth("Самое читаемое","Top read")
    }

    private fun isCheckedPictureOfTheDay() {
        isCheckedSth("Изображение дня","Picture of the day")
    }

    private fun isCheckedBecauseYouRead() {
        isCheckedSth("На основе прочитанного","Because you read")
    }

    private fun isCheckedInTheNews() {
        isCheckedSth("В новостях","In the news")
    }

    private fun isCheckedOnThisDay() {
        isCheckedSth("В этот день","On this day")
    }

    private fun isCheckedRandomizer() {
        isCheckedSth("Рандомизатор","Randomizer")
    }

    private fun isCheckedTodayOnWiki() {
        isCheckedSth("Сегодня в Википедии", "Today on Wikipedia")
    }
}