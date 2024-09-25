package com.example.myapplication.core.network

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import com.example.myapplication.core.model.Version
import com.example.myapplication.core.shared.LocalPersistence
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

val USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
val REFERRER = "https://www.google.com";
val DIV = "div[itemprop=softwareVersion]";

class PlayVersion(val context: Context) {

    open var onVersionListener: OnVersionListener? = null
    val version: Version = Version(context)

    private fun versionUrl(): String {
        return ("https://play.google.com/store/apps/details?id=" + context.getPackageName()
                + "&hl=en")
    }

    fun makeRequest() : String {
        return  Jsoup.connect(versionUrl())
            .timeout(30000)
            .userAgent(USER_AGENT)
            .referrer(REFERRER)
            .get()
            .select(DIV)
            .first()
            ?.ownText() ?: "1.0"
    }

    fun executeTask(){
        GlobalScope.launch(Dispatchers.Main) {
            val playStoreVersion = makeRequest()
            val packageVersion = LocalPersistence(context).getAppVersion()
            version.newVersion = playStoreVersion
            version.oldVersion = packageVersion

            if(onVersionListener != null){
                onVersionListener!!.onVersion(version)
            }
        }
    }

    fun openAppInPlayStore(activity: ComponentActivity) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${LocalPersistence(context).getAppVersion()}"))
            activity.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=${LocalPersistence(context).getAppVersion()}"))
            activity.startActivity(webIntent)
        }
    }
}

interface OnVersionListener {
    fun onVersion(version: Version)
}