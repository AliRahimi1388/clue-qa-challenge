package com.gabrielhuff.sample.login.base

import android.Manifest
import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.gabrielhuff.sample.login.activity.LoginActivity
import com.gabrielhuff.sample.login.utils.TestUtils
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class AndroidTestBase {

    val activityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(
        LoginActivity::class.java,
        false,
        false
    )

    @get:Rule
    val storagePermissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE
        )

    val targetContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    open fun setup() {
        //        TestUtils.pressHome()
    }

    @After
    open fun terminate() {
        TestUtils.closeActivity()
    }

}