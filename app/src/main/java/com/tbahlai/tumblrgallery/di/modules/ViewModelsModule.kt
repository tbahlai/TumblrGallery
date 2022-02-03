package com.tbahlai.tumblrgallery.di.modules

import androidx.lifecycle.ViewModelProvider
import com.tbahlai.tumblrgallery.common.di.factories.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [GalleryModule::class])
abstract class ViewModelsModule {

    @Binds
    abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}