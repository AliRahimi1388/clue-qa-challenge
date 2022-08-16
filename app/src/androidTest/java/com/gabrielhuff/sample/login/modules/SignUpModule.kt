package com.gabrielhuff.sample.login.modules

import android.app.Activity
import androidx.test.rule.ActivityTestRule
import com.gabrielhuff.sample.login.steps.BaseSteps

class SignUpModule(
    activityRule: ActivityTestRule<out Activity>,
) : BaseSteps(activityRule)