package com.cma.appquindio.ui.sitios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cma.appquindio.R
import com.cma.appquindio.adapter.ObjectAdapter
import com.cma.appquindio.vo.ObjectVo

class SitiosFragment : Fragment() {
    var lista = ArrayList<ObjectVo>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initData()
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_hoteles, container, false)
        var recyclerView:RecyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val adapter = ObjectAdapter(lista)
        recyclerView.adapter = adapter
        return view
    }
    fun initData(){
        var sitio1 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        var sitio2 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        var sitio3 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        lista.add(sitio1)
        lista.add(sitio2)
        lista.add(sitio3)
    }
}