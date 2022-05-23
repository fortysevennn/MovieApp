package com.app.tugaypamuk.movieapp.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(

    /*
      * Api den gelen degisken isimler buyuk harfle basladigindan duzeltme yapmam gerekti.
     */
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<MovieSearch>,
    val totalResults: String
)