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
        scrollDown()
        isCheckedRandomizer()
        isCheckedTodayOnWiki()
    }

    private fun scrollDown() {
        onView(withId(R.id.content_types_recycler)).perform(ScrollToBottomAction())
    }

    private fun isCheckedSth(text: Int) {
        step("Проверяем включен ли \"$text\"") {
            onView(
                allOf(
                    withId(R.id.feed_content_type_checkbox),
                    hasSibling(
                        hasDescendant(
                            withText(text)
                        )
                    ),
                )
            ).check(matches(isChecked()))
        }
    }

    private fun isCheckedFeaturedArticle() {
        isCheckedSth(R.string.view_featured_article_card_title)
    }

    private fun isCheckedTopRead() {
        isCheckedSth(R.string.view_top_read_card_title)
    }

    private fun isCheckedPictureOfTheDay() {
        isCheckedSth(R.string.view_featured_image_card_title)
    }

    private fun isCheckedBecauseYouRead() {
        isCheckedSth(R.string.view_because_you_read_card_title)
    }

    private fun isCheckedInTheNews() {
        isCheckedSth(R.string.view_card_news_title)
    }

    private fun isCheckedOnThisDay() {
        isCheckedSth(R.string.on_this_day_card_title)
    }

    private fun isCheckedRandomizer() {
        isCheckedSth(R.string.view_random_card_title)
    }

    private fun isCheckedTodayOnWiki() {
        isCheckedSth(R.string.view_main_page_card_title)
    }
}