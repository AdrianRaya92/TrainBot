package com.example.trainbot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 * TRAINBOT
 * @author Adrian Raya Hernandez
 * API 26
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Botón para entrar en la Activity para generar entrenamiento
        btnGenerar.setOnClickListener{
            val intent:Intent = Intent(this,GeneradorTrainer::class.java)
            startActivity(intent)
        }


    }
}