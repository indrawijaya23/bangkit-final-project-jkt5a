package com.google.firebase.ml.md.kotlin

import android.util.Log

object Logger {

    private const val TAG = "RiceLeafDiseases"

    @JvmStatic
    fun v(log: String) {
        Log.v(TAG, log)
    }

    @JvmStatic
    fun d(log: String) {
        Log.d(TAG, log)
    }

    @JvmStatic
    fun e(log: String) {
        Log.e(TAG, log)
    }
}