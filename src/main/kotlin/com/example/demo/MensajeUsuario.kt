package com.example.demo

import com.google.gson.Gson
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class MensajeUsuario(var mensaje: String) {

    @Id
    @GeneratedValue
    var id=0

    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }
}