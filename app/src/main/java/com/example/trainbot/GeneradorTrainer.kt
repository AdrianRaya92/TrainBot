package com.example.trainbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.trainbot.databinding.ActivityGeneradorTrainerBinding


class GeneradorTrainer : AppCompatActivity() {
    private lateinit var binding: ActivityGeneradorTrainerBinding

    //VARIABLES PARA EL FORMULARIO
    var entrenamiento: Int = 0 // 1-Cardio, 2-Mantenimiento, 3-Definicion, 4-Volumen
    var lugar: Int = 0 // 1-Gimnasio, 2-Exterior
    // Partes cuerpo: 1-Biceps/Triceps, 2-Pecho, 3-Espalda, 4-Piernas, 5-Gluteos, 6-Abdomen, 7-Completo
    var parteCuerpo1: Int = 0
    var parteCuerpo2: Int = 0
    var material: Boolean = false // true-Si tiene material, false-no tiene material


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
                parteCuerpo1 = 7
                parteCuerpo2 = 7
            }
            else if (!binding.cbTodo.isChecked) {
                binding.cbBrazo.isEnabled = true
                binding.cbPecho.isEnabled = true
                binding.cbEspalda.isEnabled = true
                binding.cbPiernas.isEnabled = true
                binding.cbGluteos.isEnabled = true
                binding.cbAbdomen.isEnabled = true
                parteCuerpo1 = 0
                parteCuerpo2 = 0
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

        //Comprobación de los RadioButtons
        //Tipo de Entrenamiento
        binding.rbCardio.setOnClickListener{
            entrenamiento = 1
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
            binding.cbTodo.isEnabled = false
            binding.cbTodo.isChecked = true
            parteCuerpo1 = 7
            parteCuerpo2 = 7
        }
        binding.rbMantenimiento.setOnClickListener{
            entrenamiento = 2
            eleccionEntrenamiento()
        }
        binding.rbDefinicion.setOnClickListener{
            entrenamiento = 3
            eleccionEntrenamiento()
        }
        binding.rbVolumen.setOnClickListener{
            entrenamiento = 4
            eleccionEntrenamiento()
        }
        //Lugar de entrenamiento
        binding.rbGimnasio.setOnClickListener{
            binding.rbMaterialSi.isEnabled = true
            binding.rbMaterialSi.isChecked = true
            binding.rbMaterialNo.isEnabled = false
            binding.rbMaterialNo.isChecked = false
            material = true
            lugar = 1
        }
        binding.rbExterior.setOnClickListener{
            binding.rbMaterialNo.isEnabled = true
            lugar = 2
        }
        //Materiales para el entrenamiento
        binding.rbMaterialSi.setOnClickListener{
            material = true
        }
        binding.rbMaterialNo.setOnClickListener{
            material = false
        }


        //Botón Generar la tabla de ejercicios
        binding.btnCrear.setOnClickListener{

            //Si los textos no están vacíos
            if((binding.rbCardio.isChecked || binding.rbMantenimiento.isChecked || binding.rbDefinicion.isChecked || binding.rbVolumen.isChecked) &&
                (binding.rbGimnasio.isChecked || binding.rbExterior.isChecked) &&
                (binding.rbMaterialSi.isChecked || binding.rbMaterialNo.isChecked) &&
                (binding.cbBrazo.isChecked || binding.cbPecho.isChecked || binding.cbEspalda.isChecked || binding.cbPiernas.isChecked ||
                        binding.cbGluteos.isChecked || binding.cbAbdomen.isChecked || binding.cbTodo.isChecked)) {


                    val intent: Intent = Intent(this,Ejercicios::class.java)
                val b : Bundle = Bundle()
                b.putInt("entreno", entrenamiento)
                b.putInt("lugar", lugar)
                b.putInt("part1", parteCuerpo1)
                b.putInt("part2", parteCuerpo2)
                b.putBoolean("mater", material)
                intent.putExtras(b)
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
            parteCuerpo1 = 1
            parteCuerpo2 = 2

        } else if (binding.cbBrazo.isChecked && binding.cbEspalda.isChecked) {
            binding.cbPecho.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 1
            parteCuerpo2 = 3
        } else if (binding.cbBrazo.isChecked && binding.cbPiernas.isChecked) {
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 1
            parteCuerpo2 = 4
        } else if (binding.cbBrazo.isChecked && binding.cbGluteos.isChecked) {
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 1
            parteCuerpo2 = 5
        } else if (binding.cbBrazo.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 1
            parteCuerpo2 = 6
        }
        else if (binding.cbBrazo.isChecked && !binding.cbPecho.isChecked && !binding.cbEspalda.isChecked
            && !binding.cbPiernas.isChecked && !binding.cbGluteos.isChecked && !binding.cbAbdomen.isChecked) {
            binding.cbPecho.isEnabled = true
            binding.cbEspalda.isEnabled = true
            binding.cbPiernas.isEnabled = true
            binding.cbGluteos.isEnabled = true
            binding.cbAbdomen.isEnabled = true

            parteCuerpo1 = 1
            parteCuerpo2 = 1
        }


        //Parte con pecho
        else if (binding.cbPecho.isChecked && binding.cbEspalda.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 2
            parteCuerpo2 = 3
        } else if (binding.cbPecho.isChecked && binding.cbPiernas.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 2
            parteCuerpo2 = 4
        } else if (binding.cbPecho.isChecked && binding.cbGluteos.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 2
            parteCuerpo2 = 5
        } else if (binding.cbPecho.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 2
            parteCuerpo2 = 6
        }
        else if (binding.cbPecho.isChecked && !binding.cbBrazo.isChecked && !binding.cbEspalda.isChecked
            && !binding.cbPiernas.isChecked && !binding.cbGluteos.isChecked && !binding.cbAbdomen.isChecked) {

            binding.cbBrazo.isEnabled = true
            binding.cbEspalda.isEnabled = true
            binding.cbPiernas.isEnabled = true
            binding.cbGluteos.isEnabled = true
            binding.cbAbdomen.isEnabled = true

            parteCuerpo1 = 2
            parteCuerpo2 = 2
        }
            //Parte con espalda
            else if (binding.cbEspalda.isChecked && binding.cbPiernas.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbGluteos.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 3
            parteCuerpo2 = 4
            } else if (binding.cbEspalda.isChecked && binding.cbGluteos.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 3
            parteCuerpo2 = 5
            } else if (binding.cbEspalda.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbPiernas.isEnabled = false
            binding.cbGluteos.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 3
            parteCuerpo2 = 6
            }
        else if (binding.cbEspalda.isChecked && !binding.cbBrazo.isChecked && !binding.cbPecho.isChecked
            && !binding.cbPiernas.isChecked && !binding.cbGluteos.isChecked && !binding.cbAbdomen.isChecked) {

            binding.cbPecho.isEnabled = true
            binding.cbBrazo.isEnabled = true
            binding.cbPiernas.isEnabled = true
            binding.cbGluteos.isEnabled = true
            binding.cbAbdomen.isEnabled = true

            parteCuerpo1 = 3
            parteCuerpo2 = 3
        }
            //Parte con piernas
            else if (binding.cbPiernas.isChecked && binding.cbGluteos.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbAbdomen.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 4
            parteCuerpo2 = 5
            } else if (binding.cbPiernas.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbGluteos.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 4
            parteCuerpo2 = 6
            }
        else if (binding.cbPiernas.isChecked && !binding.cbBrazo.isChecked && !binding.cbEspalda.isChecked
            && !binding.cbPecho.isChecked && !binding.cbGluteos.isChecked && !binding.cbAbdomen.isChecked) {

            binding.cbPecho.isEnabled = true
            binding.cbBrazo.isEnabled = true
            binding.cbEspalda.isEnabled = true
            binding.cbGluteos.isEnabled = true
            binding.cbAbdomen.isEnabled = true

            parteCuerpo1 = 4
            parteCuerpo2 = 4
        }
            //Parte con gluteos
            else if (binding.cbGluteos.isChecked && binding.cbAbdomen.isChecked) {
            binding.cbBrazo.isEnabled = false
            binding.cbPecho.isEnabled = false
            binding.cbEspalda.isEnabled = false
            binding.cbPiernas.isEnabled = false
            //Poner variable de doble eleccion
            parteCuerpo1 = 5
            parteCuerpo2 = 6
            }
        else if (binding.cbGluteos.isChecked && !binding.cbBrazo.isChecked && !binding.cbEspalda.isChecked
            && !binding.cbPiernas.isChecked && !binding.cbPecho.isChecked && !binding.cbAbdomen.isChecked) {

            binding.cbPecho.isEnabled = true
            binding.cbBrazo.isEnabled = true
            binding.cbPiernas.isEnabled = true
            binding.cbEspalda.isEnabled = true
            binding.cbAbdomen.isEnabled = true

            parteCuerpo1 = 5
            parteCuerpo2 = 5
        }
        else if (binding.cbAbdomen.isChecked && !binding.cbBrazo.isChecked && !binding.cbEspalda.isChecked
            && !binding.cbPiernas.isChecked && !binding.cbGluteos.isChecked && !binding.cbPecho.isChecked) {

            binding.cbPecho.isEnabled = true
            binding.cbBrazo.isEnabled = true
            binding.cbPiernas.isEnabled = true
            binding.cbGluteos.isEnabled = true
            binding.cbEspalda.isEnabled = true

            parteCuerpo1 = 6
            parteCuerpo2 = 6
        }
        else{
            binding.cbBrazo.isEnabled = true
            binding.cbPecho.isEnabled = true
            binding.cbEspalda.isEnabled = true
            binding.cbPiernas.isEnabled = true
            binding.cbGluteos.isEnabled = true
            binding.cbAbdomen.isEnabled = true
            }
    }
    private fun eleccionEntrenamiento(){
        binding.cbBrazo.isEnabled = true
        binding.cbBrazo.isChecked = false
        binding.cbPecho.isEnabled = true
        binding.cbPecho.isChecked = false
        binding.cbEspalda.isEnabled = true
        binding.cbEspalda.isChecked = false
        binding.cbPiernas.isEnabled = true
        binding.cbPiernas.isChecked = false
        binding.cbGluteos.isEnabled = true
        binding.cbGluteos.isChecked = false
        binding.cbAbdomen.isEnabled = true
        binding.cbAbdomen.isChecked = false
        binding.cbTodo.isEnabled = true
        binding.cbTodo.isChecked = false
    }

}