package com.cma.appquindio.ui.sitios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cma.appquindio.R
import com.cma.appquindio.adapter.hoteles.ObjectAdapter
import com.cma.appquindio.adapter.sitios.ObjectAdapterSit
import com.cma.appquindio.adapter.sitios.ObjectAdapterSitTwo
import com.cma.appquindio.databinding.FragmentSitiosBinding
import com.cma.appquindio.vo.ObjectVo

class SitiosFragment : Fragment() {
    var lista = ArrayList<ObjectVo>()
    private var _binding: FragmentSitiosBinding? = null
    private val binding get() = _binding!!
    private var adaptador: ObjectAdapterSit = ObjectAdapterSit()
    private var adaptadorDos: ObjectAdapterSitTwo = ObjectAdapterSitTwo()
    var valor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initData()
        // Inflate the layout for this fragment
        _binding= FragmentSitiosBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = LinearLayoutManager(view.context)
        adaptador.ObjectAdapterRestSit(lista, view.context)
        binding.recycler.adapter=adaptador
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.linear ->{
                if(valor==0){
                    item.setIcon(R.drawable.ic_menu_camera)
                    binding.recycler.layoutManager=GridLayoutManager(view?.context, 2)
                    adaptadorDos.ObjectAdapterSitTwo(lista, requireView().context)
                    binding.recycler.adapter=adaptadorDos
                    valor=1
                }else{
                    item.setIcon(R.drawable.ic_launcher_foreground)
                    binding.recycler.layoutManager=LinearLayoutManager(view?.context)
                    adaptador.ObjectAdapterRestSit(lista, requireView().context)
                    binding.recycler.adapter=adaptador
                    valor=0
                }
            }
        }

        return super.onOptionsItemSelected(item)
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