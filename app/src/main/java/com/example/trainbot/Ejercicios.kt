package com.example.trainbot

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trainbot.databinding.ActivityEjerciciosBinding
import com.google.firebase.firestore.FirebaseFirestore
import androidx.lifecycle.Observer


class Ejercicios : AppCompatActivity() {

    lateinit var binding: ActivityEjerciciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)

        val db : FirebaseFirestore = FirebaseFirestore.getInstance()

        /*val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer{isConnected ->

            if(isConnected){
                binding.tvDescripcion.text = "Si internet"
            } else{
                binding.tvDescripcion.text = "No internet"
            }
        })

        */

        /*val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            // Si hay conexión a Internet en este momento
            binding.tvDescripcion.text = "Si internet"
        } else {
            // No hay conexión a Internet en este momento
            binding.tvDescripcion.text = "No se conecta"
        }*/

        binding = ActivityEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botón para entrar en la Activity para generar entrenamiento
        binding.btAtras4.setOnClickListener{
            val intent: Intent = Intent(this,GeneradorTrainer::class.java)
            startActivity(intent)
        }
        binding.btConsulta.setOnClickListener {
            var datos = ""
            db.collection("ejercicios")
                .get()
                .addOnSuccessListener { resultado ->
                     for (documento in resultado) {
                         datos += "${documento.id}: ${documento.data}\n"
                     }
                     binding.tvDescripcionEjercicio1.text = datos
                 }
                 .addOnFailureListener { exception ->
                     binding.tvDescripcionEjercicio1.text = "No se conecta"
                 }
                }


    /* MANERA PARA COGER UN SOLO DATO
        db.collection("ejercicios")
            .document("1").get()
            .addOnSuccessListener {
                binding.tvDescripcion.setText(it.get("titulo") as String?)
            }
        */
        //val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        //val Imagen = findViewById<ImageView>(R.id.ivImagen)
        //val tvDescripcion = findViewById<TextView>(R.id.tvDescripcion)


    }
}