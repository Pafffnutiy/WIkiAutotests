package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers.anyOf
import org.wikipedia.R

class MainScreen {
    fun searchArticle() {
        val article = "Тинькофф премьер лига"
        step("Вводим в поле поиска \"$article\"") {
            onView(
                withId(R.id.search_container)
            ).perform(click())

            clickOnRu()

            onView(
                anyOf(
                    withHint("Поиск по Википедии"),
                    withHint("Search Wikipedia")
                )
            ).perform(replaceText(article))
        }
    }

    private fun clickOnRu(){
        onView(withText("русский")).perform(click())
    }
}