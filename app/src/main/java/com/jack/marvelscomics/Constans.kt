package com.jack.marvelscomics

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constans {
    const val PUBLIC_API_KEY = "e1c831849f82c3c169c1a6f1068bd790"
    const val PRIVATE_API_KEY = "9d34ce4bc9d8730bb8aa8bcd1b2a1035077b7ba0"

    const val CHARACTER_DETAILS_ARGUMENT_KEY = "characterId"

    val timestamp = Timestamp(System.currentTimeMillis()).time.toString()

    fun hash(): String {
        val input = "$timestamp$PRIVATE_API_KEY$PUBLIC_API_KEY"
        val md  = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}