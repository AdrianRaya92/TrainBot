package com.example.trainbot

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trainbot.databinding.ActivityEjerciciosBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.util.*
import kotlin.collections.ArrayList


class Ejercicios : AppCompatActivity() {

    lateinit var binding: ActivityEjerciciosBinding
    var listasEjercicios: ArrayList<String> = ArrayList()
    var listasEjercicios2: ArrayList<String> = ArrayList()
    var listasCalentamiento: ArrayList<String> = ArrayList()
    var listasEstiramientos: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)

        //Variables codigo de cada ejercicio a mostrar
        var codCalentamiento: Int = 1
        var numeroEjercicio: Int = 0
        var numeroEjercicio2: Int = 1
        var numeroEjercicio3: Int = 2
        var numeroEjercicio4: Int = 3
        var numeroEjercicio5: Int = 4
        var numeroEjercicio6: Int = 5
        var codEstiramientos: Int = 0

        var nAleatorio = Random()
        var num :Int = 0
        var num2 :Int = 0
        var num3 :Int = 0
        var num4 :Int = 0
        var num5 :Int = 0
        var num6 :Int = 0


        //Conexión base de datos Firestore
        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        //BD ejercicios
        val ejercicios = db.collection("ejercicios")

        binding = ActivityEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botón para entrar en la Activity para generar entrenamiento
        //Se debe borrar las listas
        binding.btAtras4.setOnClickListener{
            listasEjercicios.removeAt(0)


            val intent: Intent = Intent(this,GeneradorTrainer::class.java)
            startActivity(intent)
        }
        binding.btConsulta.setOnClickListener {

            //Variables de la activity GeneradorTrainer
            var bundle = intent.extras
            val pruebaEntreno:Int = bundle!!.getInt("entreno")
            val pruebaLugar:Int = bundle.getInt("lugar")
            val pruebaParteC1:Int = bundle.getInt("part1")
            val pruebaParteC2:Int = bundle.getInt("part2")
            val pruebaMaterial:Boolean = bundle.getBoolean("mater")

            //Texto de pruebas
            if(pruebaMaterial==true){
            binding.tvPrueba.text= ("Tipo entrenamiento: "+pruebaEntreno.toString()+
                    System.getProperty ("line.separator") +
                    "Lugar: " + pruebaLugar.toString() +
                    System.getProperty ("line.separator") +
                    "ParteCuerpo1: " + pruebaParteC1.toString() +
                    System.getProperty ("line.separator") +
                    "ParteCuerpo2: " + pruebaParteC2.toString() +
                    System.getProperty ("line.separator") +
                    "Material True")
            }
            else if(pruebaMaterial==false){
                binding.tvPrueba.text= ("Tipo entrenamiento"+pruebaEntreno.toString()+
                        System.getProperty ("line.separator") +
                        "Lugar" + pruebaLugar.toString() +
                        System.getProperty ("line.separator") +
                        "ParteCuerpo1" + pruebaParteC1.toString() +
                        System.getProperty ("line.separator") +
                        "ParteCuerpo2" + pruebaParteC2.toString() +
                        System.getProperty ("line.separator") +
                        "Material False")
            }

            //CONSULTAS BASE DE DATOS PARA LA CREACIÓN DE UNA LISTA Y GENERAR
            //ALEATORIAMENTE EL EJERCICIO DESDE ESA LISTA
            //ELECCIÓN DE UNA SOLA PARTE DEL CUERPO
            if(pruebaParteC1 == pruebaParteC2){
                //Base de datos con la misma parte del cuerpo
                var lista: String
                //Consultas para encontrar los ejercicios con dichos parametros
                ejercicios.whereEqualTo("tipoEjercicios", pruebaEntreno)
                    .whereEqualTo("lugar", pruebaLugar)
                    .whereEqualTo("material", pruebaMaterial)
                    .whereEqualTo("partesEntrenamiento", 2)
                    .whereIn("parteCuerpo",listOf(pruebaParteC1,pruebaParteC2))
                    .get()
                    .addOnSuccessListener{ result ->
                        //Bucle para encontrar todos los ejercicios que tengan los parámetros consultados
                        for(document in result){
                            //Recoger la id del ejercicio e introducirlo en una función con un Array
                            lista = "${document.id}"
                            ListaEjerciciosRandom(lista)
                        }
                        //Creación de variable con el id del Ejercicio que queremos mostrar
                        //Generar numero random a partir del contador de los datos que hay en la base de datos
                        var contadorEjercicios1: Int=listasEjercicios.count()
                        var nAleatorio = Random()
                        num = (0..1).random()
                        num2 = (2..3).random()
                        num3 = (4..5).random()
                        num4 = (6..7).random()
                        num5 = (8..9).random()
                        num6 = (10..(contadorEjercicios1-1)).random()
                        //num3 = nAleatorio.nextInt((contadorEjercicios1-4)+4)

                        numeroEjercicio = listasEjercicios.get(num).toInt()
                        numeroEjercicio2 = listasEjercicios.get(num2).toInt()
                        numeroEjercicio3 = listasEjercicios.get(num3).toInt()
                        numeroEjercicio4 = listasEjercicios.get(num4).toInt()
                        numeroEjercicio5 = listasEjercicios.get(num5).toInt()
                        numeroEjercicio6 = listasEjercicios.get(num6).toInt()
                }
            }

            //ELECCION VARIAS PARTES DEL CUERPO
            else if(pruebaParteC1 != pruebaParteC2){
                //Base de datos con la misma parte del cuerpo
                var lista: String
                var nAleatorio = Random()
                //Consultas para encontrar los ejercicios con dichos parametros
                ejercicios.whereEqualTo("tipoEjercicios", pruebaEntreno)
                    .whereEqualTo("lugar", pruebaLugar)
                    .whereEqualTo("material", pruebaMaterial)
                    .whereEqualTo("partesEntrenamiento", 2)
                    .whereEqualTo("parteCuerpo", pruebaParteC1)
                    .get()
                    .addOnSuccessListener{ result ->
                        //Bucle para encontrar todos los ejercicios que tengan los parámetros consultados
                        for(document in result){
                            //Recoger la id del ejercicio e introducirlo en una función con un Array
                            lista = "${document.id}"
                            ListaEjerciciosRandom(lista)
                        }
                        //Creación de variable con el id del Ejercicio que queremos mostrar
                        //Generar numero random a partir del contador de los datos que hay en la base de datos
                        var contadorEjercicios1: Int=listasEjercicios.count()

                        num = (0..3).random()
                        num2 = (4..7).random()
                        num3 = (8..(contadorEjercicios1-1)).random()

                        numeroEjercicio = listasEjercicios.get(num).toInt()
                        numeroEjercicio2 = listasEjercicios.get(num2).toInt()
                        numeroEjercicio3 = listasEjercicios.get(num3).toInt()

                    }
                //Base de datos con la misma parte del cuerpo
                var lista2: String
                //Consultas para encontrar los ejercicios con dichos parametros
                ejercicios.whereEqualTo("tipoEjercicios", pruebaEntreno)
                    .whereEqualTo("lugar", pruebaLugar)
                    .whereEqualTo("material", pruebaMaterial)
                    .whereEqualTo("partesEntrenamiento", 2)
                    .whereEqualTo("parteCuerpo", pruebaParteC2)
                    .get()
                    .addOnSuccessListener{ result ->
                        //Bucle para encontrar todos los ejercicios que tengan los parámetros consultados
                        for(document in result){
                            //Recoger la id del ejercicio e introducirlo en una función con un Array
                            lista2 = "${document.id}"
                            ListaEjercicios2Random(lista2)
                        }
                        //Creación de variable con el id del Ejercicio que queremos mostrar
                        //Generar numero random a partir del contador de los datos que hay en la base de datos
                        var contadorEjercicios2: Int=listasEjercicios2.count()
                        //var nAleatorio = Random()
                        num4 = (0..3).random()
                        num5 = (4..7).random()
                        num6 = (8..(contadorEjercicios2-1)).random()

                        numeroEjercicio4 = listasEjercicios2.get(num4).toInt()
                        numeroEjercicio5 = listasEjercicios2.get(num5).toInt()
                        numeroEjercicio6 = listasEjercicios2.get(num6).toInt()

                    }
            }

            /*
            ejercicios
                .document(codEjercicio1.toString()).get()
                .addOnSuccessListener {
                    binding.tvTituloEjercicio1.setText(it.get("titulo") as String?)
                    binding.tvTiempoEjercicio1.setText(it.get("tiempo") as String?)
                    binding.tvDescripcionEjercicio1.setText(it.get("descripcion") as String?)
                }
                .addOnFailureListener { exception ->
                    binding.tvDescripcionEjercicio1.text = "Fallo en la conexión a Internet"
                }*/


            //IMAGENES DE EJERCICIOS PARTE PRINCIPAL
            val imageName1 = "brazo"
            val imageName2 = "brazo"
            val imageName3 = "brazo"
            val imageName4 = "brazo"
            val imageName5 = "brazo"
            val imageName6 = "brazo"
            //IMAGEN CALENTAMIENTO
            val imageName7 = "brazo"
            //IMAGEN ESTIRAMIENTOS
            val imageName8 = "brazo"

            val storageRef1 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName1.jpg")
            val storageRef2 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName2.jpg")
            val storageRef3 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName3.jpg")
            val storageRef4 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName4.jpg")
            val storageRef5 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName5.jpg")
            val storageRef6 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName6.jpg")
            val storageRef7 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName7.jpg")
            val storageRef8 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName8.jpg")

            val localfile = File.createTempFile("tempImage", "jpg")

            val progressDialog= ProgressDialog(this)
            progressDialog.setMessage("Cargando ejercicios..."+
                    System.getProperty ("line.separator") +
                    "Conectando al servidor")
            progressDialog.setCancelable(false)
            progressDialog.show()

            //STORAGE DE LAS DIFERENTES IMAGENES
            val handler = Handler()
            handler.postDelayed({
                storageRef1.getFile(localfile).addOnSuccessListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                    binding.ivImagenEjercicio1.setImageBitmap(bitmap)
                }.addOnFailureListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    Toast.makeText(this,"Error imagen", Toast.LENGTH_SHORT).show()
                }
                //Base de datos Ejercicio1
                ejercicios
                    .document(numeroEjercicio.toString()).get()
                    .addOnSuccessListener {
                        binding.tvTituloEjercicio1.setText(it.get("titulo") as String?)
                        binding.tvTiempoEjercicio1.setText(it.get("tiempo") as String?)
                        binding.tvDescripcionEjercicio1.setText(it.get("descripcion") as String?)
                    }
                    .addOnFailureListener { exception ->
                        binding.tvDescripcionEjercicio1.text = "Fallo en la conexión a Internet"
                    }
            }, 1000)

            //Mostrar Ejercicio 2
            handler.postDelayed({
                storageRef2.getFile(localfile).addOnSuccessListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                    binding.ivImagenEjercicio2.setImageBitmap(bitmap)
                }.addOnFailureListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    Toast.makeText(this,"Error imagen", Toast.LENGTH_SHORT).show()
                }
                //Base de datos Ejercicio2
                ejercicios
                    .document(numeroEjercicio2.toString()).get()
                    .addOnSuccessListener {
                        binding.tvTituloEjercicio2.setText(it.get("titulo") as String?)
                        binding.tvTiempoEjercicio2.setText(it.get("tiempo") as String?)
                        binding.tvDescripcionEjercicio2.setText(it.get("descripcion") as String?)
                    }
                    .addOnFailureListener { exception ->
                        binding.tvDescripcionEjercicio2.text = "Fallo en la conexión a Internet"
                    }
            }, 1500)

            //Mostrar Ejercicio 3
                handler.postDelayed({
                    storageRef3.getFile(localfile).addOnSuccessListener {
                        if (progressDialog.isShowing)
                            progressDialog.dismiss()
                        val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                        binding.ivImagenEjercicio3.setImageBitmap(bitmap)
                    }.addOnFailureListener {
                        if (progressDialog.isShowing)
                            progressDialog.dismiss()
                        Toast.makeText(this, "Error imagen", Toast.LENGTH_SHORT).show()
                    }
                    //Base de datos Ejercicio3
                    ejercicios
                        .document(numeroEjercicio3.toString()).get()
                        .addOnSuccessListener {
                            binding.tvTituloEjercicio3.setText(it.get("titulo") as String?)
                            binding.tvTiempoEjercicio3.setText(it.get("tiempo") as String?)
                            binding.tvDescripcionEjercicio3.setText(it.get("descripcion") as String?)
                        }
                        .addOnFailureListener { exception ->
                            binding.tvDescripcionEjercicio3.text = "Fallo en la conexión a Internet"
                        }
                }, 2000)

            //Mostrar Ejercicio 4
            handler.postDelayed({
                storageRef4.getFile(localfile).addOnSuccessListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                    binding.ivImagenEjercicio4.setImageBitmap(bitmap)
                }.addOnFailureListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    Toast.makeText(this,"Error imagen", Toast.LENGTH_SHORT).show()
                }
                //Base de datos Ejercicio2
                ejercicios
                    .document(numeroEjercicio4.toString()).get()
                    .addOnSuccessListener {
                        binding.tvTituloEjercicio4.setText(it.get("titulo") as String?)
                        binding.tvTiempoEjercicio4.setText(it.get("tiempo") as String?)
                        binding.tvDescripcionEjercicio4.setText(it.get("descripcion") as String?)
                    }
                    .addOnFailureListener { exception ->
                        binding.tvDescripcionEjercicio4.text = "Fallo en la conexión a Internet"
                    }
            }, 2500)

            handler.postDelayed({
                storageRef5.getFile(localfile).addOnSuccessListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                    binding.ivImagenEjercicio5.setImageBitmap(bitmap)
                }.addOnFailureListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    Toast.makeText(this,"Error imagen", Toast.LENGTH_SHORT).show()
                }
                //Base de datos Ejercicio5
                ejercicios
                    .document(numeroEjercicio5.toString()).get()
                    .addOnSuccessListener {
                        binding.tvTituloEjercicio5.setText(it.get("titulo") as String?)
                        binding.tvTiempoEjercicio5.setText(it.get("tiempo") as String?)
                        binding.tvDescripcionEjercicio5.setText(it.get("descripcion") as String?)
                    }
                    .addOnFailureListener { exception ->
                        binding.tvDescripcionEjercicio5.text = "Fallo en la conexión a Internet"
                    }
            }, 3000)

            //Mostrar ejercicio 6
            handler.postDelayed({
                storageRef6.getFile(localfile).addOnSuccessListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                    binding.ivImagenEjercicio6.setImageBitmap(bitmap)
                }.addOnFailureListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    Toast.makeText(this,"Error imagen", Toast.LENGTH_SHORT).show()
                }
                //Base de datos Ejercicio6
                ejercicios
                    .document(numeroEjercicio6.toString()).get()
                    .addOnSuccessListener {
                        binding.tvTituloEjercicio6.setText(it.get("titulo") as String?)
                        binding.tvTiempoEjercicio6.setText(it.get("tiempo") as String?)
                        binding.tvDescripcionEjercicio6.setText(it.get("descripcion") as String?)
                    }
                    .addOnFailureListener { exception ->
                        binding.tvDescripcionEjercicio6.text = "Fallo en la conexión a Internet"
                    }
            }, 3500)

            //IMAGENES CALENTAMIENTO
            handler.postDelayed({
                storageRef7.getFile(localfile).addOnSuccessListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                    binding.ivCalentamiento.setImageBitmap(bitmap)
                }.addOnFailureListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    Toast.makeText(this,"Error imagen", Toast.LENGTH_SHORT).show()
                }
            }, 500)

            //IMAGENES ESTIRAMIENTOS
            handler.postDelayed({
                storageRef8.getFile(localfile).addOnSuccessListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                    binding.ivEstiramientos.setImageBitmap(bitmap)
                }.addOnFailureListener{
                    if(progressDialog.isShowing)
                        progressDialog.dismiss()
                    Toast.makeText(this,"Error imagen", Toast.LENGTH_SHORT).show()
                }
            }, 4000)


            //BASE DE DATOS DE LOS EJERCICIOS
            //Base de datos Calentamiento
            ejercicios
                .document(codCalentamiento.toString()).get()
                .addOnSuccessListener {
                    binding.tvTituloCalentamiento.setText(it.get("titulo") as String?)
                    binding.tvTiempoCalentamiento.setText(it.get("tiempo") as String?)
                    binding.tvDescripcionCalentamiento.setText(it.get("descripcion") as String?)
                 }
                 .addOnFailureListener { exception ->
                     binding.tvDescripcionCalentamiento.text = "Fallo en la conexión a Internet"
                 }
            binding.btConsulta.isEnabled = false
        }
    }
    fun ListaEjerciciosRandom(lista:String){
        listasEjercicios.add(lista)
         }
    fun ListaEjercicios2Random(lista2:String){
        listasEjercicios2.add(lista2)
    }
    fun ListaCalentamientoRandom(lista:String){
        listasCalentamiento.add(lista)
    }
    fun ListaEstiramientosRandom(lista:String){
        listasEstiramientos.add(lista)
    }
}