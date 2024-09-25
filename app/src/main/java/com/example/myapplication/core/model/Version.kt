package com.example.myapplication.core.model

import android.content.Context

open class Version(val context: Context, open var newVersion: String = "", open var oldVersion: String = "") {

    fun isNewVersion(): Boolean {
        return newVersion.toDouble() > oldVersion.toDouble()
    }

}