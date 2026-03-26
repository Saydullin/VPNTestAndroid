package com.saydullin.vpn.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.vpn.model.VpnConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VpnConnectionViewModel @Inject constructor(
    // ...
): ViewModel() {

    private val _connectionStatus = MutableStateFlow<VpnConnection?>(null)
    val connectionStatus: StateFlow<VpnConnection?> = _connectionStatus

    private var connectJob: Job? = null

    fun connectFastest() {
        connectJob?.cancel()

        connectJob = viewModelScope.launch {
            _connectionStatus.value = VpnConnection.Loading

            delay(2000)

            _connectionStatus.value = VpnConnection.Success(System.currentTimeMillis())
        }
    }

    fun disconnectFastest() {
        connectJob?.cancel()

        _connectionStatus.value = null
    }

}