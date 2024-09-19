package com.example.myapplication.core.utils


class RequestUtils {

    fun encrypt(str: String): String {
        return String(android.util.Base64.encode(str.toByteArray() , android.util.Base64.DEFAULT))
    }

    fun decrypt(str: String): String {
        return String(android.util.Base64.decode(str.toByteArray() , android.util.Base64.DEFAULT))
    }

}