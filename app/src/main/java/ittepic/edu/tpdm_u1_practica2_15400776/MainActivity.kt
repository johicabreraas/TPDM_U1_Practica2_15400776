package ittepic.edu.tpdm_u1_practica2_15400776

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    var celdillas : EditText?=null
    var renglones : EditText?=null
    var radioGroup : RadioGroup?=null
    var radiobotonVector : RadioButton?=null
    var radiobotonMatriz : RadioButton?=null
    var layoutrenglones : LinearLayout?=null
    var lista : ListView?=null
    var caso2 : String =  "true"
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

       celdillas = findViewById(R.id.campoceldillas)
       renglones = findViewById(R.id.camporenglones)
       radioGroup = findViewById(R.id.rg)
       radiobotonVector = findViewById(R.id.rbVector)
       radiobotonMatriz = findViewById(R.id.rbMatriz)
       layoutrenglones = findViewById(R.id.layout_ren)
       lista = findViewById(R.id.opciones)

       radiobotonVector?.setOnClickListener {
           layoutrenglones?.setVisibility(View.GONE)
       }
       radiobotonMatriz?.setOnClickListener {
           layoutrenglones?.setVisibility(View.VISIBLE)
       }


       lista?.setOnItemClickListener { adapterView, view, i, l ->
           when (i) {
               0 -> abrirCapturar()
               1 -> abrirMostrar()
               2 -> abrirAcercaDe()
               3 -> finish()
           }
       }
   }

       fun abrirCapturar(){
           if (radiobotonMatriz?.isChecked == true) {
               var FaltanDatos : Boolean = true
               if (celdillas?.text.toString().isEmpty() == true) {
                   val alerta = AlertDialog.Builder(this)
                   alerta.setTitle("ERROR!!").setMessage("Por Favor Escribe el Numero de Celdillas que Deseas ")
                       .show()
               }
               if (renglones?.text.toString().isEmpty() == true) {
                   val alerta = AlertDialog.Builder(this)
                   alerta.setTitle("ERROR!!").setMessage("Por Favor Escribe el Numero de Renglones que Deseas")
                       .show()
                   return
               }

               var CapturarDatos  = Intent(this, Main2Activity::class.java)
               startActivity(CapturarDatos)

           }
           if(radiobotonVector?.isChecked==true) {
               if (celdillas?.text.toString().isEmpty() == true) {
                   val alerta = AlertDialog.Builder(this)
                   alerta.setTitle("ERROR!!").setMessage("Por Favor Escribe el Numero de Celdillas que Deseas")
                       .show()
                   return
               }

               var CapturaDatos  = Intent(this, Main2Activity::class.java)

               CapturaDatos.putExtra("Lugar1",caso2)
               startActivity(CapturaDatos)
           }

           var CapturaDatos  = Intent(this, Main2Activity::class.java)
           startActivity(CapturaDatos)

       }
       fun abrirMostrar(){


       }
       fun abrirAcercaDe(){
           val alerta = AlertDialog.Builder(this)

           alerta.setTitle("Acerca De...").setMessage("(C) Jose Hilario Cabrera Astorga")
               .setPositiveButton("Aceptar"){dialogInterface, i ->  }
               .show()
       }
    }

