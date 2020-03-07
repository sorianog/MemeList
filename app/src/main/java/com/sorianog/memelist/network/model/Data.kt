package com.sorianog.memelist.network.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("memes")
    var memes: List<Meme>
)