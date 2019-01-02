package com.santukis.validator.validator

import java.util.regex.Pattern

class EmailValidation(private val value: String): Validation {

    override fun isValid(): Boolean  = value.isNotEmpty() && value.isValidEmail()

    private fun String.isValidEmail(): Boolean {
        return Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        ).matcher(this).matches()
    }

}