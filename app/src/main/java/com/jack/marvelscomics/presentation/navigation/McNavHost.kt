package com.jack.marvelscomics.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jack.marvelscomics.presentation.screens.comics.navigation.comicsGraph
import com.jack.marvelscomics.presentation.screens.characters.navigation.CharactersDestination
import com.jack.marvelscomics.presentation.screens.characters.navigation.charactersGraph

@Composable
fun McNavHost(
    navController: NavHostController,
    onNavigateToDestination: (NavigationDestination, String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = CharactersDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        charactersGraph()
        comicsGraph()
        /*bookmarksGraph()
        interestsGraph(
            navigateToTopic = {
                onNavigateToDestination(
                    TopicDestination, TopicDestination.createNavigationRoute(it)
                )
            },
            navigateToAuthor = {
                onNavigateToDestination(
                    AuthorDestination, AuthorDestination.createNavigationRoute(it)
                )
            },
            nestedGraphs = {
                topicGraph(onBackClick)
                authorGraph(onBackClick)
            }
        )*/
    }
}