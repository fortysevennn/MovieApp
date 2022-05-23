package com.app.tugaypamuk.movieapp.peresention.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.tugaypamuk.movieapp.R
import com.app.tugaypamuk.movieapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home),HomeAdapter.OnItemClickListener {
    private lateinit var binding : FragmentHomeBinding
    lateinit var homeAdapter: HomeAdapter
    private var fragmentBinding : FragmentHomeBinding? = null
    private val viewModel by viewModels<HomeViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        homeAdapter = HomeAdapter(this)
        fragmentBinding = binding
        observeViewModels()
        binding.fragmentHomeRecyclerView.adapter = homeAdapter
        binding.fragmentHomeRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.fragmentHomeEditText.addTextChangedListener(object  : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                viewModel.getMovieList(p0.toString())
                if (p0.toString().isEmpty()){
                    homeAdapter.list2 = emptyList()
                }
            }

        })


    }

    private fun observeViewModels(){
        viewModel.movieList.observe(viewLifecycleOwner,{movieList ->
            movieList?.let {
                    binding.fragmentHomeErrorTv.isVisible = false
                    homeAdapter.list2 = movieList
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner ,{state ->
            binding.fragmentHomeProgressBar.isVisible = state
            binding.fragmentHomeErrorTv.isVisible = false
        })
        viewModel.error.observe(viewLifecycleOwner,{error ->
            binding.fragmentHomeErrorTv.text = error
            binding.fragmentHomeErrorTv.isVisible = true
        })
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

    override fun onSearchItemClicked(movieId: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(movieId))
    }

}