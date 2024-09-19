package com.example.myapplication.features.login.data.model.clases

import java.util.Date

class Business(
    id: Int?,
    name: String?,
    code: String?,
    ip: String?,
    alternativeIp: String?,
    port: Int?,
    baseSynPath: String?,
    active: Boolean? = true,
    modules: String?,
    storeDate: Date?,
    updateDate: Date?,
    licenceValue: Float?,
    userPass: String?,
    email: String?,
    ) {
    val id: Int? = id
    val name: String? = name
    val code: String? = code
    val ip: String? = ip
    val alternativeIp: String? = alternativeIp
    val port: Int? = port
    val baseSynPath: String? = baseSynPath
    val active: Boolean? = active
    val modules: String? = modules
    val storeDate: Date? = storeDate
    val updateDate: Date? = updateDate
    val licenceValue: Float? = licenceValue
    val userPass: String? = userPass
    val email: String? = email

}