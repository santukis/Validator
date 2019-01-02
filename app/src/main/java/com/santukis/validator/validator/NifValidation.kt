package com.santukis.validator.validator

class NifValidation(private val value: String): Validation {

    companion object {
        val DIGITS = 23
        val NIF_LENGTH = 9
        val LETTERS = charArrayOf('T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E')
    }

    override fun isValid(): Boolean  = value.isNotEmpty() && value.isValidCode()

    private fun String.isValidCode(): Boolean {
        if (this.length != NIF_LENGTH) return false

        return if (this.isNIE()) {
            val nie = replaceFirstCharacter(this).plus(this.substring(1, 9))
            checkLastDigit(nie)

        } else {
            checkLastDigit(this)
        }
    }

    private fun replaceFirstCharacter(code: String): String {
        return when(code.toUpperCase().substring(0, 1)) {
            "X" -> "0"
            "Y" -> "1"
            else -> "2"
        }
    }

    private fun String.isNIE() = this.toUpperCase().startsWith("X") ||
            this.toUpperCase().startsWith("Y") ||
            this.toUpperCase().startsWith("Z")

    private fun checkLastDigit(code: String): Boolean {
        try {
            val number = code.substring(0, 8).toInt()
            val modulus = number % DIGITS
            return code.toUpperCase().substring(8) == LETTERS[modulus].toString()

        } catch (exception: Exception) {
            return false
        }
    }

}