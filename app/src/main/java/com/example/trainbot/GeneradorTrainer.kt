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

        //Botón para ir a una nueva activity con la tabla de ejercicios
        btnCrear.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        //Comprobación de los Checkbox

        //CheckBox del cuerpo entero va a bloquear desmarcar los otros checkbox
        cbTodo.setOnClickListener{
            if (cbTodo.isChecked()==true) {
                cbBrazo.setEnabled(false)
                cbBrazo.setChecked(false)
                cbPecho.setEnabled(false)
                cbPecho.setChecked(false)
                cbEspalda.setEnabled(false)
                cbEspalda.setChecked(false)
                cbPiernas.setEnabled(false)
                cbPiernas.setChecked(false)
                cbGluteos.setEnabled(false)
                cbGluteos.setChecked(false)
                cbAbdomen.setEnabled(false)
                cbAbdomen.setChecked(false)
            }
            else if (cbTodo.isChecked()==false) {
                cbBrazo.setEnabled(true)
                cbPecho.setEnabled(true)
                cbEspalda.setEnabled(true)
                cbPiernas.setEnabled(true)
                cbGluteos.setEnabled(true)
                cbAbdomen.setEnabled(true)
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




    }

    fun ComprobarCheckBox(){
        //Parte con brazos
        if (cbBrazo.isChecked() == true && cbPecho.isChecked() == true) {
            cbEspalda.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbGluteos.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbBrazo.isChecked() == true && cbEspalda.isChecked() == true) {
            cbPecho.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbGluteos.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbBrazo.isChecked() == true && cbPiernas.isChecked() == true) {
            cbPecho.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbGluteos.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbBrazo.isChecked() == true && cbGluteos.isChecked() == true) {
            cbPecho.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbBrazo.isChecked() == true && cbAbdomen.isChecked() == true) {
            cbPecho.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbGluteos.setEnabled(false)
            //Poner variable de doble eleccion
        }
        //Parte con pecho
        else if (cbPecho.isChecked() == true && cbEspalda.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbGluteos.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbPecho.isChecked() == true && cbPiernas.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbGluteos.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbPecho.isChecked() == true && cbGluteos.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbPecho.isChecked() == true && cbAbdomen.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbGluteos.setEnabled(false)
            //Poner variable de doble eleccion
        }
        //Parte con espalda
        else if (cbEspalda.isChecked() == true && cbPiernas.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbPecho.setEnabled(false)
            cbGluteos.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbEspalda.isChecked() == true && cbGluteos.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbPecho.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbEspalda.isChecked() == true && cbAbdomen.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbPecho.setEnabled(false)
            cbPiernas.setEnabled(false)
            cbGluteos.setEnabled(false)
            //Poner variable de doble eleccion
        }
        //Parte con piernas
        else if (cbPiernas.isChecked() == true && cbGluteos.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbPecho.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbAbdomen.setEnabled(false)
            //Poner variable de doble eleccion
        } else if (cbPiernas.isChecked() == true && cbAbdomen.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbPecho.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbGluteos.setEnabled(false)
            //Poner variable de doble eleccion
        }
        //Parte con gluteos
        else if (cbGluteos.isChecked() == true && cbAbdomen.isChecked() == true) {
            cbBrazo.setEnabled(false)
            cbPecho.setEnabled(false)
            cbEspalda.setEnabled(false)
            cbPiernas.setEnabled(false)
            //Poner variable de doble eleccion
        }

        else{
            cbBrazo.setEnabled(true)
            cbPecho.setEnabled(true)
            cbEspalda.setEnabled(true)
            cbPiernas.setEnabled(true)
            cbGluteos.setEnabled(true)
            cbAbdomen.setEnabled(true)
        }

    }


}