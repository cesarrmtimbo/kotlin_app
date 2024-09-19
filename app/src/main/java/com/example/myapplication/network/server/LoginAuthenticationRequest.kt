package com.example.myapplication.network.server

import android.content.Context

import com.example.myapplication.features.login.data.model.clases.BranchBundle
import com.example.myapplication.features.login.data.model.tags.path.login_auth
import com.example.myapplication.features.login.data.model.tags.request.LOGIN
import com.example.myapplication.features.login.data.model.tags.request.PASS
import com.example.myapplication.network.server.ServerRequest.SetRequestClassParams
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json


open class LoginAuthRequest(context: Context) : ServerRequest(context), SetRequestClassParams {

    private var onAuthSuccess: OnAuthSuccess? = null
    private var login: String? = null
    private var pass: String? = null


    override suspend fun makeRequest() {
        setParams();
        super.prepareRequest(login_auth)

        try{
            if (response != null && response!!.status.value == 200) {
                if (onAuthSuccess != null) {
                    var bundle = Json.decodeFromString<BranchBundle>(response!!.bodyAsText())
                    onAuthSuccess!!.onAuthSuccess(bundle);
                }
            }
        } catch (e: Exception){
            onErrorListener?.onError(buildThrowable(e))
        }
    }

    fun setPass(pass: String) {
        this.pass = pass
    }

    fun getPass(): String? {
        return pass
    }

    fun setLogin(login: String) {
        this.login = login
    }

    fun getLogin(): String? {
        return login
    }

    fun setAuthSuccess(listener: OnAuthSuccess) {
        this.onAuthSuccess = listener
    }

    interface OnAuthSuccess {
        fun onAuthSuccess(bundle: BranchBundle)
    }

    override fun setParams() {
        addParams(LOGIN, login.toString())
        addParams(PASS, pass.toString())
    }
}

interface OnLoginCallback {
    fun onLoginSuccess(online: Boolean)
}