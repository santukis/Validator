package com.santukis.validator.validator

abstract class Validator<T> {

    fun validate(field: T, callback: Callback<Unit>) {
        val validations = createValidations(field)
        var validated = true

        for ((key, value) in validations) {
            if (!value.isValid()) {
                callback.onError(key)
                validated = false
            }
        }

        if (validated) callback.onSuccess(Unit)
    }

    abstract fun createValidations(field: T): MutableMap<String, Validation>
}