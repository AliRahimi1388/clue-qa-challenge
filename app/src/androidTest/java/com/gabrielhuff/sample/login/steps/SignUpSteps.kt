package com.gabrielhuff.sample.login.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.uiautomator.UiSelector
import com.gabrielhuff.sample.login.utils.TestUtils.waitForIt
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import com.gabrielhuff.sample.login.R
import com.gabrielhuff.sample.login.utils.TestUtils
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import org.hamcrest.core.AllOf

interface SignUpSteps {

    fun iClickSignUp() {
        onView(allOf(
            withText(containsString(SIGN_UP_TEXT)),
            withId(R.id.signup),
            isDisplayed()
        ))
            .waitForIt().perform(click())
    }

    fun iInputUsername(username: String) {
        onView(withHint(containsString(USERNAME_TEXT)))
            .waitForIt().perform(replaceText(username), closeSoftKeyboard())
    }

    fun iInputPassword(password: String) {
        onView(withHint(containsString(PASSWORD_TEXT)))
            .waitForIt().perform(replaceText(password), closeSoftKeyboard())
    }

    fun iInputPasswordConfirm(password: String) {
        onView(withHint(containsString(PASSWORD_CONFIRM_TEXT)))
            .waitForIt().perform(clearText(), typeText(password), closeSoftKeyboard())
    }

    fun iShouldNotSeeMisMatchErrorPassword() {
        val postTitleElement = TestUtils.uiDevice.findObject(UiSelector().text("Mismatch"))
        assertFalse(postTitleElement.exists())
    }

    fun iShouldSeeMisMatchErrorPassword() {
        val postTitleElement = TestUtils.uiDevice.findObject(UiSelector().text("Mismatch"))
        assertNotNull(postTitleElement)
    }

    companion object {
        const val SIGN_UP_TEXT = "Sign up"
        const val USERNAME_TEXT = "Username"
        const val PASSWORD_TEXT = "Password"
        const val PASSWORD_CONFIRM_TEXT = "Confirm password"
    }
}