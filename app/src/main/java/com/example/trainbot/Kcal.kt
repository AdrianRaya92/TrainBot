package com.example.trainbot

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
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

            hideKeyboard()


            //Si los textos no están vacíos
            if(!etEdad.getText().toString().isEmpty() && !etAltura.getText().toString().isEmpty()
                && !etPeso.getText().toString().isEmpty() && (rbtnMujer.isChecked()==true
                        || rbtnHombre.isChecked()==true) && (rbNada.isChecked()==true || rb1dia.isChecked()==true
                        || rb2dia.isChecked()==true || rb4dia.isChecked()==true || rb6dia.isChecked()==true
                        || rbsiempre.isChecked()==true)) {

                val edad: Int = etEdad.getText().toString().toInt()
                val altura: Int = etAltura.getText().toString().toInt()
                val peso: Int = etPeso.getText().toString().toInt()
                var resultado: Double = 0.0
                var resultado2: Double = 0.0

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
                if(rbNada.isChecked()==true){
                    resultado2 = resultado*1.2
                }
                else if(rb1dia.isChecked()==true){
                    resultado2 = resultado*1.3
                }
                else if(rb2dia.isChecked()==true){
                    resultado2 = resultado*1.375
                }
                else if(rb4dia.isChecked()==true){
                    resultado2 = resultado*1.55
                }
                else if(rb6dia.isChecked()==true){
                    resultado2 = resultado*1.725
                }
                else if(rbsiempre.isChecked()==true){
                    resultado2 = resultado*1.9
                }

                //Mostrar el texto del resultado en TextView
                tvResultado.setText("TASA METABÓLICA BASAL= " + resultado.toInt()  +
                        System.getProperty ("line.separator") +
                        "KCAL DIARIAS SEGÚN EL EJERCICIO: " +
                        System.getProperty ("line.separator") +
                        "Kcal para Adelgazar 1Kg a la semana= " + (resultado2-500).toInt() +" Kcal diarias"+
                        System.getProperty ("line.separator") +
                        "Kcal para Mantener= " + resultado2.toInt()+" Kcal diarias"+
                        System.getProperty ("line.separator") +
                        "Kcal para Engordar 1Kg a la semana= " + (resultado2+600).toInt() +" Kcal diarias")
            }
            //Si están vacíos
            else{
                Toast.makeText(this,"Error campos vacios",Toast.LENGTH_SHORT).show();
            }
        }


    }

    //Oculta el teclado
    fun hideKeyboard(){
      val view = this.currentFocus
      if(view != null){
          val hideMe = getSystemService( Context.INPUT_METHOD_SERVICE) as InputMethodManager

          hideMe.hideSoftInputFromWindow(view.windowToken,0)
      }
        //else
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

    }

}