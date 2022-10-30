package com.jack.marvelscomics.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.core.os.trace
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jack.marvelscomics.R
import com.jack.marvelscomics.presentation.navigation.NavigationDestination
import com.jack.marvelscomics.presentation.navigation.TopLevelDestination
import com.jack.marvelscomics.presentation.screens.comics.navigation.ComicsDestination
import com.jack.marvelscomics.presentation.screens.characters.navigation.CharactersDestination
import com.jack.marvelscomics.ui.theme.Icon
import com.jack.marvelscomics.ui.theme.Icons

@Composable
fun rememberMcAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController()
): McAppState {
    NavigationTrackingSideEffect(navController)
    return remember(navController, windowSizeClass) {
        McAppState(navController, windowSizeClass)
    }
}

@Stable
class McAppState(
    val navController: NavHostController,
    val windowSizeClass: WindowSizeClass
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact ||
                windowSizeClass.heightSizeClass == WindowHeightSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    /**
     * Top level destinations to be used in the BottomBar and NavRail
     */
    val topLevelDestinations: List<TopLevelDestination> = listOf(
        TopLevelDestination(
            route = CharactersDestination.route,
            destination = CharactersDestination.destination,
            selectedIcon = Icon.ImageVectorIcon(Icons.Face),
            unselectedIcon = Icon.ImageVectorIcon(Icons.Face),
            iconTextId = R.string.characters_bottom_navigation_title
        ),
        TopLevelDestination(
            route = ComicsDestination.route,
            destination = ComicsDestination.destination,
            selectedIcon = Icon.ImageVectorIcon(Icons.Star),
            unselectedIcon = Icon.ImageVectorIcon(Icons.Star),
            iconTextId = R.string.comics_bottom_navigation_title
        ),
        /*TopLevelDestination(
            route = InterestsDestination.route,
            destination = InterestsDestination.destination,
            selectedIcon = ImageVectorIcon(NiaIcons.Grid3x3),
            unselectedIcon = ImageVectorIcon(NiaIcons.Grid3x3),
            iconTextId = interestsR.string.interests
        )*/
    )

    fun navigate(destination: NavigationDestination, route: String? = null) {
        trace("Navigation: $destination") {
            if (destination is TopLevelDestination) {
                navController.navigate(route ?: destination.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            } else {
                navController.navigate(route ?: destination.route)
            }
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}

@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    JankMetricDisposableEffect(navController) { metricsHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricsHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}
