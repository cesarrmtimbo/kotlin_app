package com.example.myapplication.features.login.data.repository

import Blast
import android.content.Context
import com.example.myapplication.app.BeginActivity
import com.example.myapplication.core.shared.persets.PerSet
import com.example.myapplication.features.login.data.model.clases.BranchBundle
import com.example.myapplication.features.login.data.model.tags.request.AUTHENTICATION_FAIL
import com.example.myapplication.network.server.LoginAuthRequest
import com.example.myapplication.network.server.OnLoginCallback
import com.example.myapplication.network.server.ServerRequest
import kotlinx.coroutines.flow.MutableStateFlow


class LoginRepository(val context: Context) : LoginAuthRequest(context),
    LoginAuthRequest.OnAuthSuccess, ServerRequest.OnErrorListener {
    open var onLoginCallback: OnLoginCallback? = null
    open var onLoginErrorCallback: OnErrorListener? = null
    val set: PerSet = PerSet(context)
    override lateinit var showPop: MutableStateFlow<Blast?>

    init {
        super.setAuthSuccess(this)
        super.onErrorListener = this
    }

    override fun onAuthSuccess(bundle: BranchBundle) {
        val profile = bundle.profiles?.get(0)

        set.addBundle(bundle)
        set.login(profile!!.login!!, profile.pass)

        if (context is BeginActivity) {
            context.onLoginSuccess(true)
        }
    }

    override suspend fun makeRequest() {
        super.setAuthSuccess(this)
        super.makeRequest()
    }

    override fun onError(e: Blast) {
        e.title(AUTHENTICATION_FAIL)
        if (onLoginErrorCallback != null) {
            onLoginErrorCallback!!.onError(e)
        }
    }

    override fun closePop() {
        if (showPop.value != null) {
            showPop.value = null
        }
    }

}