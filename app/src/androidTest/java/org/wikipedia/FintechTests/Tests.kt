package org.wikipedia.FintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import io.qameta.allure.kotlin.Allure.step
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Epic
import io.qameta.allure.kotlin.junit4.DisplayName
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters
import org.wikipedia.R
import org.wikipedia.main.MainActivity

//Знаю, что задавать порядок - ужасно,
// но с вовзратом в приложение после перехода в браузер так и не разобрался
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Epic("Fintech")
class Tests {
    @get:Rule
    val activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun skipOnboardings() {
        Intents.init()
        step("Пропускаем онбординги") {
            onView(withId(R.id.fragment_onboarding_skip_button)).perform(click())
        }
    }

    @Test
    @AllureId("1")
    @DisplayName("Проверка перехода в браузер")
    fun zmoreToBrowser(){
        MainNavTab().clickMore()
        //BottomSheet().clickDonate()
        BottomSheet().checkToBrowser()
    }

    @Test
    @AllureId("2")
    @DisplayName("Проверка настройки ленты по умолчанию")
    fun checkDefault(){
        MainNavTab().clickMore()
        BottomSheet().clickSetting()
        SettingScreen().clickFeedSettings()
        FeedSettingScreen().isCheckedAll()
    }

    @Test
    @AllureId("3")
    @DisplayName("Проверка блоков на экране \"О приложении\"")
    fun checkAbout(){
        MainNavTab().clickMore()
        BottomSheet().clickSetting()
        SettingScreen().scrollToBottom()
        SettingScreen().clickAbout()
        AboutScreen().checkBlocks()
    }

    @Test
    @AllureId("4")
    @DisplayName("Проверка, что пароль скрывается, если нажать на глазик два раза")
    fun isPasswordHidden(){
        MainNavTab().clickMore()
        BottomSheet().clickLogIn()
        CreateAnAccountScreen().fillPasswordField()
        CreateAnAccountScreen().clickEyeOnPassword()
        CreateAnAccountScreen().checkPasswordTransformationFromDots()
        CreateAnAccountScreen().clickEyeOnPassword()
        CreateAnAccountScreen().checkPasswordTransformationToDots()
    }

    @Test
    @AllureId("5")
    @DisplayName("Проверка валидации поля установки пароля")
    fun redHintsAfterIncorrectPassword(){
        MainNavTab().clickMore()
        BottomSheet().clickLogIn()
        CreateAnAccountScreen().fillForm()
        CreateAnAccountScreen().clickNext()
        //CreateAnAccountScreen().checkRedHeader()
        CreateAnAccountScreen().checkRedHintVisible()
        //Thread.sleep(10000)

    }


}