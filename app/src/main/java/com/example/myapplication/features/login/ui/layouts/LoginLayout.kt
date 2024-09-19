package com.example.myapplication.features.login.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.features.login.data.viewmodel.LoginCubit
import com.example.myapplication.features.login.ui.components.LoginRequestButton
import com.example.myapplication.features.login.ui.components.PopUp
import com.example.myapplication.features.login.ui.theme.MyApplicationTheme

@Composable
fun LoginLayout(cubit: LoginCubit) {
    var context = LocalContext.current
    cubit.scope = rememberCoroutineScope()

    MyApplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Surface(
                color = Color.LightGray,
                modifier = Modifier.padding(innerPadding),
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "BackgroundLogin",
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .size(380.dp)
                            .padding(16.dp)
                            .background(Color.DarkGray.copy(alpha = 0.5f))
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                "Login",
                                style = androidx.compose.ui.text.TextStyle(
                                    color = Color.White,
                                    fontSize = TextUnit(value = 45f, type = TextUnitType.Sp),
                                ),
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Color.White,
                                        RoundedCornerShape(8.dp)
                                    )
                                    .padding(8.dp)
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            TextField(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                label = { Text("Nome de usuário") },
                                value = cubit.userName.value,
                                onValueChange = {
                                    cubit.userName.value = it
                                },
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            TextField(
                                label = { Text("Senha") },
                                value = cubit.password.value,
                                onValueChange = {
                                    cubit.password.value = it
                                },
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            LoginRequestButton(cubit = cubit)    
                        }
                    }
                }
            }
        }
    }
}