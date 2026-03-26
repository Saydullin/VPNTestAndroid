package com.saydullin.vpntestandroid.nav

sealed class ScreenNav(
    val route: String
) {

    data object VpnScreen: ScreenNav(route = "splashScreen")

}


