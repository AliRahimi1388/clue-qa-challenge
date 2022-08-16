package com.gabrielhuff.sample.login.steps

import android.app.Activity
import androidx.test.rule.ActivityTestRule
import com.gabrielhuff.sample.login.activity.LoggedInActivity
import com.gabrielhuff.sample.login.activity.LoginActivity
import com.gabrielhuff.sample.login.activity.SignUpActivity

import org.junit.Assert

open class BaseSteps(
    private val activityRule: ActivityTestRule<out Activity>,
) {

    private fun getActivity(): Activity {
        return activityRule.activity
    }

    fun iHaveLoginActivity() {
        Assert.assertNotNull(getActivity())
        assert(getActivity() is LoginActivity)
    }

    fun iHaveLoggedInActivity() {
        Assert.assertNotNull(getActivity())
        assert(getActivity() is LoggedInActivity)
    }

    fun iHaveSignUpActivity() {
        Assert.assertNotNull(getActivity())
        assert(getActivity() is SignUpActivity)
    }


}
