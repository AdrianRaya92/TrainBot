package com.example.trainbot

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.trainbot.databinding.ActivityKcalBinding


class Kcal : AppCompatActivity() {
    private lateinit var binding: ActivityKcalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kcal)

        binding = ActivityKcalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botón para volver a la Main Activity
        binding.btnAtras3.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //Comprobación de que ha sido marcado el radio button
        binding.rbtnMujer.setOnClickListener{
            if(binding.rbtnMujer.isChecked()){
                Toast.makeText(this,"KCAL Mujer",Toast.LENGTH_SHORT).show()
            }
        }
        binding.rbtnHombre.setOnClickListener{
            if(binding.rbtnHombre.isChecked()){
                Toast.makeText(this,"KCAL Hombre",Toast.LENGTH_SHORT).show()
            }
        }

        //Botón para volver a la Main Activity
        binding.btnCalcular.setOnClickListener{

            hideKeyboard()


            //Si los textos no están vacíos
            if((!binding.etEdad.getText().toString().isEmpty() && !binding.etAltura.getText().toString().isEmpty()
                        && !binding.etPeso.getText().toString().isEmpty()) && (binding.rbtnMujer.isChecked() ||
                        binding.rbtnHombre.isChecked()) && (binding.rbNada.isChecked() || binding.rb1dia.isChecked() ||
                        binding.rb2dia.isChecked() || binding.rb4dia.isChecked() || binding.rb6dia.isChecked() ||
                        binding.rbsiempre.isChecked())
            ) {

                val edad: Double = binding.etEdad.getText().toString().toDouble()
                val altura: Double = binding.etAltura.getText().toString().toDouble()
                val peso: Double = binding.etPeso.getText().toString().toDouble()
                var resultado: Double = 0.0
                var resultado2: Double = 0.0

                //TMB Mujer: (10x peso) + (6,25 x altura) – (5 x edad) – 161
                if(binding.rbtnMujer.isChecked()){
                    resultado = (10*peso)+(6.25*altura)-(5*edad)-161
                }
                //TMB Hombre: (10 x peso) + (6,25 x altura) – (5 x edad) + 5
                else if(binding.rbtnHombre.isChecked()){
                    resultado = (10*peso)+(6.25*altura)-(5*edad)+5
                }

                /*
                Si no haces nada de ejercicio y trabajas sentado: TMB x 1,2
                Si realizas ejercicio ligero dos días por semana: TMB x 1,375
                Si haces ejercicio moderado, unos cuatro días por semana: TMB x 1,55
                Si hacer deporte regular seis días a la semana: TMB x 1,725
                Si eres deportista de élite o entrenas muy intenso cada día: TMB x 1,9
                */
                if(binding.rbNada.isChecked()){
                    resultado2 = resultado*1.2
                }
                else if(binding.rb1dia.isChecked()){
                    resultado2 = resultado*1.3
                }
                else if(binding.rb2dia.isChecked()){
                    resultado2 = resultado*1.375
                }
                else if(binding.rb4dia.isChecked()){
                    resultado2 = resultado*1.55
                }
                else if(binding.rb6dia.isChecked()){
                    resultado2 = resultado*1.725
                }
                else if(binding.rbsiempre.isChecked()){
                    resultado2 = resultado*1.9
                }

                //Mostrar el texto del resultado en TextView
                binding.tvResultado.setText("TASA METABÓLICA BASAL= " + resultado.toInt()  +
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