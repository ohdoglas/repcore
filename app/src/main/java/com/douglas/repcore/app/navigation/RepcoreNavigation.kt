package com.douglas.repcore.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.douglas.repcore.feature.history.HistoryRoute
import com.douglas.repcore.feature.home.HomeRoute
import com.douglas.repcore.feature.program.ProgramRoute
import com.douglas.repcore.feature.settings.SettingsRoute
import kotlinx.serialization.Serializable

@Serializable
sealed interface RepcoreDestination : NavKey {
    val label: String

    @Serializable
    data object Home : RepcoreDestination {
        override val label: String = "Início"
    }

    @Serializable
    data object Program : RepcoreDestination {
        override val label: String = "Treinos"
    }

    @Serializable
    data object History : RepcoreDestination {
        override val label: String = "Histórico"
    }

    @Serializable
    data object Settings : RepcoreDestination {
        override val label: String = "Config."
    }
}

private val topLevelDestinations = listOf(
    RepcoreDestination.Home,
    RepcoreDestination.Program,
    RepcoreDestination.History,
    RepcoreDestination.Settings,
)

@Composable
fun RepcoreNavigation() {
    val backStack = remember { mutableStateListOf<NavKey>(RepcoreDestination.Home) }
    val currentDestination = backStack.lastOrNull() as? RepcoreDestination ?: RepcoreDestination.Home
    val onDestinationSelected by rememberUpdatedState { destination: RepcoreDestination ->
        if (currentDestination != destination) {
            backStack.clear()
            backStack.add(destination)
        }
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                topLevelDestinations.forEach { destination ->
                    NavigationBarItem(
                        selected = currentDestination == destination,
                        onClick = { onDestinationSelected(destination) },
                        icon = { Text(text = destination.label.first().toString()) },
                        label = { Text(text = destination.label) },
                    )
                }
            }
        },
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier.padding(innerPadding),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<RepcoreDestination.Home> {
                    HomeRoute(
                        onOpenProgram = { onDestinationSelected(RepcoreDestination.Program) },
                    )
                }

                entry<RepcoreDestination.Program> {
                    ProgramRoute()
                }

                entry<RepcoreDestination.History> {
                    HistoryRoute()
                }

                entry<RepcoreDestination.Settings> {
                    SettingsRoute()
                }
            },
        )
    }
}
