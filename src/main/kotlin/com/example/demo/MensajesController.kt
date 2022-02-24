package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MensajesController(private val mensajesRepository: MensajesRepository) {

    @PostMapping("publicarTexto")
    fun publicarTexto(@RequestBody texto:String) :MensajeUsuario {

        val mensaje = MensajeUsuario(texto)

        mensajesRepository.save(mensaje)

        mensajesRepository.findAll().forEach{
            println(it)
        }
        return mensaje
    }

    @GetMapping("descargarFiltrado")
    fun descargarFiltrado(@RequestBody texto:String) :Any{

        val listaAdevolver=mensajesRepository.findAll().filter {
            it.mensaje.contains(texto)
        }

        if(listaAdevolver.isEmpty())
            return "ERROR. NOT FOUND"
        else{
            return ListaMensajes(listaAdevolver).toString()
        }
    }

    @GetMapping("borrarMensajes")
    fun borrarMensajes(){

        mensajesRepository.findAll().forEach {
            if(it.mensaje.trim().isEmpty())
                mensajesRepository.delete(it)
        }
        mensajesRepository.findAll().forEach{
            println(it)
        }
    }

    


}