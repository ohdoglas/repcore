package com.douglas.repcore.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = RepcoreGreen,
    onPrimary = RepcoreMist,
    background = RepcoreInk,
    surface = RepcoreInk,
    onBackground = RepcoreMist,
    onSurface = RepcoreMist,
)

private val LightColorScheme = lightColorScheme(
    primary = RepcoreGreen,
    onPrimary = RepcoreMist,
    background = RepcoreMist,
    surface = RepcoreMist,
    onBackground = RepcoreInk,
    onSurface = RepcoreInk,
)

@Composable
fun RepcoreTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        content = content,
    )
}
