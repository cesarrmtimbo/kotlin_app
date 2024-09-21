package com.example.myapplication.features.login.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.myapplication.features.login.data.viewmodel.LoginCubit

@Composable
fun PopUpError(cubit: LoginCubit) {
    val show by cubit.showPop.collectAsState()

    if((show != null)){
        AlertDialog(
            onDismissRequest = { show == null },
            title = {
                Text(text = show?.title ?: "")
            },
            text = {
                Text(show?.msg ?: "")
            },
            confirmButton = {
                TextButton(onClick = { cubit.closePop() }) {
                    Text("OK")
                }
            }
        )
    }

}