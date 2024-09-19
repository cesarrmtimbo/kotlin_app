package com.example.myapplication.features.login.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.features.login.data.viewmodel.LoginCubit
import kotlinx.coroutines.launch

@Composable
fun LoginRequestButton(cubit: LoginCubit) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        modifier = Modifier
            .size(260.dp, 50.dp)
            .border(
                color = Color.LightGray,
                width = 1.dp,
                shape = CircleShape
            ),
        onClick = {
            if (cubit.scope != null)
                cubit.scope!!.launch {
                    cubit.enterBtClick()
                }
        }) {
        Text("Enter", color = Color.LightGray)
    }
}