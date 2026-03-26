package com.saydullin.vpn.ui.component.status

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saydullin.vpn.R
import com.saydullin.vpn.model.VpnConnection

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun VpnConnectionStatus(
    vpnConnection: VpnConnection?
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = vpnConnection,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(500)
                ) + slideInVertically(
                    initialOffsetY = { it / 2 },
                    animationSpec = tween(500)
                ) togetherWith fadeOut(
                    animationSpec = tween(500)
                ) + slideOutVertically(
                    targetOffsetY = { -it / 2 },
                    animationSpec = tween(500)
                )
            },
            label = "VpnStateAnimation"
        ) { connection ->
            when(connection) {
                is VpnConnection.Loading -> {
                    LoadingIndicator()
                }
                is VpnConnection.Success -> {
                    Text(
                        text = stringResource(R.string.connected),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                is VpnConnection.Error -> {
                    Text(
                        text = stringResource(R.string.connection_failed),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
                null -> {
                    Text(
                        text = stringResource(R.string.tap_to_connect),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }

    }

}