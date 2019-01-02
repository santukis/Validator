package com.santukis.validator.validator

class EmptyValidation(private val value: String): Validation {

    override fun isValid(): Boolean  = value.isNotEmpty()

}