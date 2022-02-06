package com.example.jetbase.util

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

class NetworkLiveData(
  private val networkRequest: NetworkRequest,
  private val connectivityManager: ConnectivityManager,
) : LiveData<Boolean>() {

  private val networkCallback = object : ConnectivityManager.NetworkCallback() {
    override fun onAvailable(network: Network) {
      super.onAvailable(network)
      if (value != true)
        postValue(true)
    }

    override fun onLost(network: Network) {
      super.onLost(network)
      postValue(false)
    }

    override fun onUnavailable() {
      super.onUnavailable()
      postValue(false)
    }
  }

  fun isNetworkAvailable(): Boolean {
    val network = connectivityManager.activeNetwork
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
    return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
  }

  override fun onActive() {
    super.onActive()
    connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
  }

  override fun onInactive() {
    super.onInactive()
    connectivityManager.unregisterNetworkCallback(networkCallback)
  }
}
