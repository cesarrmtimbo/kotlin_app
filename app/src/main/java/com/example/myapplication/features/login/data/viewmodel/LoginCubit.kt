package com.example.myapplication.features.login.data.viewmodel

import Blast
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.preferencesDataStore
import com.example.myapplication.features.login.data.model.tags.request.USER_PREFS
import com.example.myapplication.features.login.data.repository.LoginRepository
import com.example.myapplication.features.login.ui.components.myToast
import com.example.myapplication.network.server.ServerRequest
import kotlinx.coroutines.CoroutineScope


class LoginCubit(private val context: Context, loginRepository: LoginRepository) :
    ServerRequest.OnErrorListener {

    var scope: CoroutineScope? = null
    val loginRepository = loginRepository
    open var b: Blast? = null

    val Context.dataStore by preferencesDataStore(name = USER_PREFS)

    var userName: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")

    suspend fun enterBtClick() {
        loginRepository.onLoginErrorCallback = this
        loginRepository.makeRequest();
        myToast(
            context = context,
            message = "Enviando dados de login, aguarde..."
        )
    }

    override fun onError(e: Blast) {
        b = e
    }

}