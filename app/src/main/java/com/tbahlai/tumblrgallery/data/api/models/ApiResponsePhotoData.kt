package com.tbahlai.tumblrgallery.data.api.models

import com.google.gson.annotations.SerializedName

data class ApiResponsePhotoData(
    @SerializedName("photos")
    val photos: List<ApiPhotoItem>?
)