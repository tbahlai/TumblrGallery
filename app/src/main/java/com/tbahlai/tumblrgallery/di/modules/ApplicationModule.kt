package com.tbahlai.tumblrgallery.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

}