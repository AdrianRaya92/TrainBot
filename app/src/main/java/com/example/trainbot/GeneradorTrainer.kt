package com.example.trainbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.trainbot.databinding.ActivityGeneradorTrainerBinding


class GeneradorTrainer : AppCompatActivity() {
    private lateinit var binding: ActivityGeneradorTrainerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generador_trainer)

        binding = ActivityGeneradorTrainerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botón para volver a la Main Activity
        binding.btnAtras.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        //Comprobación de los Checkbox

        //CheckBox del cuerpo entero va a bloquear desmarcar los otros checkbox
        binding.cbTodo.setOnClickListener{
            if (binding.cbTodo.isChecked) {
                binding.cbBrazo.isEnabled = false
                binding.cbBrazo.isChecked = false
                binding.cbPecho.isEnabled = false
                binding.cbPecho.isChecked = false
                binding.cbEspalda.isEnabled = false
                binding.cbEspalda.isChecked = false
                binding.cbPiernas.isEnabled = false
                binding.cbPiernas.isChecked = false
                binding.cbGluteos.isEnabled = false
                binding.cbGluteos.isChecked = false
                binding.cbAbdomen.isEnabled = false
                binding.cbAbdomen.isChecked = false
            }
            else if (!binding.cbTodo.isChecked) {
                binding.cbBrazo.isEnabled = true
                binding.cbPecho.isEnabled = true
                binding.cbEspalda.isEnabled = true
                binding.cbPiernas.isEnabled = true
                binding.cbGluteos.isEnabled = true
                binding.cbAbdomen.isEnabled = true
            }
        }

        //CheckBox de 2 partes del cuerpo
        binding.cbBrazo.setOnClickListener{
            ComprobarCheckBox()
        }
        binding.cbPecho.setOnClickListener{
            ComprobarCheckBox()
        }
        binding.cbEspalda.setOnClickListener{
            ComprobarCheckBox()
        }
        binding.cbPiernas.setOnClickListener{
            ComprobarCheckBox()
        }
        binding.cbGluteos.setOnClickListener{
            ComprobarCheckBox()
        }
        binding.cbAbdomen.setOnClickListener{
            ComprobarCheckBox()
        }


        //Botón Generar la tabla de ejercicios
        binding.btnCrear.setOnClickListener{

            //Si los textos no están vacíos
            if((binding.rbCardio.isChecked || binding.rbMantenimiento.isChecked || binding.rbDefinicion.isChecked || binding.rbVolumen.isChecked) &&
                (binding.rbBaja.isChecked || binding.rbMedia.isChecked || binding.rbAlta.isChecked) &&
                (binding.rbGimnasio.isChecked || binding.rbExterior.isChecked) &&
                (binding.rbMaterialSi.isChecked || binding.rbMaterialNo.isChecked) &&
                (binding.cbBrazo.isChecked || binding.cbPecho.isChecked || binding.cbEspalda.isChecked || binding.cbPiernas.isChecked ||
                        binding.cbGluteos.isChecked || binding.cbAbdomen.isChecked || binding.cbTodo.isChecked)) {

                    val intent: Intent = Intent(this,Ejercicios::class.java)
                    startActivity(intent)
            }
            else{
                Toast.makeText(this,"Error campos vacios",Toast.LENGTH_SHORT).show()
            }


            }


    }

    private fun ComprobarCheckBox(){
        //Parte con brazos
        if (binding.cbBrazo.isChecked && binding.cbPecho.isChecked) {
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (binding.cbBrazo.isChecked && binding.cbEspalda.isChecked) {
            binding.cbPecho.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (binding.cbBrazo.isChecked && binding.cbPiernas.isChecked) {
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (binding.cbBrazo.isChecked && binding.cbGluteos.isChecked) {
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (binding.cbBrazo.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            //Poner variable de doble eleccion
        }
        //Parte con pecho
        else if (binding.cbPecho.isChecked && binding.cbEspalda.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (binding.cbPecho.isChecked && binding.cbPiernas.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (binding.cbPecho.isChecked && binding.cbGluteos.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (binding.cbPecho.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            //Poner variable de doble eleccion
        }
            //Parte con espalda
            else if (binding.cbEspalda.isChecked && binding.cbPiernas.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
                //Poner variable de doble eleccion
            } else if (binding.cbEspalda.isChecked && binding.cbGluteos.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbAbdomen.isEnabled = false
                //Poner variable de doble eleccion
            } else if (binding.cbEspalda.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
                //Poner variable de doble eleccion
            }
            //Parte con piernas
            else if (binding.cbPiernas.isChecked && binding.cbGluteos.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbAbdomen.isEnabled = false
                //Poner variable de doble eleccion
            } else if (binding.cbPiernas.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbGluteos.isEnabled = false
                //Poner variable de doble eleccion
            }
            //Parte con gluteos
            else if (binding.cbGluteos.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
                //Poner variable de doble eleccion
            } else{
            binding.cbBrazo.isEnabled = true
            binding.cbPecho.isEnabled = true
            binding.cbEspalda.isEnabled = true
            binding.cbPiernas.isEnabled = true
            binding.cbGluteos.isEnabled = true
            binding.cbAbdomen.isEnabled = true
            }


    }


}