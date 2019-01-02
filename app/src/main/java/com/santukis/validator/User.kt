package com.santukis.validator

data class User(
    val name: String = "",
    val lastName: String = "",
    val nif: String = "",
    val email: String = "",
    val password: String = "",
    val repeatedPassword: String = ""
) {
    companion object {
        const val NAME = "name"
        const val LAST_NAME = "lastName"
        const val NIF = "nif"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val REPEATED_PASSWORD = "repeatedPassword"
    }
}