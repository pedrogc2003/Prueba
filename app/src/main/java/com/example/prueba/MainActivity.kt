package com.example.prueba

import android.content.AbstractThreadedSyncAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var elementos: MutableList<ListaCompra>
    lateinit var adapter: ListaAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        elementos = ArrayList()

        getElementos()

        binding.BInsertar.setOnClickListener{
            addElemento(ListaCompra(nombre = binding.ETText.text.toString()))
        }
    }

     fun addElemento(elemento: ListaCompra) {
         CoroutineScope(Dispatchers.IO).launch {
             val id = MiListaApp.database.listaDao().addElemento(elemento)
             val recoveryElemento = MiListaApp.database.listaDao().getElementoId(id)
             runOnUiThread{
                 elementos.add(recoveryElemento)
                 adapter.notifyItemInserted(elementos.size)

             }
         }
    }

    fun getElementos() {
        CoroutineScope(Dispatchers.IO).launch {
            elementos = MiListaApp.database.listaDao().getAllElements()
            runOnUiThread{
                adapter = ListaAdapter(elementos,{updateLista(it)},{deleteLista(it)})
                recyclerView = binding.recycler
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = adapter
            }
        }
    }

    fun deleteLista(elemento: ListaCompra) {
        CoroutineScope(Dispatchers.IO).launch{
            val position = elementos.indexOf(elemento)
            MiListaApp.database.listaDao().deleteLista(elemento)
            elementos.remove(elemento)
            runOnUiThread {
                adapter.notifyItemRemoved(position)
            }
        }
    }

    fun updateLista(elemento: ListaCompra) {
        CoroutineScope(Dispatchers.IO).launch {
            elemento.activo = !elemento.activo
            MiListaApp.database.listaDao().updateLista(elemento)
        }
    }
}