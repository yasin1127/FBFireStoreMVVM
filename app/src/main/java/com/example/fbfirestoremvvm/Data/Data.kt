package com.example.fbfirestoremvvm.Data

import com.google.firebase.Timestamp


data class Data(

    var id:String?=null,
    val stuid:String?=null,
    val name:String?=null,
    val email:String?=null,
    val subject:String?=null,
    val birthday:String?=null,
    val timestamp: Timestamp?= null

)

