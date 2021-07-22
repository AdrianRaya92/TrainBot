package com.example.trainbot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_desarrollador.*
import kotlinx.android.synthetic.main.activity_kcal.*

class Kcal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kcal)

        //Botón para volver a la Main Activity
        btnAtras3.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        if(rbtnMujer.isChecked()==true){
            Toast.makeText(this,"Mujer marcada",Toast.LENGTH_SHORT).show()
        }
        if(rbtnHombre.isChecked()==true){
            Toast.makeText(this,"Hombre marcado",Toast.LENGTH_SHORT).show()
        }

    }
}