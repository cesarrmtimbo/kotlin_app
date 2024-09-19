package com.example.myapplication.features.login.ui.components

import android.content.Context
import android.widget.Toast

fun myToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}