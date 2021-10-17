package com.cma.appquindio.ui.restaurantes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cma.appquindio.R
import com.cma.appquindio.adapter.hoteles.ObjectAdapter
import com.cma.appquindio.adapter.hoteles.ObjectAdapterTwo
import com.cma.appquindio.adapter.restaurantes.ObjectAdapterRest
import com.cma.appquindio.adapter.restaurantes.ObjectAdapterRestTwo
import com.cma.appquindio.databinding.FragmentRestaurantesBinding
import com.cma.appquindio.vo.ObjectVo

class RestaurantesFragment : Fragment() {
    var lista = ArrayList<ObjectVo>()
    private var _binding: FragmentRestaurantesBinding? = null
    private val binding get() = _binding!!
    var valor = 0
    private var adaptador:ObjectAdapterRest = ObjectAdapterRest()
    private var adaptadorDos:ObjectAdapterRestTwo = ObjectAdapterRestTwo()

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
        _binding= FragmentRestaurantesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = LinearLayoutManager(view.context)
        adaptador.ObjectAdapterRest(lista, view.context)
        binding.recycler.adapter=adaptador
    }

    fun initData(){
        var sitio1 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        var sitio2 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        var sitio3 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        lista.add(sitio1)
        lista.add(sitio2)
        lista.add(sitio3)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.linear->{
                if(valor==0){
                    item.setIcon(R.drawable.ic_menu_camera)
                    binding.recycler.layoutManager=GridLayoutManager(view?.context, 2)
                    adaptadorDos.ObjectAdapterRestTwo(lista, requireView().context)
                    binding.recycler.adapter=adaptadorDos
                    valor=1
                }else{

                    item.setIcon(R.drawable.ic_launcher_foreground)
                    binding.recycler.layoutManager=LinearLayoutManager(view?.context)
                    adaptador.ObjectAdapterRest(lista, requireView().context)
                    binding.recycler.adapter=adaptador
                    valor=0
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}