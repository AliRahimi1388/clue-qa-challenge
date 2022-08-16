package activity

import android.content.Intent
import com.gabrielhuff.sample.login.base.AndroidTestBase
import com.gabrielhuff.sample.login.modules.LoginModule
import com.gabrielhuff.sample.login.modules.SignUpModule
import org.junit.After
import org.junit.Before
import org.junit.Test

class SignUpAndLoginTest : AndroidTestBase() {

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
    fun signUpTest() {
        val usernameToSignUp = "username" + (0..100).random()
        val passwordToSignUp = "12345678"
        with(SignUpModule(activityRule)) {
            iHaveLoginActivity()
            iClickSignUp()
            iInputUsername(usernameToSignUp)
            iInputPassword(passwordToSignUp)
            iInputPasswordConfirm(passwordToSignUp)
            iClickSignUp()
        }
    }

    @Test
    fun loginTest() {
        val usernameToSignUp = "nex1388"
        val passwordToSignUp = "123456"
        with(LoginModule(activityRule)) {
            iHaveLoginActivity()
            iInputUsername(usernameToSignUp)
            iInputPassword(passwordToSignUp)
            iClickLoginButton()
        }
    }

    @Test
    fun signUpWithMisMatchConfirmPasswordToSeeErrorMessageTest() {
        val usernameToSignUp = "username" + (0..100).random()
        val passwordToSignUp = "12345678"
        val missMatchPasswordToSignUp = "123456"
        with(SignUpModule(activityRule)) {
            iHaveLoginActivity()
            iClickSignUp()
            iInputUsername(usernameToSignUp)
            iInputPassword(passwordToSignUp)
            iInputPasswordConfirm(missMatchPasswordToSignUp)
            iShouldSeeMisMatchErrorPassword()
            iInputPasswordConfirm(passwordToSignUp)
            iShouldNotSeeMisMatchErrorPassword()
            iClickSignUp()
        }
    }
}
