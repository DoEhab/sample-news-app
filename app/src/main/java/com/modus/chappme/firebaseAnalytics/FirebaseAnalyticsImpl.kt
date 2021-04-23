package com.modus.arbor_android.firebaseAnalytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseAnalyticsImpl : FirebaseAppAnalytics {

    override fun trackUserEvents(
        eventName: String,
        userName: String,
        firebaseAnalytics: FirebaseAnalytics
    ) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.METHOD, userName)
        firebaseAnalytics.logEvent(eventName, bundle)
    }

}