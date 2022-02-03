package com.tbahlai.tumblrgallery.presentation.gallery

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tbahlai.tumblrgallery.R
import com.tbahlai.tumblrgallery.common.BaseActivity
import com.tbahlai.tumblrgallery.databinding.GalleryActivityBinding
import com.tbahlai.tumblrgallery.databinding.GalleryActivityBinding.bind
import com.tbahlai.tumblrgallery.uikit.recyclerview.MultiTypeAdapter
import android.content.Intent
import com.tbahlai.tumblrgallery.presentation.preview.PreviewPhotoActivity

class GalleryActivity : BaseActivity(R.layout.gallery_activity) {

    private val binding by viewBinding(GalleryActivityBinding::bind)
    private val viewModel by viewModels<GalleryViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setupSearchSubject()

        binding.onRefresh.setOnRefreshListener { viewModel.getImagesByTag() }

        val photosAdapter = MultiTypeAdapter(/* TODO() add diffUtilCallback */) {
            GalleryItemViewHolder(it, GalleryItemInteractorImpl())
        }
        binding.photos.adapter = photosAdapter
        binding.search.setOnQueryTextListener(QueryTextListener())

        viewModel.imagesLiveData.observe(this) {
            binding.onRefresh.isRefreshing = false
            photosAdapter.setItems(it)
        }

        viewModel.showProgressIndicatorLiveData.observe(this) {
            binding.progressIndicator.isVisible = it
        }

    }

    private inner class GalleryItemInteractorImpl() : GalleryItemViewHolder.Interactor {

        override fun onOpenPhotoDetailsWith(url: String) {
            val intent = Intent(this@GalleryActivity, PreviewPhotoActivity::class.java)
            intent.putExtra(PHOTO_URL, url)
            startActivity(intent)
        }

    }

    private inner class QueryTextListener: SearchView.OnQueryTextListener {

        override fun onQueryTextSubmit(query: String?): Boolean {
            viewModel.searchSubject.onNext(query!!)
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            if (!newText.isNullOrBlank()) viewModel.searchSubject.onNext(newText)
            return true
        }

    }

    companion object {
        const val PHOTO_URL = "com.tbahlai.tumblrgallery.presentation.gallery.PHOTO_URL"
    }

}