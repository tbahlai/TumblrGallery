package com.tbahlai.tumblrgallery.di

import android.app.Application
import com.tbahlai.tumblrgallery.app.AppController
import com.tbahlai.tumblrgallery.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ApiModule::class,
        ApiServicesModule::class,
        GalleryModule::class,
        ViewModelsModule::class,
    ]
)
interface AppComponent : AndroidInjector<AppController> {

    override fun inject(instance: AppController)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}