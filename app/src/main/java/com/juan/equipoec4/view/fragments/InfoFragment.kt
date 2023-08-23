package com.juan.equipoec4.view.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.juan.equipoec4.R
import com.juan.equipoec4.databinding.FragmentInfoBinding
import com.juan.equipoec4.view.LoginActivity
import com.juan.equipoec4.view.SplashActivity


class InfoFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: FragmentInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences(
            LoginActivity.SESSION_PREFERENCE,
            AppCompatActivity.MODE_PRIVATE
        )
        firebaseAuth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCloseSession.setOnClickListener{
            firebaseAuth.signOut()
            sharedPreferences.edit().apply(){
                putString(LoginActivity.EMAIL,"")
                    .apply()
            }
            val intent = Intent(requireActivity(),SplashActivity::class.java)
            requireActivity().startActivity(intent)
            requireActivity().finish()
        }
    }
}