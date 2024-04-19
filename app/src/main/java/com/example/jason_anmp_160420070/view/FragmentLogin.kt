package com.example.jason_anmp_160420070.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.jason_anmp_160420070.R
import com.example.jason_anmp_160420070.databinding.FragmentLoginBinding
import com.example.jason_anmp_160420070.viewmodel.UserDetailViewModel

class FragmentLogin : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnGoToRegister.setOnClickListener{
            val action = FragmentLoginDirections.actionFragmentLoginToFragmentRegister()
            Navigation.findNavController(it).navigate(action)
        }

        binding.btnLogin.setOnClickListener{
            var username = binding.txtLoginUsername.text.toString()
            var password = binding.txtLoginPassword.text.toString()

            var userDetailViewModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)
            userDetailViewModel.fetch(username, password)

            Handler().postDelayed(Runnable{
                if(userDetailViewModel.userLD.value != null){
                    val action = FragmentLoginDirections.actionFragmentLoginToFragmentLoginActionChooser(userDetailViewModel.userLD.value?.id!!)
                    Navigation.findNavController(it).navigate(action)
                }else{
                    Toast.makeText(binding.root.context, "Login tidak berhasil.", Toast.LENGTH_SHORT).show()
                }
            }, 200)
        }

        return binding.root
    }

}