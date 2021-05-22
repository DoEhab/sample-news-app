package com.modus.arbor_android.firebaseAnalytics

import com.google.firebase.analytics.FirebaseAnalytics

interface FirebaseAppAnalytics {
    fun trackUserEvents(
        eventName: String,
        userName: String,
        firebaseAnalytics: FirebaseAnalytics
    )
}