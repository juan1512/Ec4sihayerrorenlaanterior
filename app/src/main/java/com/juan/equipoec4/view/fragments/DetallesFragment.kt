package com.juan.equipoec4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.juan.equipoec4.R
import com.juan.equipoec4.databinding.FragmentDetallesBinding
import com.juan.equipoec4.model.Equipo


class DetallesFragment : Fragment() {
    private lateinit var binding: FragmentDetallesBinding
    val args: DetallesFragmentArgs by navArgs()
    private  lateinit var  equipo : Equipo
    private lateinit var viewModel: DetallesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        equipo = args.equipo
        viewModel = ViewModelProvider(requireActivity()).get(DetallesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetallesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtGender.text = equipo.gender
        binding.txtName.text = equipo.name
        binding.txtShortCode.text = equipo.short_code
        binding.txtFounded.text = equipo.founded
        binding.txtType.text = equipo.type
        binding.txtPlaceholder.text = equipo.placeholder
        binding.txtLastPlayedAt.text = equipo.last_played_at
        Glide.with(binding.root)
            .load(equipo.image_path)
            .into(binding.imageView)
        binding.btnAddFavorite.setOnClickListener{
        viewModel.addFavorite(equipo)
        }
    }

}