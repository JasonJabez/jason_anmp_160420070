package com.example.jason_anmp_160420070.view

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.jason_anmp_160420070.R
import com.example.jason_anmp_160420070.databinding.FragmentLoginBinding
import com.example.jason_anmp_160420070.databinding.FragmentRegisterBinding
import com.example.jason_anmp_160420070.viewmodel.UserDetailViewModel


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
            var userDetailViewModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)

            if(binding.txtRegisterPassword.text.toString() == binding.txtRegisterPasswordRepeat.text.toString()){
                userDetailViewModel.registerUser(binding.txtRegisterFname.text.toString(), binding.txtRegisterLname.text.toString(), binding.txtRegisterUsername.text.toString()
                    , binding.txtRegisterEmail.text.toString(), binding.txtRegisterPassword.text.toString())

                Handler().postDelayed(Runnable{
                    if(userDetailViewModel.userLD.value != null){
                        val action = FragmentRegisterDirections.actionFragmentRegisterToFragmentLogin()
                        Navigation.findNavController(it).navigate(action)
                    }
                }, 200)
                Toast.makeText(binding.root.context, "Register success! Now please login.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(binding.root.context, "Passwords don't match.", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}