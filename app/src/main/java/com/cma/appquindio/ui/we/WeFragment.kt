package com.cma.appquindio.ui.we

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.cma.appquindio.R
import com.cma.appquindio.databinding.FragmentWeBinding

class WeFragment : Fragment() {

    private var _binding: FragmentWeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentWeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.removeItem(R.id.linear)
    }
}