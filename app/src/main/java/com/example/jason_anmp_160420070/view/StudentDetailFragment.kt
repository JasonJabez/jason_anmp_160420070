package com.example.jason_anmp_160420070.view

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.jason_anmp_160420070.databinding.FragmentStudentDetailBinding
import com.example.jason_anmp_160420070.viewmodel.DetailViewModel
import java.util.Timer
import kotlin.concurrent.schedule

class StudentDetailFragment : Fragment() {
    private lateinit var detailViewModel : DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)

        if(arguments != null){
            val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
            binding.txtId.setText(studentId)
            detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            detailViewModel.fetch(studentId)

            //TO BE CHANGED
            Handler().postDelayed(Runnable{
                val myStudent = detailViewModel.studentLD.value
                binding.txtName.setText(myStudent?.name.toString())
                binding.txtBod.setText(myStudent?.dob.toString())
                binding.txtPhone.setText(myStudent?.phone.toString())
            }, 500)
        }

        return binding.root
    }

}