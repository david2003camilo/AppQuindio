package com.cma.appquindio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cma.appquindio.R
import com.cma.appquindio.vo.ObjectVo

class ObjectAdapter(objects:ArrayList<ObjectVo>):RecyclerView.Adapter<ObjectAdapter.ViewHolder>(){
    val objects= objects
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectAdapter.ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.list_view_object,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectAdapter.ViewHolder, position: Int) {
        holder.itemName.text = objects.get(position).name
        holder.itemDescription.text = objects.get(position).decription
        holder.ubication.text = objects.get(position).ubicacion
    }

    override fun getItemCount(): Int {
        return objects.size
    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var itemName:TextView
        var itemImg: ImageView
        var itemDescription :TextView
        var ubication :TextView
        init {
            itemImg = view.findViewById(R.id.photo)
            itemDescription = view.findViewById(R.id.decription)
            ubication = view.findViewById(R.id.ubication)
            itemName = view.findViewById(R.id.name)
        }
    }
}