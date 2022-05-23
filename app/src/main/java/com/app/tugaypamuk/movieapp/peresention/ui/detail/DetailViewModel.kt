package com.app.tugaypamuk.movieapp.peresention.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.tugaypamuk.movieapp.common.Resource
import com.app.tugaypamuk.movieapp.domain.model.MovieDetail
import com.app.tugaypamuk.movieapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel(){

    private var _movieDetailData = MutableLiveData<MovieDetail?>()
    var movieDetail = _movieDetailData

    private var _error = MutableLiveData<String?>()
    var error = _error

    private var _isLoading = MutableLiveData<Boolean>()
    var isLoading = _isLoading

    fun getMovieDetail(movieId : String){
        viewModelScope.launch {
            repository.getMovieDetail(movieId).collect { result ->
                when(result){
                    is Resource.Success ->{
                        _isLoading.value = false
                        if (result.data != null){
                            _movieDetailData.value = result.data
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