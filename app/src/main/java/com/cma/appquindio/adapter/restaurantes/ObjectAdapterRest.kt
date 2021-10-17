package com.cma.appquindio.adapter.restaurantes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cma.appquindio.R
import com.cma.appquindio.vo.ObjectVo

class ObjectAdapterRest:RecyclerView.Adapter<ObjectAdapterRest.ViewHolder>() {
    var lista: MutableList<ObjectVo> = arrayListOf()
    lateinit var context: Context

    fun ObjectAdapterRest(lista:MutableList<ObjectVo>, context: Context){
        this.lista=lista
        this.context=context
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val nombre = view.findViewById(R.id.name) as TextView
        val ubicacion = view.findViewById(R.id.ubication) as TextView
        val descripcion = view.findViewById(R.id.decription) as TextView
        fun bind(objectVo: ObjectVo, context: Context){
            nombre.text=objectVo.name
            ubicacion.text=objectVo.ubicacion
            descripcion.text=objectVo.decription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context)
        return ViewHolder(
            layout.inflate(R.layout.list_view_object, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lista = lista[position]
        holder.bind(lista, context)
        holder.itemView.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_nav_restaurantes_to_fragmentDescriptionRestaurantes).onClick(holder.itemView)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}