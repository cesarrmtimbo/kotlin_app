package com.example.myapplication.core.shared

import android.content.Context
import android.content.pm.PackageManager
import com.example.myapplication.features.login.data.model.tags.request.VERSION_NOT_FOUND

const val DEVICE_ID = "DEVICE_ID"
const val DEVICE_PREFS = "device_prefs"

class LocalPersistence(context: Context) {

    private val context = context

    fun getOpenUIID(): String {
        val sharedPreferences = context.getSharedPreferences(DEVICE_PREFS, Context.MODE_PRIVATE)
        val openUIID = sharedPreferences.getString(DEVICE_ID, "") ?: ""
        if (openUIID == "") {
            val newOpenUIID = java.util.UUID.randomUUID().toString()
            sharedPreferences.edit().putString(DEVICE_ID, newOpenUIID).apply()
            return newOpenUIID
        }
        return openUIID
    }

    fun getAppVersion(): String {
        return try {
            val packInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            val version = packInfo.versionName
            version
        } catch (e: PackageManager.NameNotFoundException) {
            VERSION_NOT_FOUND
        }
    }

}