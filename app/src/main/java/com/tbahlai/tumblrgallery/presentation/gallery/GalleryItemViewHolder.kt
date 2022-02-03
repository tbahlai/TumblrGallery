package com.tbahlai.tumblrgallery.presentation.gallery

import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tbahlai.tumblrgallery.R
import com.tbahlai.tumblrgallery.databinding.GalleryItemViewBinding
import com.tbahlai.tumblrgallery.presentation.uimodels.UiPhotoOriginalSize
import com.tbahlai.tumblrgallery.uikit.recyclerview.BaseHolder
import com.tbahlai.tumblrgallery.uikit.utils.loadFromUrl

class GalleryItemViewHolder constructor(
    itemView: ViewGroup,
    private val interactor: Interactor
) : BaseHolder<UiPhotoOriginalSize>(R.layout.gallery_item_view, itemView) {

    private val binding by viewBinding(GalleryItemViewBinding::bind)

    override fun bind(item: UiPhotoOriginalSize) {
        binding.photoView.loadFromUrl(item.url)
        binding.root.setOnClickListener {
            interactor.onOpenPhotoDetailsWith(item.url)
        }
    }

    interface Interactor {

        fun onOpenPhotoDetailsWith(url: String)

    }

}