package com.saydullin.vpn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.saydullin.vpn.R
import com.saydullin.vpn.model.VpnConnection
import com.saydullin.vpn.ui.component.button.VpnConnectionButton
import com.saydullin.vpn.ui.component.status.VpnConnectionStatus
import com.saydullin.vpn.viewModel.VpnConnectionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VpnConnectScreen() {
    val vpnConnectionViewModel: VpnConnectionViewModel = hiltViewModel()
    val connectionStatus = vpnConnectionViewModel.connectionStatus.collectAsStateWithLifecycle()

    val sheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetPeekHeight = 100.dp,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Server List", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Server 1")
                Text("Server 2")
                Text("Server 3")
            }
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Image(
                    modifier = Modifier
                        .alpha(0.2f)
                        .fillMaxSize(),
                    painter = painterResource(R.drawable.im_map),
                    contentDescription = "Map",
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    VpnConnectionStatus(connectionStatus.value)

                    Spacer(Modifier.height(32.dp))

                    if (connectionStatus.value is VpnConnection.Success) {
                        VpnConnectionButton(
                            text = "Disconnect",
                            isLoading = connectionStatus.value == VpnConnection.Loading,
                            isError = true,
                            onClick = {
                                vpnConnectionViewModel.disconnectFastest()
                            }
                        )
                    } else {
                        VpnConnectionButton(
                            text = "Connect",
                            isLoading = connectionStatus.value == VpnConnection.Loading,
                            isError = connectionStatus.value is VpnConnection.Error,
                            onClick = {
                                vpnConnectionViewModel.connectFastest()
                            }
                        )
                    }

                    Spacer(Modifier.height(32.dp))
                }
            }
        }
    )
}


