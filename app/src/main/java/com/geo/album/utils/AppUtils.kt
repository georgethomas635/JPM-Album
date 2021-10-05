package com.geo.album.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Created by George Thomas on 3/10/21
 */
object AppUtils {
    /**
     * Checking wifi or cellular connection is available for internet access.
     */
    fun isOnline(context: Context): Boolean {
        var online = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
            online = hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || hasTransport(
                NetworkCapabilities.TRANSPORT_WIFI
            ) || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        }
        return online
    }

    /**
     * Share the album titles using external applications.
     */
    fun shareWith(text: String, context: Context) {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = AppConstants.PLAIN_TEXT
        intent.putExtra(Intent.EXTRA_TEXT, text)
        context.startActivity(Intent.createChooser(intent, AppConstants.SHARE))
    }
}