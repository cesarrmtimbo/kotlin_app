package com.example.myapplication.features.login.data.viewmodel

import Blast
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.preferencesDataStore
import com.example.myapplication.features.login.data.model.tags.request.USER_PREFS
import com.example.myapplication.features.login.data.repository.LoginRepository
import com.example.myapplication.network.server.ServerRequest.OnErrorListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow

class LoginCubit(loginRepository: LoginRepository) : OnErrorListener {

    val Context.dataStore by preferencesDataStore(name = USER_PREFS)
    var scope: CoroutineScope? = null
    var userName: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    private val loginRepository = loginRepository

    private var b: Blast? = null
    override var showPop = MutableStateFlow(b)

    init {
        loginRepository.onLoginErrorCallback = this
    }

    suspend fun enterBtClick() {
        loginRepository.setLogin(userName.value)
        loginRepository.setPass(password.value)
        loginRepository.authRequest()
    }

    override fun onError(e: Blast) {
        loginRepository.showPop = showPop
        loginRepository.showPop.value = e
    }

    override fun closePop() {
        loginRepository.closePop()
    }
}