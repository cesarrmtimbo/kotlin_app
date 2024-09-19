package com.example.myapplication.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.core.shared.persets.PerSet
import com.example.myapplication.features.login.data.repository.LoginRepository
import com.example.myapplication.features.login.data.viewmodel.LoginCubit
import com.example.myapplication.features.login.ui.layouts.LoginLayout
import com.example.myapplication.network.server.OnLoginCallback

class BeginActivity : ComponentActivity(), OnLoginCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repo = LoginRepository(this)
        setContent {
            repo.onLoginCallback = this
            LoginLayout(LoginCubit(this, repo))
        }
    }

    override fun onLoginSuccess(online: Boolean) {
        PerSet(this).setOnline(online)
        initApp()
    }

    fun initApp(){
        //todo init app
    }
}

