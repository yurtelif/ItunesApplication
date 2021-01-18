package com.yrtelf.itunesapplication.network

import com.squareup.picasso.Downloader
import com.yrtelf.itunesapplication.model.Result
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.http.POST
import java.util.*

interface ItunesApi {

    @POST("search")
    fun searchTracks(
        @Query("term") term: String?,
    ): Single<Response<ResultResponse>>


}