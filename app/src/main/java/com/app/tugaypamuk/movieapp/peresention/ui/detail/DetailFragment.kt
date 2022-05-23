package com.app.tugaypamuk.movieapp.peresention.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.tugaypamuk.movieapp.R
import com.app.tugaypamuk.movieapp.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail){
    private lateinit var binding : FragmentDetailBinding
    private var fragmentBinding : FragmentDetailBinding? = null
    private val viewModel by viewModels<DetailViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        fragmentBinding = binding
        observeViewModels()
    }
    private fun observeViewModels(){
        arguments?.let {
            val id = DetailFragmentArgs.fromBundle(it).movieId
            Log.d("DetailFragment", "onViewCreated: $id" )
            viewModel.getMovieDetail(id)
            viewModel.movieDetail.observe(viewLifecycleOwner,{movieDetail ->
                binding.fragmentDetailProgressbar.isVisible = false
                binding.fragmentDetailCard.isVisible = true
                binding.items = movieDetail
            })
            viewModel.isLoading.observe(viewLifecycleOwner ,{state ->
                binding.fragmentDetailProgressbar.isVisible = state
                binding.fragmentDetailCard.isVisible = false

            })
        }
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }


}