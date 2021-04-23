package com.modus.chappme

import com.modus.chappme.ui.activity.MainActivity
import com.modus.chappme.ui.fragment.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(chappmeApplication: ChappmeApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
}