package com.sorianog.memelist.network.model

import com.google.gson.annotations.SerializedName
import java.net.URI

data class Meme (
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var imgUrl: String
)