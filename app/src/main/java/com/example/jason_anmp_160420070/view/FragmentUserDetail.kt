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
import com.example.jason_anmp_160420070.databinding.FragmentUserDetailBinding
import com.example.jason_anmp_160420070.viewmodel.UserDetailViewModel

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
            userDetailViewModel.fetchByID(userId)

            //TO BE CHANGED
            Handler().postDelayed(Runnable{
                val myUser = userDetailViewModel.userLD.value
                binding.userNow = myUser
            }, 200)
        }

        binding.btnLogout.setOnClickListener{
            userDetailViewModel.userLD.value = null

            val action = FragmentUserDetailDirections.actionFragmentUserDetailToFragmentLogin()
            Navigation.findNavController(it).navigate(action)
        }

        binding.btnUpdateUserDetails.setOnClickListener{

            val userId = binding.userNow!!.id!!
            val firstName = binding.userNow!!.firstName!!
            val lastName = binding.userNow!!.lastName!!
            val password = binding.userNow!!.password!!

            val userDetailViewModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)
            userDetailViewModel.updateUser(firstName, lastName, password, userId)

            Handler().postDelayed(Runnable{
                val action = FragmentUserDetailDirections.actionFragmentUserDetailToFragmentLoginActionChooser(userId)
                Navigation.findNavController(it).navigate(action)
                Toast.makeText(binding.root.context, "Data updated successfully!", Toast.LENGTH_SHORT).show()
            }, 500)
        }

        return binding.root
    }

}