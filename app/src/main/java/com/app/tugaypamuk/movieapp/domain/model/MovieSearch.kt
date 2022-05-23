package com.app.tugaypamuk.movieapp.domain.model

import com.google.gson.annotations.SerializedName

data class MovieSearch(
    /*
      * Api den gelen degisken isimler buyuk harfle basladigindan duzeltme yapmam gerekti.
     */
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    val year: String,
    val imdbID: String
)