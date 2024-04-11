package com.example.jason_anmp_160420070.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.jason_anmp_160420070.databinding.FragmentStudentDetailBinding
import com.example.jason_anmp_160420070.viewmodel.DetailViewModel

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

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.fetch()
        val myStudent = detailViewModel.studentLD.value

        binding.txtId.setText(myStudent?.id.toString())
        binding.txtName.setText(myStudent?.name.toString())
        binding.txtBod.setText(myStudent?.dob.toString())
        binding.txtPhone.setText(myStudent?.phone.toString())

        return binding.root
    }

}