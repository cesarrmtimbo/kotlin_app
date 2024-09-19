package com.example.myapplication.core.shared.persets

import Blast
import android.content.Context
import com.example.myapplication.core.shared.SessionEraser
import com.example.myapplication.core.utils.Utils
import com.example.myapplication.features.login.data.model.clases.Branch
import com.example.myapplication.features.login.data.model.clases.BranchBundle
import com.example.myapplication.features.login.data.model.clases.Business
import com.example.myapplication.features.login.data.model.clases.Profile
import kotlin.jvm.Throws

const val PROFILE = "PROFILE"
const val BUSINESS = "BUSINESS"
const val BRANCH_BUNDLE = "BRANCH_BUNDLE"
const val BRANCH = "BRANCH"
const val ONLINE = "ONLINE"

class PerSet(context: Context) : RootSet(context) {

    val context = context

    var sessionName: String? = null

    fun loadSessionInfo() {
        sessionName = null

        if (hasSession()) {
            sessionName =
                Utils().decrypt("U1RBUktFUg==") + "_" + profile()!!.id + "_" + business()!!.id
        }
    }

    fun setOnline(b: Boolean) {
        putBoolean(ONLINE, b)
    }

    fun hasSession(): Boolean {
        return business() != null && profile() != null
    }

    fun addBundle(bundle: BranchBundle) {
        setBundle(bundle)
        setProfile(bundle.profiles!![0])
    }

    fun setBundle(bundle: BranchBundle) {
        putString(BRANCH_BUNDLE, gson.toJson(bundle))
    }

    fun bundle(): BranchBundle {
        val value: String? = getString(BRANCH_BUNDLE, "")
        return if (value?.isEmpty() == true) {
            BranchBundle()
        } else {
            gson.fromJson(value, BranchBundle::class.java)
        }
    }

    fun setProfile(profile: Profile?): Profile? {
        putString(PROFILE, gson.toJson(profile))
        return profile
    }

    fun profile(): Profile? {
        val value: String? = getString(PROFILE, "")
        return if (value?.isEmpty() == true) {
            null
        } else {
            gson.fromJson(value, Profile::class.java)
        }
    }

    private fun chooseBusiness(): Boolean {
        return bundle().countBranches(profile()!!.id!!) > 1
    }

    fun login(user: String, pass: String): Profile? {
        val profile: Profile? = setProfile(bundle().findProfile(user, pass))
        if (profile != null) {
            if (chooseBusiness()) {
                setBusiness(null)
            } else {
                setBusiness(bundle().findAllBusiness(profile.id!!)[0])
            }
        }
        return null
    }


    @Throws(Blast::class)
    fun setBusiness(business: Business?) {
        if (business != null && !business.active!!) {
            throw Blast().title("Atenção")
                .msg("Esta empresa não está ativa: ${business.name}")
        }
        putString(BUSINESS, gson.toJson(business) ?: "")

        if (business == null) {
            setBranch(null)
        } else {
            if (profile() != null) {
                val b: Branch? = bundle().findBranch(profile()!!.id!!, business!!.id!!)

                if (!b?.active!!) {
                    throw Blast().title("Atenção")
                        .msg("Empresa não está ativa: ${business.name}")
                }

                setBranch(b)
            } else {
                throw Blast().title("Algo deu errado")
                    .msg("Nenhum usuário foi localizado, impossível continuar")
            }

            SessionEraser().clean(true, context)
            loadSessionInfo()
        }
    }

    fun business(): Business? {
        val value: String? = getString(BUSINESS, "")
        return if (value?.isEmpty() == true) {
            return null
        } else {
            gson.fromJson(value, Business::class.java)
        }
    }

    fun branch(): Branch? {
        val value: String? = getString(BRANCH, "")
        return if (value?.isEmpty() == true) {
            null
        } else {
            gson.fromJson(value, Branch::class.java)
        }
    }

    fun setBranch(branch: Branch?) {
        putString(BRANCH, gson.toJson(branch))
    }

}