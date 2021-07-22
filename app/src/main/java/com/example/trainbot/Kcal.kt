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

        //Comprobación de que ha sido marcado el radio button
        rbtnMujer.setOnClickListener{
            if(rbtnMujer.isChecked()==true){
                Toast.makeText(this,"KCAL Mujer",Toast.LENGTH_SHORT).show()
            }
        }
        rbtnHombre.setOnClickListener{
            if(rbtnHombre.isChecked()==true){
                Toast.makeText(this,"KCAL Hombre",Toast.LENGTH_SHORT).show()
            }
        }

        //Botón para volver a la Main Activity
        btnCalcular.setOnClickListener{
            //Si los textos no están vacíos
            if(!etEdad.getText().toString().isEmpty() && !etAltura.getText().toString().isEmpty()
                && !etPeso.getText().toString().isEmpty() && (rbtnMujer.isChecked()==true
                        || rbtnHombre.isChecked()==true)) {

                val edad: Int = etEdad.getText().toString().toInt()
                val altura: Int = etAltura.getText().toString().toInt()
                val peso: Int = etPeso.getText().toString().toInt()
                var resultado: Double = 0.0

                //TMB Mujer: (10x peso) + (6,25 x altura) – (5 x edad) – 161
                if(rbtnMujer.isChecked()==true){
                    resultado = (10*peso)+(6.25*altura)-(5*edad)-161
                }
                //TMB Hombre: (10 x peso) + (6,25 x altura) – (5 x edad) + 5
                else if(rbtnHombre.isChecked()==true){
                    resultado = (10*peso)+(6.25*altura)-(5*edad)+5
                }

                /*
                Si no haces nada de ejercicio y trabajas sentado: TMB x 1,2
                Si realizas ejercicio ligero dos días por semana: TMB x 1,375
                Si haces ejercicio moderado, unos cuatro días por semana: TMB x 1,55
                Si hacer deporte regular seis días a la semana: TMB x 1,725
                Si eres deportista de élite o entrenas muy intenso cada día: TMB x 1,9
                */
                tvResultado.setText("TASA METABÓLICA BASAL= " + resultado.toInt()  +
                        System.getProperty ("line.separator") +
                        System.getProperty ("line.separator") +
                        "KCAL DIARIAS SEGÚN EL EJERCICIO: " +
                        System.getProperty ("line.separator") +
                        "Nada de ejercicio= " + (resultado*1.2).toInt() +" Kcal"+
                        System.getProperty ("line.separator") +
                        "Ejercicio 2 días a la semana= " + (resultado*1.375).toInt()+" Kcal"+
                        System.getProperty ("line.separator") +
                        "Ejercicio 4 días a la semana= " + (resultado*1.55).toInt() +" Kcal"+
                        System.getProperty ("line.separator") +
                        "Ejercicio 6 días a la semana= " + (resultado*1.725).toInt() +" Kcal"+
                        System.getProperty ("line.separator") +
                        "Ejercicio intenso todos los días= " + (resultado*1.9).toInt()+" Kcal")

            }
            //Si están vacíos
            else{
                Toast.makeText(this,"Error campos vacios",Toast.LENGTH_SHORT).show();
            }
        }


    }



}