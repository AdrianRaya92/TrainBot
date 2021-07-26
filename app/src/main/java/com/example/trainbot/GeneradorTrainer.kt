package com.example.trainbot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_generador_trainer.*
import kotlinx.android.synthetic.main.activity_kcal.*


class GeneradorTrainer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generador_trainer)

        //Botón para volver a la Main Activity
        btnAtras.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        //Comprobación de los Checkbox

        //CheckBox del cuerpo entero va a bloquear desmarcar los otros checkbox
        cbTodo.setOnClickListener{
            if (cbTodo.isChecked) {
                cbBrazo.isEnabled = false
                cbBrazo.isChecked = false
                cbPecho.isEnabled = false
                cbPecho.isChecked = false
                cbEspalda.isEnabled = false
                cbEspalda.isChecked = false
                cbPiernas.isEnabled = false
                cbPiernas.isChecked = false
                cbGluteos.isEnabled = false
                cbGluteos.isChecked = false
                cbAbdomen.isEnabled = false
                cbAbdomen.isChecked = false
            }
            else if (!cbTodo.isChecked) {
                cbBrazo.isEnabled = true
                cbPecho.isEnabled = true
                cbEspalda.isEnabled = true
                cbPiernas.isEnabled = true
                cbGluteos.isEnabled = true
                cbAbdomen.isEnabled = true
            }
        }

        //CheckBox de 2 partes del cuerpo
        cbBrazo.setOnClickListener{
            ComprobarCheckBox()
        }
        cbPecho.setOnClickListener{
            ComprobarCheckBox()
        }
        cbEspalda.setOnClickListener{
            ComprobarCheckBox()
        }
        cbPiernas.setOnClickListener{
            ComprobarCheckBox()
        }
        cbGluteos.setOnClickListener{
            ComprobarCheckBox()
        }
        cbAbdomen.setOnClickListener{
            ComprobarCheckBox()
        }


        //Botón Generar la tabla de ejercicios
        btnCrear.setOnClickListener{

            //Si los textos no están vacíos
            if((rbCardio.isChecked || rbMantenimiento.isChecked || rbDefinicion.isChecked || rbVolumen.isChecked) &&
                (rbBaja.isChecked || rbMedia.isChecked || rbAlta.isChecked) &&
                (rbGimnasio.isChecked || rbExterior.isChecked) &&
                (rbMaterialSi.isChecked || rbMaterialNo.isChecked) &&
                (cbBrazo.isChecked || cbPecho.isChecked || cbEspalda.isChecked || cbPiernas.isChecked ||
                        cbGluteos.isChecked || cbAbdomen.isChecked || cbTodo.isChecked)) {

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
        if (cbBrazo.isChecked && cbPecho.isChecked) {
            cbEspalda.isEnabled = false
            cbPiernas.isEnabled = false
            cbGluteos.isEnabled = false
            cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (cbBrazo.isChecked && cbEspalda.isChecked) {
            cbPecho.isEnabled = false
            cbPiernas.isEnabled = false
            cbGluteos.isEnabled = false
            cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (cbBrazo.isChecked && cbPiernas.isChecked) {
            cbPecho.isEnabled = false
            cbEspalda.isEnabled = false
            cbGluteos.isEnabled = false
            cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (cbBrazo.isChecked && cbGluteos.isChecked) {
            cbPecho.isEnabled = false
            cbEspalda.isEnabled = false
            cbPiernas.isEnabled = false
            cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (cbBrazo.isChecked && cbAbdomen.isChecked) {
            cbPecho.isEnabled = false
            cbEspalda.isEnabled = false
            cbPiernas.isEnabled = false
            cbGluteos.isEnabled = false
            //Poner variable de doble eleccion
        }
        //Parte con pecho
        else if (cbPecho.isChecked && cbEspalda.isChecked) {
            cbBrazo.isEnabled = false
            cbPiernas.isEnabled = false
            cbGluteos.isEnabled = false
            cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (cbPecho.isChecked && cbPiernas.isChecked) {
            cbBrazo.isEnabled = false
            cbEspalda.isEnabled = false
            cbGluteos.isEnabled = false
            cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (cbPecho.isChecked && cbGluteos.isChecked) {
            cbBrazo.isEnabled = false
            cbEspalda.isEnabled = false
            cbPiernas.isEnabled = false
            cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
        } else if (cbPecho.isChecked && cbAbdomen.isChecked) {
            cbBrazo.isEnabled = false
            cbEspalda.isEnabled = false
            cbPiernas.isEnabled = false
            cbGluteos.isEnabled = false
            //Poner variable de doble eleccion
        }
            //Parte con espalda
            else if (cbEspalda.isChecked && cbPiernas.isChecked) {
                cbBrazo.isEnabled = false
                cbPecho.isEnabled = false
                cbGluteos.isEnabled = false
                cbAbdomen.isEnabled = false
                //Poner variable de doble eleccion
            } else if (cbEspalda.isChecked && cbGluteos.isChecked) {
                cbBrazo.isEnabled = false
                cbPecho.isEnabled = false
                cbPiernas.isEnabled = false
                cbAbdomen.isEnabled = false
                //Poner variable de doble eleccion
            } else if (cbEspalda.isChecked && cbAbdomen.isChecked) {
                cbBrazo.isEnabled = false
                cbPecho.isEnabled = false
                cbPiernas.isEnabled = false
                cbGluteos.isEnabled = false
                //Poner variable de doble eleccion
            }
            //Parte con piernas
            else if (cbPiernas.isChecked && cbGluteos.isChecked) {
                cbBrazo.isEnabled = false
                cbPecho.isEnabled = false
                cbEspalda.isEnabled = false
                cbAbdomen.isEnabled = false
                //Poner variable de doble eleccion
            } else if (cbPiernas.isChecked && cbAbdomen.isChecked) {
                cbBrazo.isEnabled = false
                cbPecho.isEnabled = false
                cbEspalda.isEnabled = false
                cbGluteos.isEnabled = false
                //Poner variable de doble eleccion
            }
            //Parte con gluteos
            else if (cbGluteos.isChecked && cbAbdomen.isChecked) {
                cbBrazo.isEnabled = false
                cbPecho.isEnabled = false
                cbEspalda.isEnabled = false
                cbPiernas.isEnabled = false
                //Poner variable de doble eleccion
            } else{
                cbBrazo.isEnabled = true
                cbPecho.isEnabled = true
                cbEspalda.isEnabled = true
                cbPiernas.isEnabled = true
                cbGluteos.isEnabled = true
                cbAbdomen.isEnabled = true
            }


    }


}