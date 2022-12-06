package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.xdApp
import com.example.myapplication.xdDataBase
import com.example.myapplication.xdEntity
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


lateinit var recyclerView: RecyclerView
lateinit var adapter: xdAdapter
lateinit var tasks: MutableList< xdEntity>

private lateinit var roomDB: xdDataBase

class cuerpo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuerpo)
        tasks = ArrayList()
        getTasks()

    }


    fun getTasks()= runBlocking {       // Corrutina que saca de la base de datos la lista de tareas
        launch {                        // Inicio del hilo
            tasks = xdApp.database.xdDao().mostrarJugadores()     // Se carga la lista de tareas
            setUpRecyclerView(tasks)        // se pasa la lista a la Vista
        }
    }



    fun setUpRecyclerView(tasks: List< xdEntity>) {    // Método que muestra la vista usando el adaptador
        adapter = xdAdapter(tasks)
        recyclerView = findViewById(R.id.rvRecycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


}