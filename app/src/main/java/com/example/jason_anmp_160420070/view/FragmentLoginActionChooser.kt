package com.example.jason_anmp_160420070.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.jason_anmp_160420070.R
import com.example.jason_anmp_160420070.databinding.FragmentLoginActionChooserBinding
import com.example.jason_anmp_160420070.databinding.FragmentLoginBinding

class FragmentLoginActionChooser : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginActionChooserBinding.inflate(inflater, container, false)
        val userId = FragmentLoginActionChooserArgs.fromBundle(requireArguments()).userId

        binding.btnUserDetails.setOnClickListener{
            val action = FragmentLoginActionChooserDirections.actionFragmentLoginActionChooserToFragmentUserDetail(userId)
            Navigation.findNavController(it).navigate(action)
        }

        binding.btnSeeNews.setOnClickListener{
            val action = FragmentLoginActionChooserDirections.actionFragmentLoginActionChooserToFragmentNewsList()
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }

}