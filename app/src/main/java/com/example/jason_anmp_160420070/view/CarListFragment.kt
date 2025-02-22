package com.example.jason_anmp_160420070.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jason_anmp_160420070.databinding.FragmentCarListBinding
import com.example.jason_anmp_160420070.viewmodel.CarViewModel

class CarListFragment : Fragment() {
    private lateinit var viewModel: CarViewModel
    private val carListAdapter  = CarListAdapter(arrayListOf())
    private lateinit var binding: FragmentCarListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCarListBinding.inflate(inflater,container, false)
        return binding.root
    }

    fun observeViewModel() {
        viewModel.carsLD.observe(viewLifecycleOwner, Observer {
            carListAdapter.updateCarsList(it)
        })

        viewModel.carLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.txtError?.visibility = View.VISIBLE
            } else {
                binding.txtError?.visibility = View.GONE
            }
        })

        viewModel.carloadLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = carListAdapter

        observeViewModel()
    }
}