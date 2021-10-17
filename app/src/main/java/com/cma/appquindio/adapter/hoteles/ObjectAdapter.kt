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

class ObjectAdapter:RecyclerView.Adapter<ObjectAdapter.ViewHolder>(){

    var listaObjetos:MutableList<ObjectVo> = arrayListOf()
    lateinit var context: Context

    fun ObjectAdapter(listaObjetos:MutableList<ObjectVo>, context: Context){
        this.listaObjetos=listaObjetos
        this.context=context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context)
        return ViewHolder(
            layout.inflate(R.layout.list_view_object, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val objetos = listaObjetos[position]
        holder.bind(objetos, context)
        holder.itemView.setOnClickListener { R.layout.fragment_description_hoteles
            Navigation.createNavigateOnClickListener(R.id.action_nav_hotel_to_fragmentDescription).onClick(holder.itemView)
        }
    }

    override fun getItemCount(): Int {
        return listaObjetos.size
    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        var itemName = view.findViewById(R.id.name) as TextView
        var itemDescription = view.findViewById(R.id.decription) as TextView
        var ubication = view.findViewById(R.id.ubication) as TextView
        fun bind(objectVo: ObjectVo, context: Context){
            itemName.text = objectVo.name
            itemDescription.text = objectVo.decription
            ubication.text = objectVo.ubicacion
        }
    }
}