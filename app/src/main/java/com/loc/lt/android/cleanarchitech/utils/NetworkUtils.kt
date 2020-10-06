package com.loc.lt.android.cleanarchitech.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NetworkHelper @Inject constructor(@ApplicationContext private val context: Context) {

    fun netWorkConnection(): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val activeNetwork =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }

                }
            }
        }

        return result
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}


data class DataResult<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): DataResult<T> {
            return DataResult(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): DataResult<T> {
            return DataResult(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): DataResult<T> {
            return DataResult(Status.LOADING, data, null)
        }

    }

}

