package com.santukis.validator.validator

class MatchValidation(private val firstValue: String,
                      private val secondValue: String): Validation {

    override fun isValid(): Boolean  = firstValue == secondValue

}