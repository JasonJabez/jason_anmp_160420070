package com.example.jason_anmp_160420070.view

import android.os.Bundle
import android.os.Handler
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
import com.squareup.picasso.Picasso
import kotlin.math.ceil

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
        val newsPage = FragmentNewsDetailsArgs.fromBundle(requireArguments()).newsPage

        var newsDetailsViewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
        newsDetailsViewModel.fetch(newsId)

        Handler().postDelayed(Runnable {
            val newsData = newsDetailsViewModel.newsSingularLD.value

            var newsText_paged = ""
            if (newsData?.newsText?.length!! <= (newsPage - 1) * 1100 + 1101) {
                newsText_paged = newsData?.newsText!!.substring(
                    (newsPage - 1) * 1100 + 1,
                    newsData?.newsText?.length!!
                )
            } else if (newsPage > 1) {
                newsText_paged = newsData?.newsText!!.substring(
                    (newsPage - 1) * 1100 + 1,
                    (newsPage - 1) * 1100 + 1101
                )
            } else {
                newsText_paged = newsData?.newsText!!.substring(0, 1100)
            }

            Picasso.get().load(newsData?.newsPicDir).fit().centerCrop()
                .into(binding.imageViewNewsPicture)
            binding.textViewTitle.setText(newsData?.title)
            binding.textViewAuthor.setText("By: " + newsData?.author)
            binding.textViewNewsText.setText(newsText_paged)
            binding.textViewPage.setText(
                newsPage.toString() + " / " + ceil(newsData?.newsText?.length!!.toDouble() / 1100).toInt()
                    .toString()
            )

            if (newsPage == 1) {
                binding.btnBackNews.isEnabled = false
            }

            if (newsData?.newsText?.length!! <= (newsPage - 1) * 1100 + 1101) {
                binding.btnForwardNews.isEnabled = false
            }

            binding.btnBackList.setOnClickListener {
                val action =
                    FragmentNewsDetailsDirections.actionFragmentNewsDetailsToFragmentNewsList()
                Navigation.findNavController(it).navigate(action)
            }

            binding.btnBackNews.setOnClickListener {
                val action = FragmentNewsDetailsDirections.actionFragmentNewsDetailsSelf(
                    newsId,
                    newsPage - 1
                )
                Navigation.findNavController(it).navigate(action)
            }

            binding.btnForwardNews.setOnClickListener {
                val action = FragmentNewsDetailsDirections.actionFragmentNewsDetailsSelf(
                    newsId,
                    newsPage + 1
                )
                Navigation.findNavController(it).navigate(action)
            }
        }, 200)
        return binding.root
    }

}