package com.modus.chappme.cache

import android.content.Context

const val TOKEN_PREFIX = "Bearer "

class PreferencesManager(context: Context) {

    private val sharedPreferencesName = "modus-Chappme-shared-preferences"
    private val loggedInKey = "LOGGED_IN_KEY"

    private var preferencesManager =
        context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)

    fun isLoggedIn(): Boolean = preferencesManager.getBoolean(loggedInKey, false)

    fun setLoggedIn(loggedIn: Boolean) {
        preferencesManager.edit().putBoolean(loggedInKey, loggedIn).apply()
    }

//    fun getAuthToken(): String = TOKEN_PREFIX + getUserInfo().token

    fun clear() {
        preferencesManager.edit().clear().apply()
    }

}