package com.sorianog.memelist.network

import com.sorianog.memelist.network.model.ApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MemeAPI {
    @GET("/get_memes")
    fun getMemes(): Single<ApiResponse>
}