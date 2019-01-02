package com.santukis.validator.validator

import com.santukis.validator.User

class UserValidator: Validator<User>() {

    override fun createValidations(field: User): MutableMap<String, Validation> {
        val validations = mutableMapOf<String, Validation>()

        validations[User.NAME] =
                EmptyValidation(field.name)
        validations[User.LAST_NAME] =
                EmptyValidation(field.lastName)
        validations[User.NIF] =
                NifValidation(field.nif)
        validations[User.EMAIL] =
                EmailValidation(field.email)
        validations[User.PASSWORD] =
                PasswordValidation(field.password)
        validations[User.REPEATED_PASSWORD] =
                MatchValidation(field.password, field.repeatedPassword)

        return validations
    }
}