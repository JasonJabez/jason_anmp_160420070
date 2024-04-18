package com.example.jason_anmp_160420070.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.jason_anmp_160420070.R
import com.example.jason_anmp_160420070.databinding.FragmentNewsDetailsBinding
import com.example.jason_anmp_160420070.viewmodel.NewsListViewModel
import com.example.jason_anmp_160420070.viewmodel.UserDetailViewModel

class FragmentNewsDetails : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        val newsId = FragmentNewsDetailsArgs.fromBundle(requireArguments()).newsId

        var newsDetailsViewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
        newsDetailsViewModel.fetch(newsId)

        val newsData = newsDetailsViewModel.newsSingularLD.value
        binding.textViewTitle.setText(newsData?.title)
        binding.textViewAuthor.setText("By: " + newsData?.author)
        binding.textViewNewsText.setText(newsData?.newsText)

        return binding.root
    }

}