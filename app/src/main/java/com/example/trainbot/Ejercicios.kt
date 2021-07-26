package com.example.trainbot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ejercicios.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnGenerar

class Ejercicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)

        //Botón para entrar en la Activity para generar entrenamiento
        btAtras4.setOnClickListener{
            val intent: Intent = Intent(this,GeneradorTrainer::class.java)
            startActivity(intent)
        }

    }
}