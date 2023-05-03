package com.example.prueba

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ElementoBinding

class ListaViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val binding = ElementoBinding.bind(view)

    fun bind(elemento: ListaCompra, updateLista: (ListaCompra) -> Unit, deleteLista: (ListaCompra) -> Unit){
        binding.elementolista.text = elemento.nombre
        binding.pulsado.isChecked = elemento.activo

        binding.pulsado.setOnClickListener{updateLista(elemento)}
        itemView.setOnClickListener {deleteLista(elemento)}
    }
}