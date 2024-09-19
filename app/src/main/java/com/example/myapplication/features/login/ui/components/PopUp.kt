package com.example.myapplication.features.login.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.myapplication.features.login.data.viewmodel.LoginCubit

@Composable
fun PopUp(cubit: LoginCubit) {
    var showDialog by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = { showDialog = cubit.b == null },
        title = {
            Text(text = cubit.b?.title ?: "")
        },
        text = {
            Text(cubit.b?.msg ?: "")
        },
        confirmButton = {
            TextButton(onClick = { showDialog = false }) {
                Text("OK")
            }
        }
    )
}