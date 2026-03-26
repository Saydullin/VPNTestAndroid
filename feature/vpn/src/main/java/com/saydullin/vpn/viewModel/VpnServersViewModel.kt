package com.saydullin.vpn.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.devsgroup.servers.model.ServerInfo
import by.devsgroup.servers.repository.ServerRepository
import com.saydullin.domain.status.LoadingStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VpnServersViewModel @Inject constructor(
    private val serverRepository: ServerRepository
): ViewModel() {

    private val _serverInfo = MutableStateFlow<LoadingStatus<List<ServerInfo>>?>(null)
    val serverInfo: StateFlow<LoadingStatus<List<ServerInfo>>?> = _serverInfo

    fun getEuropeServers() {
        viewModelScope.launch {
            _serverInfo.value = LoadingStatus.Loading

            val europeServers = serverRepository.getEuropeServers()
                .onError {
                    _serverInfo.value = LoadingStatus.Error(it)
                } ?: return@launch

            _serverInfo.value = LoadingStatus.Success(europeServers)
        }
    }

}