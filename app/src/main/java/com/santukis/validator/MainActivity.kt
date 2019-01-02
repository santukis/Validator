package com.santukis.validator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.santukis.validator.validator.Callback
import com.santukis.validator.validator.UserValidator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val validator = UserValidator()
    private val requiredFields = mutableMapOf<String, EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requiredFields[User.NAME] = name
        requiredFields[User.LAST_NAME] = last_name
        requiredFields[User.NIF] = nif
        requiredFields[User.EMAIL] = email
        requiredFields[User.PASSWORD] = password
        requiredFields[User.REPEATED_PASSWORD] = repeated_password

        validate.setOnClickListener {
            val user = User(
                name = name.text.toString(),
                lastName = last_name.text.toString(),
                nif = nif.text.toString(),
                email = email.text.toString(),
                password = password.text.toString(),
                repeatedPassword = repeated_password.text.toString()
            )

            validator.validate(user, object : Callback<Unit> {
                override fun onSuccess(value: Unit) {
                    Toast.makeText(this@MainActivity, "UserValidated", Toast.LENGTH_LONG).show()
                }

                override fun onError(value: String) {
                    val error = when(value) {
                        User.NAME, User.LAST_NAME -> "This field can't be empty"
                        User.NIF -> "Nif is bad constructed"
                        User.EMAIL -> "Email must be instance@example.com"
                        User.PASSWORD -> "Password must contain at least 8 characters, one capital letter and one number"
                        User.REPEATED_PASSWORD -> "The password and repeated password don't match"
                        else -> ""
                    }

                    val view = requiredFields[value]
                    view?.error = error
                }
            })
        }
    }
}
