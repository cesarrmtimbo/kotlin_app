package com.example.myapplication.core.shared.persets

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.example.myapplication.features.login.data.model.tags.request.SHARED_SETTINGS
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.Date

open class RootSet(context: Context) {

    private val context = context

    private val settingsName = SHARED_SETTINGS

    open val prefs: SharedPreferences = context.getSharedPreferences(settingsName, Context.MODE_PRIVATE)

    open val editor: Editor = prefs.edit()

    open val gson: Gson = GsonBuilder().setPrettyPrinting().create()

    fun getInt(tag: String, i: Int) : Int {
        if(!prefs.contains(tag)){
           putInt(tag, i)
        }
        return prefs.getInt(tag, i)
    }

    fun putString(tag: String, value: String) {
        editor.putString(tag, value)
        editor.commit()
    }

    fun getString(tag: String, def: String): String? {
        return prefs.getString(tag, def)
    }

    fun getInt(tag: String): Int {
        return prefs.getInt(tag, 0)
    }

    fun putInt(tag: String, value: Int) {
        editor.putInt(tag, value)
        editor.commit()
    }

    fun putBoolean(tag: String, value: Boolean) {
        editor.putBoolean(tag, value)
        editor.commit()
    }

    fun getBoolean(tag: String, def: Boolean): Boolean {
        return prefs.getBoolean(tag, def)
    }

    fun putDate(tag: String, value: Date) {
        editor.putLong(tag, value.time)
        editor.commit()
    }

    fun getDate(tag: String): Date {
        return Date(prefs.getLong(tag, 0))
    }

    fun putFloat(tag: String, value: Float) {
        editor.putFloat(tag, value)
        editor.commit()
    }

    fun getFloat(tag: String, i: Float): Float {
        return prefs.getFloat(tag, i)
    }

}