package com.tbahlai.tumblrgallery.domain

import com.tbahlai.tumblrgallery.data.api.models.ApiOriginalSize
import com.tbahlai.tumblrgallery.data.api.models.ApiPhotoItem
import com.tbahlai.tumblrgallery.data.api.models.ApiResponsePhotoData
import com.tbahlai.tumblrgallery.presentation.uimodels.UiPhotoData
import com.tbahlai.tumblrgallery.presentation.uimodels.UiPhotoItem
import com.tbahlai.tumblrgallery.presentation.uimodels.UiPhotoOriginalSize

fun ApiPhotoItem.toUiModel() : UiPhotoItem {
    return UiPhotoItem(originalSize.toUiModel())
}

fun ApiOriginalSize.toUiModel() : UiPhotoOriginalSize {
    return UiPhotoOriginalSize(url, width, height)
}

fun ApiResponsePhotoData.toUiModel(): UiPhotoData {
    return UiPhotoData(photos?.map { it.toUiModel() })
}