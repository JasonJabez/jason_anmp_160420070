package com.example.jason_anmp_160420070.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.jason_anmp_160420070.R
import com.example.jason_anmp_160420070.databinding.FragmentLoginBinding
import com.example.jason_anmp_160420070.databinding.FragmentRegisterBinding


class FragmentRegister : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding.btnRegister.setOnClickListener{
            val action = FragmentRegisterDirections.actionFragmentRegisterToFragmentLogin()
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }

}