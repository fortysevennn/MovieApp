package com.app.tugaypamuk.movieapp.data.remote.retrofit

import com.app.tugaypamuk.movieapp.common.Constants.API_KEY
import com.app.tugaypamuk.movieapp.domain.model.Movie
import com.app.tugaypamuk.movieapp.domain.model.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    //https://www.omdbapi.com/?s={movieName}&apikey=106e722c

     @GET("/")
    suspend fun getMovieList(
        @Query("s") movieTitle : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : Movie

    @GET("/")
    suspend fun getMovieDetail(
        @Query("i") movieId : String,
        @Query("apikey") apiKey: String = API_KEY
    ) : MovieDetail





}