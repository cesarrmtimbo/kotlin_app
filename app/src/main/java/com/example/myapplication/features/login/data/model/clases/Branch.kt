package com.example.myapplication.features.login.data.model.clases

class Branch(idProfile: Int?, idBusiness: Int?, code: Int?, modules: String?, manager: Boolean? = false, active: Boolean? = true) {

    val idProfile = idProfile
    val idBusiness = idBusiness
    val code = code
    val modules = modules
    val manager = manager
    val active = active
}