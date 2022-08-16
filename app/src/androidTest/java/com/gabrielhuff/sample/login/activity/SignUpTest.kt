package activity

import android.content.Intent
import com.gabrielhuff.sample.login.base.AndroidTestBase
import com.gabrielhuff.sample.login.modules.SignUpModule
import org.junit.After
import org.junit.Before
import org.junit.Test

class SignUpTest : AndroidTestBase() {


    @Before
    override fun setup() {
        super.setup()
        activityRule.launchActivity(Intent())
    }

    @After
    override fun terminate() {
        super.terminate()
    }

    @Test
    fun signUpAndCheckSignedIn() {
        with(SignUpModule(activityRule)) {
            iHaveLoginActivity()
        }

    }
}
