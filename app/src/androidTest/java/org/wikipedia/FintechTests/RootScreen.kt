package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import io.qameta.allure.kotlin.Allure

class RootScreen {
    fun closeKeyboard() {
        onView(
            isRoot()
        ).perform((ViewActions.closeSoftKeyboard()))
    }

    fun clickBackButton() {
        Allure.step("Нажимаем Назад") {
            onView(isRoot()).perform(ViewActions.pressBack())
        }
    }
}