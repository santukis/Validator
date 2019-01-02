package com.santukis.validator.validator

import java.util.regex.Pattern

class PasswordValidation(private val value: String): Validation {

    override fun isValid(): Boolean  = value.isNotEmpty() && value.isValidPassword()

    private fun String.isValidPassword(): Boolean {
        val PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}"
        val pattern = Pattern.compile(PASSWORD_PATTERN)
        return pattern.matcher(this).matches()
    }

}