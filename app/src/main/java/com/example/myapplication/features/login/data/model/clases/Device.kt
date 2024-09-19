package com.example.myapplication.features.login.data.model.clases

import android.content.Context
import android.os.Build
import com.example.myapplication.core.shared.LocalPersistence
import com.example.myapplication.features.login.data.model.tags.request.DEFAULT_EMAIL
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class Device(
    var id: Int? = 0,
    var idProfile: Int? = 1,
    var manufacture: String? = null,
    var model: String? = null,
    var deviceName: String? = null,
    var defaultEmail: String? = null,
    var openUIID: String? = null,
    var androidRelease: String? = null,
    var active: Boolean? = true,
    var appVersion: Int? = 1,
    var storeDate: Int? = 0,
    var new: Boolean? = true,
) {
    companion object {
        fun createInstance(context: Context): Device {
            return Device(
                id = 0,
                idProfile = 1,
                manufacture = Build.BRAND,
                model = Build.MODEL,
                deviceName = "${Build.BRAND} ${Build.MODEL}",
                defaultEmail = DEFAULT_EMAIL, // TODO: Informar email que está cadastrado no usuário
                openUIID = LocalPersistence(context).getOpenUIID(),
                androidRelease = Build.VERSION.RELEASE,
                active = true,
                appVersion = LocalPersistence(context).getAppVersion().toDouble().toInt(),
                new = true
            )
        }
    }

    fun toJson(): String {
        return Json.encodeToString(this)
    }
}