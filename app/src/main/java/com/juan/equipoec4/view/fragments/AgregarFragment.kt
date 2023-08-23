package com.juan.equipoec4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juan.equipoec4.R
import com.juan.equipoec4.databinding.FragmentAgregarBinding


class AgregarFragment : Fragment() {
    private  lateinit var binding: FragmentAgregarBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(inflater,container,false)
        return binding.root
    }

}