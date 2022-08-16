package com.gabrielhuff.sample.login.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.gabrielhuff.sample.login.utils.TestUtils.waitForIt
import org.hamcrest.Matchers

interface LoginSteps {

    fun iInputUsername(username: String) {
        Espresso.onView(ViewMatchers.withHint(Matchers.containsString(SignUpSteps.USERNAME_TEXT)))
            .waitForIt().perform(ViewActions.typeText(username), ViewActions.closeSoftKeyboard())
    }

    fun iInputPassword(password: String) {
        Espresso.onView(ViewMatchers.withHint(Matchers.containsString(SignUpSteps.PASSWORD_TEXT)))
            .waitForIt().perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())
    }

    fun iClickLoginButton() {
        Espresso.onView(ViewMatchers.withText(Matchers.containsString(LOGIN_TEXT)))
            .waitForIt().perform(ViewActions.click())
    }

    companion object {
        const val LOGIN_TEXT = "Login"
    }
}