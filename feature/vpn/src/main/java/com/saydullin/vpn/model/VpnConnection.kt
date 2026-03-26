package com.saydullin.vpn.model

import com.saydullin.domain.error.ErrorReason

sealed class VpnConnection {

    object Loading: VpnConnection()

    class Success(
        val updatedAt: Long
    ): VpnConnection()

    class Error(
        val updatedAt: Long,
        val reason: ErrorReason,
    ): VpnConnection()

}


