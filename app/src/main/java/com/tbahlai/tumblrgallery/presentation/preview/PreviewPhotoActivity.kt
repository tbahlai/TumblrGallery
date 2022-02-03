package com.tbahlai.tumblrgallery.presentation.preview

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tbahlai.tumblrgallery.R
import com.tbahlai.tumblrgallery.common.BaseActivity
import com.tbahlai.tumblrgallery.databinding.GalleryActivityBinding.bind
import com.tbahlai.tumblrgallery.databinding.PreviewPhotoActivityBinding
import com.tbahlai.tumblrgallery.presentation.gallery.GalleryActivity
import com.tbahlai.tumblrgallery.uikit.utils.loadFromUrl

class PreviewPhotoActivity : BaseActivity(R.layout.preview_photo_activity) {

    private val binding by viewBinding(PreviewPhotoActivityBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.extras

        val imageUrl = bundle!!.getString(GalleryActivity.PHOTO_URL)
        binding.photoView.loadFromUrl(url = imageUrl ?: "")
    }

}