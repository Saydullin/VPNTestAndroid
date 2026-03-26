package com.saydullin.vpntestandroid.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90C2FF),
    onPrimary = Color(0xFF01347A),

    primaryContainer = Color(0xFF0059C4),
    onPrimaryContainer = Color(0xFFD0E4FF),

    secondary = Color(0xFF6FDCA3),
    onSecondary = Color(0xFF00391A),

    secondaryContainer = Color(0xFF00522B),
    onSecondaryContainer = Color(0xFFC8E6D8),

    tertiary = Color(0xFFFFD54F),
    onTertiary = Color(0xFF402600),

    tertiaryContainer = Color(0xFF5C4000),
    onTertiaryContainer = Color(0xFFFFF3CD),

    background = Color(0xFF121212),
    onBackground = Color(0xFFE3E3E3),

    surface = Color(0xFF1C1B1F),
    onSurface = Color(0xFFD7D7D7),
    surfaceVariant = Color(0xFF4A454E),
    onSurfaceVariant = Color(0xFFCAC4D0),

    surfaceTint = Color(0xFF90C2FF),

    inverseSurface = Color(0xFFE3E3E3),
    inverseOnSurface = Color(0xFF1C1B1F),

    outline = Color(0xFF959696),

    error = Color(0xFFBE6D68),
    onError = Color(0xFF601410),
    errorContainer = Color(0xFF8C1D18),
    onErrorContainer = Color(0xFFF9DEDC),

    surfaceBright = Color(0xFF2C2B30),
    surfaceContainerLow = Color(0xFF36353B),
    surfaceContainer = Color(0xFF202124),
    surfaceContainerHigh = Color(0xFF232324),
    surfaceContainerHighest = Color(0xFF1F1F21),
    surfaceDim = Color(0xFF16161A),

    primaryFixed = Color(0xFF90C2FF),
    primaryFixedDim = Color(0xFF609BDB),
    onPrimaryFixed = Color(0xFF001D5A),
    onPrimaryFixedVariant = Color(0xFFD0E4FF),

    secondaryFixed = Color(0xFF6FDCA3),
    secondaryFixedDim = Color(0xFF45B57E),
    onSecondaryFixed = Color(0xFF00391A),
    onSecondaryFixedVariant = Color(0xFFC8E6D8),

    tertiaryFixed = Color(0xFFFFD54F),
    tertiaryFixedDim = Color(0xFFFFB300),
    onTertiaryFixed = Color(0xFF402600),
    onTertiaryFixedVariant = Color(0xFFFFF3CD),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4B46E0),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD0E4FF),
    onPrimaryContainer = Color(0xFF021C41),

    secondary = Color(0xFF27AE60),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFC8E6D8),
    onSecondaryContainer = Color(0xFF054D25),

    tertiary = Color(0xFFFFC107),
    onTertiary = Color.Black,
    tertiaryContainer = Color(0xFFFFF3CD),
    onTertiaryContainer = Color(0xFF663C00),

    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF1A1C1E),
    surface = Color(0xFFF5F6F9),
    onSurface = Color(0xFF1A1C1E),
    surfaceVariant = Color(0xFFE1DEE5),
    onSurfaceVariant = Color(0xFF49454E),
    inverseSurface = Color(0xFF3B3B3D),
    inverseOnSurface = Color(0xFFF3EFF4),
    outline = Color(0xFFBBB8BB),

    error = Color(0xFFB3261E),
    onError = Color.White,
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = Color(0xFF410E0B),

    surfaceTint = Color(0xFF2F80ED),

    surfaceBright = Color(0xFFF5F6F7),
    surfaceContainerLow = Color(0xFFF7F8F9),
    surfaceContainer = Color(0xFFF2F3F4),
    surfaceContainerHigh = Color(0xFFEEEFF1),
    surfaceContainerHighest = Color(0xFFE9EBEE),
    surfaceDim = Color(0xFFD8DCDE),

    primaryFixed = Color(0xFF2F80ED),
    primaryFixedDim = Color(0xFF256FC8),
    onPrimaryFixed = Color.White,
    onPrimaryFixedVariant = Color(0xFFE3EFFE),

    secondaryFixed = Color(0xFF27AE60),
    secondaryFixedDim = Color(0xFF219856),
    onSecondaryFixed = Color.White,
    onSecondaryFixedVariant = Color(0xFFDFF5E9),

    tertiaryFixed = Color(0xFFFFC107),
    tertiaryFixedDim = Color(0xFFE0A800),
    onTertiaryFixed = Color.Black,
    onTertiaryFixedVariant = Color(0xFFFFF8E1)
)

@Composable
fun VPNTestAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(6.dp),
        large = RoundedCornerShape(16.dp),
    )

    MaterialTheme(
        motionScheme = MotionScheme.expressive(),
        colorScheme = colorScheme,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}




@Composable
fun VPNTestAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        motionScheme = MotionScheme.expressive(),
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}