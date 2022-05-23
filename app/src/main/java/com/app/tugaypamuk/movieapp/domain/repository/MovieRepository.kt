package com.app.tugaypamuk.movieapp.domain.repository

import com.app.tugaypamuk.movieapp.common.Resource
import com.app.tugaypamuk.movieapp.domain.model.MovieDetail
import com.app.tugaypamuk.movieapp.domain.model.MovieSearch
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovieList(movieTitle:String) : Flow<Resource<List<MovieSearch>>>

    fun getMovieDetail(movieId : String) : Flow<Resource<MovieDetail>>

}