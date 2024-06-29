package com.example.jason_anmp_160420070.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jason_anmp_160420070.databinding.FragmentNewsListBinding
import com.example.jason_anmp_160420070.viewmodel.NewsListViewModel

class FragmentNewsList : Fragment() {
    private lateinit var viewModel: NewsListViewModel
    private val adapterNewsList  = AdapterNewsList(arrayListOf())
    private lateinit var binding: FragmentNewsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsListBinding.inflate(inflater,container, false)

        return binding.root
    }

    fun observeViewModel() {
        viewModel.newsLD.observe(viewLifecycleOwner, Observer {
            adapterNewsList.updateNewsList(it)
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)

//        viewModel.nukeNews()
//        viewModel.addNews()
        viewModel.fetch()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = adapterNewsList

        observeViewModel()
    }
}