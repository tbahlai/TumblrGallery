package com.tbahlai.tumblrgallery.data.api.models

import com.google.gson.annotations.SerializedName

data class ApiPhotoItem(
//    @SerializedName("tags")
//    val tagsList: List<String> = emptyList()
    @SerializedName("original_size")
    val originalSize: ApiOriginalSize
)