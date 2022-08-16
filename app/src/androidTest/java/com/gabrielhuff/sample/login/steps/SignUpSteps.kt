package com.gabrielhuff.sample.login.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.gabrielhuff.sample.login.utils.TestUtils.waitForIt
import org.hamcrest.Matchers.containsString

interface SignUpSteps {

    fun iClickSignUp() {
        onView(withText(containsString(SIGN_UP_TEXT)))
            .waitForIt().perform(click())
    }

    fun iInputUsername(username: String) {
        onView(withHint(containsString(USERNAME_TEXT)))
            .waitForIt().perform(typeText(username), closeSoftKeyboard())
    }

    fun iInputPassword(password: String) {
        onView(withHint(containsString(PASSWORD_TEXT)))
            .waitForIt().perform(typeText(password), closeSoftKeyboard())
    }

    fun iInputPasswordConfirm(password: String) {
        onView(withHint(containsString(PASSWORD_CONFIRM_TEXT)))
            .waitForIt().perform(typeText(password), closeSoftKeyboard())
    }

    companion object {
        const val SIGN_UP_TEXT = "Sign up"
        const val USERNAME_TEXT = "Username"
        const val PASSWORD_TEXT = "Password"
        const val PASSWORD_CONFIRM_TEXT = "Confirm password"
    }
}