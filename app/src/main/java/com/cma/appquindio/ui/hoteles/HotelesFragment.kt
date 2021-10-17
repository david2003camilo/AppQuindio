package com.cma.appquindio.ui.hoteles

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cma.appquindio.R
import com.cma.appquindio.adapter.hoteles.ObjectAdapter
import com.cma.appquindio.adapter.hoteles.ObjectAdapterTwo
import com.cma.appquindio.databinding.FragmentHotelesBinding
import com.cma.appquindio.vo.ObjectVo

class HotelesFragment : Fragment() {
    var lista  = ArrayList<ObjectVo>()
    private var _binding: FragmentHotelesBinding? = null
    private val binding get() = _binding!!
    private var adaptador: ObjectAdapter = ObjectAdapter()
    var valor = 0
    private var adaptadorTwo: ObjectAdapterTwo = ObjectAdapterTwo()

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
        _binding= FragmentHotelesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager=LinearLayoutManager(view.context)
        adaptador.ObjectAdapter(lista, view.context)
        binding.recycler.adapter=adaptador
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.linear->{
                if(valor == 0){
                    item.setIcon(R.drawable.ic_menu_camera)
                    binding.recycler.layoutManager=GridLayoutManager(view?.context, 2)
                    adaptadorTwo.ObjectAdapterTwo(lista, requireView().context)
                    binding.recycler.adapter=adaptadorTwo
                    valor=1
                }else{
                    item.setIcon(R.drawable.ic_launcher_foreground)
                    binding.recycler.layoutManager=LinearLayoutManager(view?.context)
                    adaptador.ObjectAdapter(lista, requireView().context)
                    binding.recycler.adapter=adaptador
                    valor=0
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun initData(){
        val sitio1 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        val sitio2 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        val sitio3 = ObjectVo(1,"ENSAYO","ESTA ES UNA PRUEBA","EN QUINIDON","hola","S")
        lista.add(sitio1)
        lista.add(sitio2)
        lista.add(sitio3)
    }
}