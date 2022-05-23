package com.app.tugaypamuk.movieapp.peresention.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.tugaypamuk.movieapp.common.Resource
import com.app.tugaypamuk.movieapp.domain.model.MovieSearch
import com.app.tugaypamuk.movieapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel(){

    private var _movieList = MutableLiveData<List<MovieSearch>?>()
    var movieList = _movieList

    private var _error = MutableLiveData<String?>()
    var error = _error

    private var _isLoading = MutableLiveData<Boolean>()
    var isLoading = _isLoading


     fun getMovieList(movieTitle:String){
        viewModelScope.launch {
            repository.getMovieList(movieTitle).collect { result ->
                when(result){
                    is Resource.Success ->{
                        _isLoading.value = false
                        if (result.data != null){
                            _movieList.value = result.data
                            //_error.value = result.message
                        }
                    }
                    is Resource.Error ->{

                        _isLoading.value = false
                        _error.value = result.message
                    }
                    is Resource.Loading ->{
                        _isLoading.value = true
                    }
                }
            }
        }
    }
}