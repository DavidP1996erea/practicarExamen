package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.xdEntity


class xdAdapter(
    val listaJugadores: List< xdEntity>,

    ) : RecyclerView.Adapter< xdAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listaJugadores[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.items, parent, false))
    }

    override fun getItemCount(): Int {
        return listaJugadores.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvJugadores = view.findViewById<TextView>(R.id.tvNombreJugadores)
        val tvPulsaciones = view.findViewById<TextView>(R.id.tvPulsacionesJugadores)


        fun bind(
            task: xdEntity

        ) {
            tvJugadores.text = "- " + task.nombre
            tvPulsaciones.text = " Pulsaciones: "+  task.telefono.toString()

        }
    }
}
