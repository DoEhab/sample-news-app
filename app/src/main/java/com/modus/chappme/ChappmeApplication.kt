package com.modus.chappme

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.modus.chappme.cache.PreferencesManager
import javax.inject.Inject

class ChappmeApplication : Application() {
    @Inject
    lateinit var preferencesManager: PreferencesManager
    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }
    }
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }

    fun getComponent(): AppComponent = component
}