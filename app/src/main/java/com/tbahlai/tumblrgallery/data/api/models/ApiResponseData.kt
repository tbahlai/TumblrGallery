package com.tbahlai.tumblrgallery.data.api.models

import com.google.gson.annotations.SerializedName

data class ApiResponseData(
    @SerializedName("response")
    val response: List<ApiResponsePhotoData>
)