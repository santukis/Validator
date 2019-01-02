package com.santukis.validator.validator

interface Callback<T> {

    fun onSuccess(value: T)

    fun onError(value: String)
}