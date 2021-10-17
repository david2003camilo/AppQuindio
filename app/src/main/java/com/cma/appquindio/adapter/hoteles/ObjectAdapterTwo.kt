package com.cma.appquindio.adapter.hoteles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cma.appquindio.R
import com.cma.appquindio.vo.ObjectVo

class ObjectAdapterTwo: RecyclerView.Adapter<ObjectAdapterTwo.ViewHolder>() {
    var lista: MutableList<ObjectVo> = arrayListOf()
    lateinit var context: Context

    fun ObjectAdapterTwo(lista:MutableList<ObjectVo>, context: Context){
        this.lista = lista
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context)
        return ViewHolder(
            layout.inflate(R.layout.list_view_object_two, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val objeto = lista[position]
        holder.bind(objeto, context)
        holder.itemView.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_nav_hotel_to_fragmentDescription).onClick(holder.itemView)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById(R.id.name) as TextView
        val ubicacion = view.findViewById(R.id.ubication) as TextView
        fun bind(objectVo: ObjectVo, context: Context){
            nombre.text = objectVo.name
            ubicacion.text = objectVo.ubicacion
        }
    }

}