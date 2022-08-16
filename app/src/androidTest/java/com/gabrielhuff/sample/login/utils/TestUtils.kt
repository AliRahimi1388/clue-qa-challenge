package com.gabrielhuff.sample.login.utils

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.NoActivityResumedException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import java.lang.Exception

object TestUtils {

    val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    fun iClickBackUiAutomator() = uiDevice.pressBack()

    fun closeActivity() {
        val nTimeIteration = 10
        try {
            for (i in 0 until nTimeIteration) {
                pressBack()
            }
        } catch (e: NoActivityResumedException) {
            Log.i(TestUtils::class.java.simpleName, "Unable to close activities", e)
        }
    }

    fun getTextOfResource(@StringRes resourceId: Int): String {
        return InstrumentationRegistry.getInstrumentation().targetContext.getString(resourceId)
    }

    fun pressHome() = uiDevice.pressHome()

    fun ViewInteraction.isDisplayed(): Throwable? {
        return try {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            null
        } catch (throwable: Throwable) {
            throwable
        }
    }

    fun ViewInteraction.waitForIt(timeOut: Int = WAIT_TIMEOUT): ViewInteraction {
        var displayError = this.isDisplayed()

        val startTime = System.currentTimeMillis()
        while (displayError != null) {
            try {
                Thread.sleep(WAIT_CHECK_INTERVAL.toLong())
            } catch (e: InterruptedException) {
                throw RuntimeException(e)
            }

            if (System.currentTimeMillis() - startTime > timeOut) {
                val throwable = Exception("Wait timeout: ${displayError.toString().lines()[0]}")
                throwable.stackTrace = displayError.stackTrace
                throw throwable
            }
            displayError = this.isDisplayed()
        }
        return this
    }

    fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int,
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

    private const val WAIT_TIMEOUT = 10000
    private const val WAIT_CHECK_INTERVAL = 200

}
