package com.example.jason_anmp_160420070.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.jason_anmp_160420070.databinding.FragmentUserDetailBinding
import com.example.jason_anmp_160420070.viewmodel.UserDetailViewModel
import com.squareup.picasso.Picasso

class FragmentUserDetail : Fragment() {
    private lateinit var userDetailViewModel : UserDetailViewModel
    private lateinit var binding: FragmentUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)

        if(arguments != null){
            val userId = FragmentUserDetailArgs.fromBundle(requireArguments()).userId
            userDetailViewModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)
            userDetailViewModel.fetch(userId)

            //TO BE CHANGED
            Handler().postDelayed(Runnable{
                val myUser = userDetailViewModel.userLD.value
                binding.txtFirstName.setText(myUser?.firstName.toString())
                binding.txtLastName.setText(myUser?.lastName.toString())
                binding.txtPasswordDetails.setText(myUser?.password.toString())
            }, 500)
        }

        binding.btnLogout.setOnClickListener{
            val action = FragmentUserDetailDirections.actionFragmentUserDetailToFragmentLogin()
            Navigation.findNavController(it).navigate(action)
        }

        binding.btnUpdateUserDetails.setOnClickListener{
            val userId = FragmentUserDetailArgs.fromBundle(requireArguments()).userId
            val action = FragmentUserDetailDirections.actionFragmentUserDetailToFragmentLoginActionChooser(userId)
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }

}