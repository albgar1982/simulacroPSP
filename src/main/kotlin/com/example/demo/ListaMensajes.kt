package com.example.demo

import com.google.gson.Gson

class ListaMensajes(var listaMensajesFiltrados:List<MensajeUsuario>) {
    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

}