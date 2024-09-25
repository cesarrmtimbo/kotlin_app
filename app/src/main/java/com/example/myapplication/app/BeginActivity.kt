package com.example.myapplication.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.core.model.Version
import com.example.myapplication.core.network.OnVersionListener
import com.example.myapplication.core.network.PlayVersion
import com.example.myapplication.core.shared.persets.PerSet
import com.example.myapplication.features.login.data.repository.LoginRepository
import com.example.myapplication.features.login.data.viewmodel.LoginCubit
import com.example.myapplication.features.login.ui.layouts.LoginLayout
import com.example.myapplication.network.server.OnLoginCallback

class BeginActivity : ComponentActivity(), OnLoginCallback, OnVersionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repo = LoginRepository(this)
        checkVersion()
        setContent {
            repo.onLoginCallback = this
            LoginLayout(LoginCubit(repo))
        }
    }

    override fun onLoginSuccess(online: Boolean) {
        PerSet(this).setOnline(online)
        initApp()
    }

    fun initApp(){
        //todo init app
    }

    override fun onVersion(version: Version) {
        if(version.isNewVersion()){
            PlayVersion(this).openAppInPlayStore(this)
        }
    }

    private fun checkVersion(){
        val version = PlayVersion(this)
        version.onVersionListener = this
        version.executeTask()
    }
}

