package com.example.trainbot

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trainbot.databinding.ActivityEjerciciosBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.util.*


class Ejercicios : AppCompatActivity() {

    lateinit var binding: ActivityEjerciciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)

        //Variables codigo de cada ejercicio a mostrar
        var codCalentamiento = 9
        var numeroEjercicio = 0
        var numeroEjercicio2 = 1
        var numeroEjercicio3 = 2
        var numeroEjercicio4 = 3
        var numeroEjercicio5 = 4
        var numeroEjercicio6 = 5

        var numCalentamiento = 0
        var num = 0
        var num2 = 0
        var num3 = 0
        var num4 = 0
        var num5 = 0
        var num6 = 0


        //Conexión base de datos Firestore
        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        //BD ejercicios
        val ejercicios = db.collection("ejercicios")

        binding = ActivityEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botón para entrar en la Activity para generar entrenamiento
        binding.btAtras4.setOnClickListener{
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

            //CONDICIONES PARA MOSTRAR CALENTAMIENTO MEDIANTE RANDOM

            if(pruebaMaterial==true){
                numCalentamiento = (90..91).random()
                codCalentamiento = numCalentamiento
            }
            else if(pruebaMaterial==false){
                numCalentamiento = (91..92).random()
                codCalentamiento = numCalentamiento
            }

            //CONDICIONES PARA MOSTRAR LOS EJERCICIOS MEDIANTE RANDOM

            if(pruebaParteC1==pruebaParteC2 && pruebaParteC1!=7 && pruebaEntreno!=1) {
                if (pruebaEntreno == 2) {
                    var cuerpoNum: Int = pruebaParteC1 * 100
                    if (pruebaLugar == 1) {
                        num = (cuerpoNum..cuerpoNum + 1).random()
                        num2 = (cuerpoNum + 2..cuerpoNum + 3).random()
                        num3 = (cuerpoNum + 4..cuerpoNum + 5).random()
                        num4 = (cuerpoNum + 6..cuerpoNum + 7).random()
                        num5 = (cuerpoNum + 8..cuerpoNum + 9).random()
                        num6 = cuerpoNum + 10
                    } else if (pruebaLugar == 2) {
                        if (pruebaMaterial == true) {
                            num = (cuerpoNum + 20..cuerpoNum + 21).random()
                            num2 = (cuerpoNum + 22..cuerpoNum + 23).random()
                            num3 = (cuerpoNum + 24..cuerpoNum + 25).random()
                            num4 = (cuerpoNum + 26..cuerpoNum + 27).random()
                            num5 = (cuerpoNum + 28..cuerpoNum + 29).random()
                            num6 = cuerpoNum + 30
                        } else if (pruebaMaterial == false) {
                            num = (cuerpoNum + 40..cuerpoNum + 41).random()
                            num2 = (cuerpoNum + 42..cuerpoNum + 43).random()
                            num3 = (cuerpoNum + 44..cuerpoNum + 45).random()
                            num4 = (cuerpoNum + 46..cuerpoNum + 47).random()
                            num5 = (cuerpoNum + 48..cuerpoNum + 49).random()
                            num6 = cuerpoNum + 50
                        }
                    }
                }
                else if (pruebaEntreno == 3) {
                    var cuerpoNum: Int = pruebaParteC1 * 1100
                    if (pruebaLugar == 1) {
                            num = (cuerpoNum..cuerpoNum + 1).random()
                            num2 = (cuerpoNum + 2..cuerpoNum + 3).random()
                            num3 = (cuerpoNum + 4..cuerpoNum + 5).random()
                            num4 = (cuerpoNum + 6..cuerpoNum + 7).random()
                            num5 = (cuerpoNum + 8..cuerpoNum + 9).random()
                            num6 = cuerpoNum + 10
                        } else if (pruebaLugar == 2) {
                            if (pruebaMaterial == true) {
                                num = (cuerpoNum + 20..cuerpoNum + 21).random()
                                num2 = (cuerpoNum + 22..cuerpoNum + 23).random()
                                num3 = (cuerpoNum + 24..cuerpoNum + 25).random()
                                num4 = (cuerpoNum + 26..cuerpoNum + 27).random()
                                num5 = (cuerpoNum + 28..cuerpoNum + 29).random()
                                num6 = cuerpoNum + 30
                            } else if (pruebaMaterial == false) {
                                num = (cuerpoNum + 40..cuerpoNum + 41).random()
                                num2 = (cuerpoNum + 42..cuerpoNum + 43).random()
                                num3 = (cuerpoNum + 44..cuerpoNum + 45).random()
                                num4 = (cuerpoNum + 46..cuerpoNum + 47).random()
                                num5 = (cuerpoNum + 48..cuerpoNum + 49).random()
                                num6 = cuerpoNum + 50
                            }
                        }
                    }
                else if (pruebaEntreno == 4) {
                    var cuerpoNum: Int = pruebaParteC1 * 11100
                        if (pruebaLugar == 1) {
                            num = (cuerpoNum..cuerpoNum + 1).random()
                            num2 = (cuerpoNum + 2..cuerpoNum + 3).random()
                            num3 = (cuerpoNum + 4..cuerpoNum + 5).random()
                            num4 = (cuerpoNum + 6..cuerpoNum + 7).random()
                            num5 = (cuerpoNum + 8..cuerpoNum + 9).random()
                            num6 = cuerpoNum + 10
                        } else if (pruebaLugar == 2) {
                            if (pruebaMaterial == true) {
                                num = (cuerpoNum + 20..cuerpoNum + 21).random()
                                num2 = (cuerpoNum + 22..cuerpoNum + 23).random()
                                num3 = (cuerpoNum + 24..cuerpoNum + 25).random()
                                num4 = (cuerpoNum + 26..cuerpoNum + 27).random()
                                num5 = (cuerpoNum + 28..cuerpoNum + 29).random()
                                num6 = cuerpoNum + 30
                            } else if (pruebaMaterial == false) {
                                num = (cuerpoNum + 40..cuerpoNum + 41).random()
                                num2 = (cuerpoNum + 42..cuerpoNum + 43).random()
                                num3 = (cuerpoNum + 44..cuerpoNum + 45).random()
                                num4 = (cuerpoNum + 46..cuerpoNum + 47).random()
                                num5 = (cuerpoNum + 48..cuerpoNum + 49).random()
                                num6 = cuerpoNum + 50
                            }
                        }
                    }
                    numeroEjercicio = num
                    numeroEjercicio2 = num2
                    numeroEjercicio3 = num3
                    numeroEjercicio4 = num4
                    numeroEjercicio5 = num5
                    numeroEjercicio6 = num6

                }

            else if(pruebaParteC1!=pruebaParteC2 && pruebaParteC1!=7 && pruebaEntreno!=1){
                if (pruebaEntreno == 2) {
                    var cuerpoNum: Int = pruebaParteC1 * 100
                    var cuerpoNum2: Int = pruebaParteC2 * 100
                    if (pruebaLugar == 1) {
                        num = (cuerpoNum..cuerpoNum + 4).random()
                        num2 = (cuerpoNum + 5..cuerpoNum + 7).random()
                        num3 = (cuerpoNum + 8..cuerpoNum + 10).random()
                        num4 = (cuerpoNum2..cuerpoNum2 + 4).random()
                        num5 = (cuerpoNum2 + 5..cuerpoNum2 + 7).random()
                        num6 = (cuerpoNum2 + 8..cuerpoNum2 + 10).random()
                    } else if (pruebaLugar == 2) {
                        if (pruebaMaterial == true) {
                            num = (cuerpoNum + 20..cuerpoNum + 24).random()
                            num2 = (cuerpoNum + 25..cuerpoNum + 27).random()
                            num3 = (cuerpoNum + 28..cuerpoNum + 30).random()
                            num4 = (cuerpoNum2 + 20..cuerpoNum2 + 24).random()
                            num5 = (cuerpoNum2 + 25..cuerpoNum2 + 27).random()
                            num6 = (cuerpoNum2 + 28..cuerpoNum2 + 30).random()
                        } else if (pruebaMaterial == false) {
                            num = (cuerpoNum + 40..cuerpoNum + 44).random()
                            num2 = (cuerpoNum + 45..cuerpoNum + 47).random()
                            num3 = (cuerpoNum + 48..cuerpoNum + 80).random()
                            num4 = (cuerpoNum2 + 40..cuerpoNum2 + 44).random()
                            num5 = (cuerpoNum2 + 45..cuerpoNum2 + 47).random()
                            num6 = (cuerpoNum2 + 48..cuerpoNum2 + 50).random()
                        }
                    }
                }
                else if (pruebaEntreno == 3) {
                    var cuerpoNum: Int = pruebaParteC1 * 1100
                    var cuerpoNum2: Int = pruebaParteC2 * 1100
                    if (pruebaLugar == 1) {
                        num = (cuerpoNum..cuerpoNum + 4).random()
                        num2 = (cuerpoNum + 5..cuerpoNum + 7).random()
                        num3 = (cuerpoNum + 8..cuerpoNum + 10).random()
                        num4 = (cuerpoNum2..cuerpoNum2 + 4).random()
                        num5 = (cuerpoNum2 + 5..cuerpoNum2 + 7).random()
                        num6 = (cuerpoNum2 + 8..cuerpoNum2 + 10).random()
                    } else if (pruebaLugar == 2) {
                        if (pruebaMaterial == true) {
                            num = (cuerpoNum + 20..cuerpoNum + 24).random()
                            num2 = (cuerpoNum + 25..cuerpoNum + 27).random()
                            num3 = (cuerpoNum + 28..cuerpoNum + 30).random()
                            num4 = (cuerpoNum2 + 20..cuerpoNum2 + 24).random()
                            num5 = (cuerpoNum2 + 25..cuerpoNum2 + 27).random()
                            num6 = (cuerpoNum2 + 28..cuerpoNum2 + 30).random()
                        } else if (pruebaMaterial == false) {
                            num = (cuerpoNum + 40..cuerpoNum + 44).random()
                            num2 = (cuerpoNum + 45..cuerpoNum + 47).random()
                            num3 = (cuerpoNum + 48..cuerpoNum + 80).random()
                            num4 = (cuerpoNum2 + 40..cuerpoNum2 + 44).random()
                            num5 = (cuerpoNum2 + 45..cuerpoNum2 + 47).random()
                            num6 = (cuerpoNum2 + 48..cuerpoNum2 + 50).random()
                        }
                    }
                }
                else if (pruebaEntreno == 4) {
                    var cuerpoNum: Int = pruebaParteC1 * 11100
                    var cuerpoNum2: Int = pruebaParteC2 * 11100
                    if (pruebaLugar == 1) {
                        num = (cuerpoNum..cuerpoNum + 4).random()
                        num2 = (cuerpoNum + 5..cuerpoNum + 7).random()
                        num3 = (cuerpoNum + 8..cuerpoNum + 10).random()
                        num4 = (cuerpoNum2..cuerpoNum2 + 4).random()
                        num5 = (cuerpoNum2 + 5..cuerpoNum2 + 7).random()
                        num6 = (cuerpoNum2 + 8..cuerpoNum2 + 10).random()
                    } else if (pruebaLugar == 2) {
                        if (pruebaMaterial == true) {
                            num = (cuerpoNum + 20..cuerpoNum + 24).random()
                            num2 = (cuerpoNum + 25..cuerpoNum + 27).random()
                            num3 = (cuerpoNum + 28..cuerpoNum + 30).random()
                            num4 = (cuerpoNum2 + 20..cuerpoNum2 + 24).random()
                            num5 = (cuerpoNum2 + 25..cuerpoNum2 + 27).random()
                            num6 = (cuerpoNum2 + 28..cuerpoNum2 + 30).random()
                        } else if (pruebaMaterial == false) {
                            num = (cuerpoNum + 40..cuerpoNum + 44).random()
                            num2 = (cuerpoNum + 45..cuerpoNum + 47).random()
                            num3 = (cuerpoNum + 48..cuerpoNum + 80).random()
                            num4 = (cuerpoNum2 + 40..cuerpoNum2 + 44).random()
                            num5 = (cuerpoNum2 + 45..cuerpoNum2 + 47).random()
                            num6 = (cuerpoNum2 + 48..cuerpoNum2 + 50).random()
                        }
                    }
                }
                numeroEjercicio = num
                numeroEjercicio2 = num2
                numeroEjercicio3 = num3
                numeroEjercicio4 = num4
                numeroEjercicio5 = num5
                numeroEjercicio6 = num6
            }

            else if(pruebaParteC1==7 && pruebaEntreno!=1){
                if (pruebaEntreno == 2) {
                    if (pruebaLugar == 1) {
                        num = (100..110).random()
                        num2 = (200..210).random()
                        num3 = (300..310).random()
                        num4 = (400..410).random()
                        num5 = (500..510).random()
                        num6 = (600..610).random()
                    } else if (pruebaLugar == 2) {
                        if (pruebaMaterial == true) {
                            num = (120..130).random()
                            num2 = (220..230).random()
                            num3 = (320..330).random()
                            num4 = (420..430).random()
                            num5 = (520..530).random()
                            num6 = (620..630).random()
                        } else if (pruebaMaterial == false) {
                            num = (140..150).random()
                            num2 = (240..250).random()
                            num3 = (340..350).random()
                            num4 = (440..450).random()
                            num5 = (540..550).random()
                            num6 = (640..650).random()
                        }
                    }
                }
                else if (pruebaEntreno == 3) {
                        if (pruebaLugar == 1) {
                            num = (1100..1110).random()
                            num2 = (2200..2210).random()
                            num3 = (3300..3310).random()
                            num4 = (4400..4410).random()
                            num5 = (5500..5510).random()
                            num6 = (6600..6610).random()
                        } else if (pruebaLugar == 2) {
                            if (pruebaMaterial == true) {
                                num = (1120..1130).random()
                                num2 = (2220..2230).random()
                                num3 = (3320..3330).random()
                                num4 = (4420..4430).random()
                                num5 = (5520..5530).random()
                                num6 = (6620..6630).random()
                            } else if (pruebaMaterial == false) {
                                num = (1140..1150).random()
                                num2 = (2240..2250).random()
                                num3 = (3340..3350).random()
                                num4 = (4440..4450).random()
                                num5 = (5540..5550).random()
                                num6 = (6640..6650).random()
                            }
                        }
                    }
                else if (pruebaEntreno == 4) {
                        if (pruebaLugar == 1) {
                            num = (11100..11110).random()
                            num2 = (22200..22210).random()
                            num3 = (33300..33310).random()
                            num4 = (44400..44410).random()
                            num5 = (55500..55510).random()
                            num6 = (66600..66610).random()
                        } else if (pruebaLugar == 2) {
                            if (pruebaMaterial == true) {
                                num = (11120..11130).random()
                                num2 = (22220..22230).random()
                                num3 = (33320..33330).random()
                                num4 = (44420..44430).random()
                                num5 = (55520..55530).random()
                                num6 = (66620..66630).random()
                            } else if (pruebaMaterial == false) {
                                num = (11140..11150).random()
                                num2 = (22240..22250).random()
                                num3 = (33340..33350).random()
                                num4 = (44440..44450).random()
                                num5 = (55540..55550).random()
                                num6 = (66640..66650).random()
                            }
                        }
                    }
                    numeroEjercicio = num
                    numeroEjercicio2 = num2
                    numeroEjercicio3 = num3
                    numeroEjercicio4 = num4
                    numeroEjercicio5 = num5
                    numeroEjercicio6 = num6
                }

            else if(pruebaEntreno==1){
                if(pruebaLugar==1){
                    num = (800..801).random()
                    num2 = (802..803).random()
                    num3 = (804..805).random()
                    num4 = (806..807).random()
                    num5 = (808..809).random()
                    num6 = 810
                }
                else if(pruebaLugar==2){
                    if(pruebaMaterial==true){
                        num = (820..821).random()
                        num2 = (822..823).random()
                        num3 = (824..825).random()
                        num4 = (826..827).random()
                        num5 = (828..829).random()
                        num6 = 830
                    }
                    else if(pruebaMaterial==false){
                        num = (840..841).random()
                        num2 = (842..843).random()
                        num3 = (844..845).random()
                        num4 = (846..847).random()
                        num5 = (848..849).random()
                        num6 = 850
                    }
                }
                numeroEjercicio = num
                numeroEjercicio2 = num2
                numeroEjercicio3 = num3
                numeroEjercicio4 = num4
                numeroEjercicio5 = num5
                numeroEjercicio6 = num6
            }







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

            val handler = Handler()

            handler.postDelayed({
            //IMAGENES DE EJERCICIOS PARTE PRINCIPAL
            val imageName1 = "brazo"
            val imageName2 = "brazo"
            val imageName3 = "brazo"
            val imageName4 = "brazo"
            val imageName5 = "brazo"
            val imageName6 = "brazo"
            //IMAGEN CALENTAMIENTO
            val imageName7 = "brazo"

            //Conexión al storage de la base de datos Firebase para coger las imagenes
            val storageRef1 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName1.jpg")
            val storageRef2 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName2.jpg")
            val storageRef3 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName3.jpg")
            val storageRef4 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName4.jpg")
            val storageRef5 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName5.jpg")
            val storageRef6 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName6.jpg")
            val storageRef7 = FirebaseStorage.getInstance().reference.child("ejercicios/$imageName7.jpg")

            val localfile = File.createTempFile("tempImage", "jpg")

            val progressDialog= ProgressDialog(this)
            progressDialog.setMessage("Cargando ejercicios..."+
                    System.getProperty ("line.separator") +
                    "Conectando al servidor")
            progressDialog.setCancelable(false)
            progressDialog.show()

            //STORAGE DE LAS DIFERENTES IMAGENES


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
            }, 1250)

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
            }, 1600)

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
                }, 2100)

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
                //Base de datos Ejercicio4
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
            }, 3400)

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
            }, 750)

            //TEXTO ESTIRAMIENTOS
            handler.postDelayed({
                var textoEstiramiento = ""

                if(pruebaParteC1 == 1) textoEstiramiento= "del BRAZO (Biceps, Triceps, Antebrazo...)"
                else if(pruebaParteC1 == 2) textoEstiramiento= "del PECHO (Pectoral mayor y menor)"
                else if(pruebaParteC1 == 3) textoEstiramiento= "de la ESPALDA (Trapecio, Dorsal, Deltoides...)"
                else if(pruebaParteC1 == 4) textoEstiramiento= "de la PIERNA (Cuádriceps, Isquiotibiales, Gemelos...)"
                else if(pruebaParteC1 == 5) textoEstiramiento= "del GLÚTEO (Mayor, Medio, Aductor...)"
                else if(pruebaParteC1 == 6) textoEstiramiento= "del ABDOMEN (Oblicuos, Recto, Transverso...)"
                else if(pruebaParteC1 == 7) textoEstiramiento= "de cada una de las partes del cuerpo"

                if(pruebaParteC1 == pruebaParteC2){
                    binding.tvDescripcionEstiramientos.text ="Realizar lentamente los estiramientos e inspirar en la elongación" +
                            " y expirar en la contracción de los músculos " + textoEstiramiento + " con los que se han trabajado."
                }
                else if(pruebaParteC1 != pruebaParteC2){
                    var textoEstiramiento2 = ""

                    if(pruebaParteC2 == 1) textoEstiramiento2= "BRAZOS (Biceps, Triceps, Antebrazo...)"
                    else if(pruebaParteC2 == 2) textoEstiramiento2= "del PECHO (Pectoral mayor y menor)"
                    else if(pruebaParteC2 == 3) textoEstiramiento2= "de la ESPALDA (Trapecio, Dorsal, Deltoides...)"
                    else if(pruebaParteC2 == 4) textoEstiramiento2= "de la PIERNA (Cuádriceps, Isquiotibiales, Gemelos...)"
                    else if(pruebaParteC2 == 5) textoEstiramiento2= "del GLÚTEO (Mayor, Medio, Aductor...)"
                    else if(pruebaParteC2 == 6) textoEstiramiento2= "del ABDOMEN (Oblicuos, Recto, Transverso...)"
                    binding.tvDescripcionEstiramientos.text = "Realizar lentamente los estiramientos e inspirar en la elongación" +
                            " y expirar en la contracción de los músculos " + textoEstiramiento + " y " + textoEstiramiento2 +
                            " con los que se han trabajado."
                }
            }, 3700)

            }, 250)
        }
    }
}