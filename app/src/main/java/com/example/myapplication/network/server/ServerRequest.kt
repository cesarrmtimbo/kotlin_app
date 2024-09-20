package com.example.myapplication.network.server

import Blast
import android.content.Context
import com.example.myapplication.R
import com.example.myapplication.core.shared.LocalPersistence
import com.example.myapplication.core.utils.Utils
import com.example.myapplication.features.login.data.model.clases.Device
import com.example.myapplication.features.login.data.model.tags.request.API_KEY
import com.example.myapplication.features.login.data.model.tags.request.DEVICE_OBJ
import com.example.myapplication.features.login.data.model.tags.request.REQ_ID
import com.example.myapplication.features.login.data.model.tags.request.TIME_OUT
import com.example.myapplication.features.login.data.model.tags.request.api_key
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import java.util.concurrent.TimeUnit
import androidx.compose.runtime.mutableStateMapOf as mutableStateMapOf1

const val SERVER_URL = "http://localhost:6969/ws-server/"

open class ServerRequest(context: Context) {

    private val context: Context = context
    private val params = mutableStateMapOf1<String, String>()
    private val timeOut = TimeUnit.MINUTES.toMillis(15)

    var response: HttpResponse? = null
    var onErrorListener: OnErrorListener? = null
    var onSuccessListener: OnSuccess? = null


    open suspend fun prepareRequest(path: String) {
        val client = HttpClient(CIO)
        var u = Utils();

        try {
            response = client.post(SERVER_URL + path) {
                url {
                    parameters.append(API_KEY, u.encrypt(api_key)!!)
                    parameters.append(DEVICE_OBJ, u.encrypt(Device.createInstance(context).toJson())!!)
                    parameters.append(TIME_OUT, u.encrypt(timeOut.toString())!!)
                    parameters.append(REQ_ID, u.encrypt(LocalPersistence(context).getOpenUIID())!!)

                    for ((key, value) in params) {
                        parameters.append(key, u.encrypt(value)!!)
                    }
                }
            }

            if(response != null){
                if(response!!.status.value == 200){
                    if(onSuccessListener != null){
                        onSuccessListener!!.onSuccess(response!!.bodyAsText())
                    }
                }
            }
            debugRequestResult()
        } catch (e: Exception) {
            e.printStackTrace();
        } finally {
            client.close()
        }
    }

    fun addParams(tag: String, value: String) {
        params[tag] = value
    }

    private suspend fun debugRequestResult(){
        if(response != null){
            print("Controle da classe ServerRequest...")
            print("StatusCode: ${response!!.status.value}")
            if (response!!.status.value == 200) {
                print("Sucesso: ${response!!.bodyAsText()}")
            } else {
                print("Error: ${response!!.bodyAsText()}")
            }
        }
    }

    fun buildThrowable(e: Exception): Blast {
        return Blast().title(R.string.attention.toString()).msg(if( e.message == null) context.getString(R.string.unknown_error) else e.message!!).setErrorDetails(e)
    }

    interface SetRequestClassParams{
        fun setParams()
        suspend fun makeRequest()
    }

    interface OnErrorListener {
        fun onError(e: Blast)
    }

    interface OnSuccess {
        fun onSuccess(response: String)
    }

}