package com.juan.equipoec4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juan.equipoec4.R
import com.juan.equipoec4.RVListAdapter
import com.juan.equipoec4.databinding.FragmentFavoritoBinding


class FavoritoFragment : Fragment() {
    private lateinit var binding: FragmentFavoritoBinding
    private lateinit var viewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        viewModel = ViewModelProvider(requireActivity()).get(FavoriteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVListAdapter(listOf()) {equipo->
            val equipoDetailDirection = FavoritoFragmentDirections.actionFavoritoFragmentToDetallesFragment(equipo)
            findNavController().navigate(equipoDetailDirection)
        }
        binding.rvList.adapter =adapter
        binding.rvList.layoutManager = GridLayoutManager(requireContext(),2,
            RecyclerView.VERTICAL,false)
        viewModel.favorites.observe(requireActivity()){
            adapter.equipos = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getFavotires()
    }
}