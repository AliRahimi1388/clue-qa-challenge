package com.gabrielhuff.sample.login.modules

import android.app.Activity
import androidx.test.rule.ActivityTestRule
import com.gabrielhuff.sample.login.steps.BaseSteps
import com.gabrielhuff.sample.login.steps.LoginSteps

class LoginModule(
    activityRule: ActivityTestRule<out Activity>,
) : BaseSteps(activityRule),
    LoginSteps