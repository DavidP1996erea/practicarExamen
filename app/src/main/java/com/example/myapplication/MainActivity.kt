package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var roomDB: xdDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDB = Room.databaseBuilder(
            this.applicationContext,
            xdDataBase::class.java,
            "pruebaBaseDatos"
        ).build()

    }



    fun insertarPersona(view: View){
        var entryNombre = findViewById<EditText>(R.id.etinsertar)

        if (entryNombre.text.isNotEmpty()) {
            GlobalScope.launch(Dispatchers.IO) {


                val persona = xdEntity(entryNombre.text.toString(), 601265306, "Islas Baleares")
                roomDB.xdDao().insertPersona(persona)
            }
        }

    }

    fun logearse(view: View){
        var etiquetaRegistro = findViewById<EditText>(R.id.etNombrePersona)
        val nombre = etiquetaRegistro.text
        var a = Intent(this, cuerpo::class.java)
        if (nombre.isNotEmpty()){


            GlobalScope.launch(Dispatchers.IO){

                if(roomDB.xdDao().mostrarJugadores().contains(roomDB.xdDao().mostrarJugador(nombre.toString()))){


                    startActivity(a)

                }
            }
        }
    }



}