package com.tbahlai.tumblrgallery.di.modules

import androidx.lifecycle.ViewModel
import com.tbahlai.tumblrgallery.presentation.gallery.GalleryActivity
import com.tbahlai.tumblrgallery.common.di.ActivityScoped
import com.tbahlai.tumblrgallery.common.di.ViewModelKey
import com.tbahlai.tumblrgallery.presentation.gallery.GalleryViewModel
import com.tbahlai.tumblrgallery.presentation.preview.PreviewPhotoActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class GalleryModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun mainActivity(): GalleryActivity

    @Binds
    @IntoMap
    @ViewModelKey(GalleryViewModel::class)
    abstract fun mainViewModel(instance: GalleryViewModel): ViewModel

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun previewPhotoActivity(): PreviewPhotoActivity
}