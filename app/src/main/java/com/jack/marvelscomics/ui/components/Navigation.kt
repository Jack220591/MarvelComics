package com.jack.marvelscomics.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.McNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {

    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = McNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = McNavigationDefaults.navigationContentColor(),
            selectedTextColor = McNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = McNavigationDefaults.navigationContentColor(),
            indicatorColor = McNavigationDefaults.navigationIndicatorColor()
        )
    )
}

@Composable
fun McNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = modifier,
        containerColor = McNavigationDefaults.NavigationContainerColor,
        contentColor = McNavigationDefaults.navigationContentColor(),
        tonalElevation = 0.dp,
        content = content
    )
}

@Composable
fun McNavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationRailItemDefaults.colors(
            selectedIconColor = McNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = McNavigationDefaults.navigationContentColor(),
            selectedTextColor = McNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = McNavigationDefaults.navigationContentColor(),
            indicatorColor = McNavigationDefaults.navigationIndicatorColor()
        )
    )
}

@Composable
fun McNavigationRail(
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    NavigationRail(
        modifier = modifier,
        containerColor = McNavigationDefaults.NavigationContainerColor,
        contentColor = McNavigationDefaults.navigationContentColor(),
        header = header,
        content = content
    )
}

/**
 * Now in Android navigation default values.
 */
object McNavigationDefaults {
    val NavigationContainerColor = Color.Transparent
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant
    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer
    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}
