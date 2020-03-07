package com.sorianog.memelist.network.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("data")
    var data: Data
)