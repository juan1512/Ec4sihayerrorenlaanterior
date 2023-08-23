package com.juan.equipoec4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juan.equipoec4.RVListAdapter
import com.juan.equipoec4.databinding.FragmentListaBinding

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    private lateinit var viewModel: ListaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ListaViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVListAdapter(listOf()) {equipo->
            val equipoDetailDirection = ListaFragmentDirections.actionListaFragmentToDetallesFragment(equipo)
        findNavController().navigate(equipoDetailDirection)
        }
        binding.rvList.adapter =adapter
        binding.rvList.layoutManager = GridLayoutManager(requireContext(),2,
            RecyclerView.VERTICAL,false)
        viewModel.equipolist.observe(requireActivity()){
            adapter.equipos = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getEquipossFromService()
    }


}