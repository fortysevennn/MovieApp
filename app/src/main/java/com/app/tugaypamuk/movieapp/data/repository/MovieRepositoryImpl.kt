package com.app.tugaypamuk.movieapp.data.repository

import com.app.tugaypamuk.movieapp.common.Resource
import com.app.tugaypamuk.movieapp.data.remote.retrofit.MovieApi
import com.app.tugaypamuk.movieapp.domain.model.MovieDetail
import com.app.tugaypamuk.movieapp.domain.model.MovieSearch
import com.app.tugaypamuk.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api : MovieApi
) : MovieRepository {
    override fun getMovieList(movieTitle:String): Flow<Resource<List<MovieSearch>>> = flow {

         emit(Resource.Loading())
        try {
            val remoteData = api.getMovieList(movieTitle).search
            emit(Resource.Success(remoteData))
        }
        catch (e : HttpException){
            emit(Resource.Error(
                message = "HTTP ERROR : $e",
            ))
        }
        catch (e:IOException){
            emit(Resource.Error(
                message = "internet connection error : $e",
            ))
        }


    }

    override fun getMovieDetail(movieId: String): Flow<Resource<MovieDetail>> = flow {
        emit(Resource.Loading())

        try {
            val movieDetail = api.getMovieDetail(movieId)
            emit(Resource.Success(movieDetail))
        }
        catch (e : HttpException){
            emit(Resource.Error(
                message = "HTTP ERROR : $e",
                ))
        }catch (e : IOException){
            emit(Resource.Error(
                message = "internet connection error : $e",
            ))
        }
    }


}