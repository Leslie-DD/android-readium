package org.readium.r2.testapp.bookshelf.detail.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColorScheme(

    surface = Color(0xFFe4e2ed),

    primary = Color(0xFFf0eff6),
    onPrimary = Color(0xFF000000),
    secondary = Color(0xFFe4e2ed),
    onSecondary = Color(0xFF272727),
    tertiary = Color(0xFFEFF5E6),

    background = Color(0xFFf1f0f5),
    onBackground = Color.Black

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val DarkColorPalette = darkColorScheme(

    surface = Color(0xFF000000),

    primary = Color(0xFF1f1f1f),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF292929),
    onSecondary = Color(0xFFDBDBDB),
    tertiary = Color(0xFF003D37),

    background = Color.Black,
    onBackground = Color.White

)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}