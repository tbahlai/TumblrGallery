package com.tbahlai.tumblrgallery.data.api.models

import com.google.gson.annotations.SerializedName

data class ApiOriginalSize(
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int
)