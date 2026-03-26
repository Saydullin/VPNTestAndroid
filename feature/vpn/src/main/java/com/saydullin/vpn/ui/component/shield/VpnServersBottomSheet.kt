package com.saydullin.vpn.ui.component.shield

import androidx.compose.material3.BottomSheet
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VpnServersBottomSheet() {
    val sheetState = rememberModalBottomSheetState()

    BottomSheet(
        state = sheetState,
        onDismissRequest = {

        }
    ) {
        Text(
            text = "Server List"
        )
    }

}