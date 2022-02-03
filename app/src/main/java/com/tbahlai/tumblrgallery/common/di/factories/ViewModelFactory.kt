package com.tbahlai.tumblrgallery.common.di.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator: Provider<out ViewModel>? = creators[modelClass] ?: let {
            creators.entries.find { modelClass.isAssignableFrom(it.key) }?.value
        }

        requireNotNull(creator) { "unknown model class $modelClass" }

        return creator.get() as T
    }


}