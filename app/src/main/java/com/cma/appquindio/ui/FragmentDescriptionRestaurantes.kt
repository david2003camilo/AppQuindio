package com.cma.appquindio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.cma.appquindio.R
import com.cma.appquindio.databinding.FragmentDescriptionRestaurantesBinding

class FragmentDescriptionRestaurantes : Fragment() {

    private var _binding:FragmentDescriptionRestaurantesBinding? = null
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentDescriptionRestaurantesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.removeItem(R.id.linear)
    }
}