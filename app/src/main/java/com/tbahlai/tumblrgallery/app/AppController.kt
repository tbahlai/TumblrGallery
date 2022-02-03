package com.tbahlai.tumblrgallery.app

import android.app.Application
import com.tbahlai.tumblrgallery.di.AppComponent
import com.tbahlai.tumblrgallery.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AppController : Application(), HasAndroidInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>
        internal set

    private lateinit var appComponent: AppComponent

    companion object {
        val appComponent: AppComponent
            get() = appController.appComponent

        private lateinit var appController: AppController
    }

    override fun onCreate() {
        super.onCreate()

        appController = this

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        appComponent.inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return injector
    }
}