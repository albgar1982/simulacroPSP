package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Database{

    @Bean
    fun initDatabase(mensajesRepository: MensajesRepository): CommandLineRunner {
        return CommandLineRunner{
            println("Base de datos creada.")
        }
    }

}