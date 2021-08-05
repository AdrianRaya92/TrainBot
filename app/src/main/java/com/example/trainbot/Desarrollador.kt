package com.example.trainbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trainbot.databinding.ActivityDesarrolladorBinding



class Desarrollador : AppCompatActivity() {
    private lateinit var binding: ActivityDesarrolladorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desarrollador)

        binding = ActivityDesarrolladorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botón para volver a la Main Activity
        binding.btnAtras2.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}