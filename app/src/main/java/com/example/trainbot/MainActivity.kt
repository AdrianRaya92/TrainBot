package com.example.trainbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trainbot.databinding.ActivityMainBinding


/**
 * TRAINBOT
 * @author Adrian Raya Hernandez
 * API 26
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botón para entrar en la Activity para generar entrenamiento
        binding.btnGenerar.setOnClickListener{
            val intent:Intent = Intent(this,GeneradorTrainer::class.java)
            startActivity(intent)
        }

        //Botón para entrar en la Activity de información del desarrollador
        binding.btnDesarrollador.setOnClickListener{
            val intent:Intent = Intent(this,Desarrollador::class.java)
            startActivity(intent)
        }

        //Botón para entrar en la Activity de información Kcal
        binding.btnKcal.setOnClickListener{
            val intent:Intent = Intent(this,Kcal::class.java)
            startActivity(intent)
        }

        //Botón para salir de la app
        binding.btnSalir.setOnClickListener{
            finishAffinity()
        }


    }
}