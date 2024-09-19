package com.example.myapplication.core.utils

import android.util.Base64

class Utils {

    open fun decrypt(value: String?) : String? {
        return if(value == null){
            return null
        } else {
            return String(Base64.decode(value, Base64.DEFAULT), Charsets.UTF_8)
        }
    }

    open fun encrypt(value: String?) : String? {
        return if(value == null){
            return null
        } else {
            Base64.encodeToString(value.toByteArray(), Base64.DEFAULT)
        }
    }

}