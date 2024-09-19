package com.example.myapplication.features.login.data.model.clases

import java.util.Date

class Profile(id: Int?,name : String?, login: String?, pass: String, email : String?, storeDate: Date?, updateDate: Date?) {
   val id = id
   val name = name
   val login = login
   val pass = pass
   val email = email
   val storeDate = storeDate
   val updateDate = updateDate
}