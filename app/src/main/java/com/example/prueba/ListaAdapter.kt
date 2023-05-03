package com.example.prueba

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListaAdapter(val elementos: List<ListaCompra>,
                   val updateLista:(ListaCompra) -> Unit,
                   val deleteLista: (ListaCompra) -> Unit) : RecyclerView.Adapter<ListaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListaViewHolder(layoutInflater.inflate(R.layout.elemento, parent, false))
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val item = elementos[position]

        holder.bind(item, updateLista, deleteLista)
    }

    override fun getItemCount(): Int {
        return elementos.size
    }
}