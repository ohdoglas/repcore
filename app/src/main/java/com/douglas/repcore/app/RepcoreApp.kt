package com.douglas.repcore.app

import androidx.compose.runtime.Composable
import com.douglas.repcore.app.navigation.RepcoreNavigation
import com.douglas.repcore.ui.theme.RepcoreTheme

@Composable
fun RepcoreApp() {
    RepcoreTheme {
        RepcoreNavigation()
    }
}

