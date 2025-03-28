package org.polihania.harrypotter.core.ui_kit.foundation

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// 🦁 Gryffindor
val GryffindorPrimary = Color(0xFF740001)
val GryffindorSecondary = Color(0xFFD3A625)
val GryffindorTertiary = Color(0xFFE8C547)
val GryffindorBackgroundLight = Color(0xFFFDF6E3)
val GryffindorSurfaceLight = Color(0xFFFFF8E1)
val GryffindorBackgroundDark = Color(0xFF2D1A14)
val GryffindorSurfaceDark = Color(0xFF5A3222)
val GryffindorOnBackgroundLight = Color(0xFF4A1A00)
val GryffindorOnSurfaceLight = Color(0xFF6B2F00)
val GryffindorOnBackgroundDark = Color(0xFFFFD8B0)
val GryffindorOnSurfaceDark = Color(0xFFE6A96B)

// 🐍 Slytherin
val SlytherinPrimary = Color(0xFF1A472A)
val SlytherinSecondary = Color(0xFF5D5D5D)
val SlytherinTertiary = Color(0xFF2A623D)
val SlytherinBackgroundLight = Color(0xFFD5E5D0)
val SlytherinSurfaceLight = Color(0xFFC4D5C0)
val SlytherinBackgroundDark = Color(0xFF121212)
val SlytherinSurfaceDark = Color(0xFF1E1E1E)
val SlytherinOnBackgroundLight = Color(0xFF102918)
val SlytherinOnSurfaceLight = Color(0xFF234B30)
val SlytherinOnBackgroundDark = Color(0xFFDCEAD5)
val SlytherinOnSurfaceDark = Color(0xFFAFC3A5)

// 🦅 Ravenclaw
val RavenclawPrimary = Color(0xFF0E1A40)
val RavenclawSecondary = Color(0xFF946B2D)
val RavenclawTertiary = Color(0xFFA67B5B)
val RavenclawBackgroundLight = Color(0xFFF5F5F5)
val RavenclawSurfaceLight = Color(0xFFE3E3E3)
val RavenclawBackgroundDark = Color(0xFF1A1A2E)
val RavenclawSurfaceDark = Color(0xFF2E2E4D)
val RavenclawOnBackgroundLight = Color(0xFF2B1D44)
val RavenclawOnSurfaceLight = Color(0xFF3D2F56)
val RavenclawOnBackgroundDark = Color(0xFFE0CBA3)
val RavenclawOnSurfaceDark = Color(0xFFC4A981)

// 🦡 Hufflepuff
val HufflepuffPrimary = Color(0xFFFFDB00)
val HufflepuffSecondary = Color(0xFF000000)
val HufflepuffTertiary = Color(0xFFFFC107)
val HufflepuffBackgroundLight = Color(0xFFFFF8DC)
val HufflepuffSurfaceLight = Color(0xFFFAE596)
val HufflepuffBackgroundDark = Color(0xFF2E2A1C)
val HufflepuffSurfaceDark = Color(0xFF594C2F)
val HufflepuffOnBackgroundLight = Color(0xFF3E2F00)
val HufflepuffOnSurfaceLight = Color(0xFF5A4300)
val HufflepuffOnBackgroundDark = Color(0xFFFCE8A8)
val HufflepuffOnSurfaceDark = Color(0xFFD6B56D)

val GryffindorLightColors = lightColorScheme(
    primary = GryffindorPrimary,
    onPrimary = Color.White,
    primaryContainer = GryffindorSecondary,
    onPrimaryContainer = Color.Black,
    inversePrimary = GryffindorTertiary,
    secondary = GryffindorSecondary,
    onSecondary = Color.Black,
    secondaryContainer = GryffindorTertiary,
    onSecondaryContainer = Color.Black,
    tertiary = GryffindorTertiary,
    onTertiary = Color.Black,
    tertiaryContainer = GryffindorSecondary,
    onTertiaryContainer = Color.Black,
    background = GryffindorBackgroundLight,
    onBackground = GryffindorOnBackgroundLight,
    surface = GryffindorSurfaceLight,
    onSurface = GryffindorOnSurfaceLight,
    surfaceVariant = GryffindorTertiary,
    onSurfaceVariant = GryffindorOnSurfaceLight,
    inverseSurface = GryffindorPrimary,
    inverseOnSurface = Color.White,
    error = Color.Red,
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD4),
    onErrorContainer = Color(0xFF410002),
    outline = GryffindorSecondary,
    outlineVariant = GryffindorTertiary,
    scrim = Color.Black
)

val GryffindorDarkColors = darkColorScheme(
    primary = GryffindorPrimary,
    onPrimary = Color.White,
    primaryContainer = GryffindorSecondary,
    onPrimaryContainer = Color.Black,
    inversePrimary = GryffindorTertiary,
    secondary = GryffindorSecondary,
    onSecondary = Color.White,
    secondaryContainer = GryffindorTertiary,
    onSecondaryContainer = Color.Black,
    tertiary = GryffindorTertiary,
    onTertiary = Color.White,
    tertiaryContainer = GryffindorSecondary,
    onTertiaryContainer = Color.Black,
    background = GryffindorBackgroundDark,
    onBackground = GryffindorOnBackgroundDark,
    surface = GryffindorSurfaceDark,
    onSurface = GryffindorOnSurfaceDark,
    surfaceVariant = GryffindorTertiary,
    onSurfaceVariant = GryffindorOnSurfaceDark,
    inverseSurface = GryffindorPrimary,
    inverseOnSurface = Color.Black,
    error = Color.Red,
    onError = Color.Black,
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD4),
    outline = GryffindorSecondary,
    outlineVariant = GryffindorTertiary,
    scrim = Color.Black
)

val SlytherinLightColors = lightColorScheme(
    primary = SlytherinPrimary,
    onPrimary = Color.White,
    primaryContainer = SlytherinSecondary,
    onPrimaryContainer = Color.Black,
    inversePrimary = SlytherinTertiary,
    secondary = SlytherinSecondary,
    onSecondary = Color.Black,
    secondaryContainer = SlytherinTertiary,
    onSecondaryContainer = Color.Black,
    tertiary = SlytherinTertiary,
    onTertiary = Color.Black,
    tertiaryContainer = SlytherinSecondary,
    onTertiaryContainer = Color.Black,
    background = SlytherinBackgroundLight,
    onBackground = SlytherinOnBackgroundLight,
    surface = SlytherinSurfaceLight,
    onSurface = SlytherinOnSurfaceLight,
    surfaceVariant = SlytherinTertiary,
    onSurfaceVariant = SlytherinOnSurfaceLight,
    inverseSurface = SlytherinPrimary,
    inverseOnSurface = Color.White,
    error = Color.Red,
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD4),
    onErrorContainer = Color(0xFF410002),
    outline = SlytherinSecondary,
    outlineVariant = SlytherinTertiary,
    scrim = Color.Black
)

val SlytherinDarkColors = darkColorScheme(
    primary = SlytherinPrimary,
    onPrimary = Color.White,
    primaryContainer = SlytherinSecondary,
    onPrimaryContainer = Color.Black,
    inversePrimary = SlytherinTertiary,
    secondary = SlytherinSecondary,
    onSecondary = Color.White,
    secondaryContainer = SlytherinTertiary,
    onSecondaryContainer = Color.Black,
    tertiary = SlytherinTertiary,
    onTertiary = Color.White,
    tertiaryContainer = SlytherinSecondary,
    onTertiaryContainer = Color.Black,
    background = SlytherinBackgroundDark,
    onBackground = SlytherinOnBackgroundDark,
    surface = SlytherinSurfaceDark,
    onSurface = SlytherinOnSurfaceDark,
    surfaceVariant = SlytherinTertiary,
    onSurfaceVariant = SlytherinOnSurfaceDark,
    inverseSurface = SlytherinPrimary,
    inverseOnSurface = Color.Black,
    error = Color.Red,
    onError = Color.Black,
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD4),
    outline = SlytherinSecondary,
    outlineVariant = SlytherinTertiary,
    scrim = Color.Black
)

val RavenclawLightColors = lightColorScheme(
    primary = RavenclawPrimary,
    onPrimary = Color.White,
    primaryContainer = RavenclawSecondary,
    onPrimaryContainer = Color.Black,
    inversePrimary = RavenclawTertiary,
    secondary = RavenclawSecondary,
    onSecondary = Color.Black,
    secondaryContainer = RavenclawTertiary,
    onSecondaryContainer = Color.Black,
    tertiary = RavenclawTertiary,
    onTertiary = Color.Black,
    tertiaryContainer = RavenclawSecondary,
    onTertiaryContainer = Color.Black,
    background = RavenclawBackgroundLight,
    onBackground = RavenclawOnBackgroundLight,
    surface = RavenclawSurfaceLight,
    onSurface = RavenclawOnSurfaceLight,
    surfaceVariant = RavenclawTertiary,
    onSurfaceVariant = RavenclawOnSurfaceLight,
    inverseSurface = RavenclawPrimary,
    inverseOnSurface = Color.White,
    error = Color.Red,
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD4),
    onErrorContainer = Color(0xFF410002),
    outline = RavenclawSecondary,
    outlineVariant = RavenclawTertiary,
    scrim = Color.Black
)

val RavenclawDarkColors = darkColorScheme(
    primary = RavenclawPrimary,
    onPrimary = Color.White,
    primaryContainer = RavenclawSecondary,
    onPrimaryContainer = Color.Black,
    inversePrimary = RavenclawTertiary,
    secondary = RavenclawSecondary,
    onSecondary = Color.White,
    secondaryContainer = RavenclawTertiary,
    onSecondaryContainer = Color.Black,
    tertiary = RavenclawTertiary,
    onTertiary = Color.White,
    tertiaryContainer = RavenclawSecondary,
    onTertiaryContainer = Color.Black,
    background = RavenclawBackgroundDark,
    onBackground = RavenclawOnBackgroundDark,
    surface = RavenclawSurfaceDark,
    onSurface = RavenclawOnSurfaceDark,
    surfaceVariant = RavenclawTertiary,
    onSurfaceVariant = RavenclawOnSurfaceDark,
    inverseSurface = RavenclawPrimary,
    inverseOnSurface = Color.Black,
    error = Color.Red,
    onError = Color.Black,
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD4),
    outline = RavenclawSecondary,
    outlineVariant = RavenclawTertiary,
    scrim = Color.Black
)

val HufflepuffLightColors = lightColorScheme(
    primary = HufflepuffPrimary,
    onPrimary = Color.Black,
    primaryContainer = HufflepuffSecondary,
    onPrimaryContainer = Color.White,
    inversePrimary = HufflepuffTertiary,
    secondary = HufflepuffSecondary,
    onSecondary = Color.White,
    secondaryContainer = HufflepuffTertiary,
    onSecondaryContainer = Color.Black,
    tertiary = HufflepuffTertiary,
    onTertiary = Color.Black,
    tertiaryContainer = HufflepuffSecondary,
    onTertiaryContainer = Color.Black,
    background = HufflepuffBackgroundLight,
    onBackground = HufflepuffOnBackgroundLight,
    surface = HufflepuffSurfaceLight,
    onSurface = HufflepuffOnSurfaceLight,
    surfaceVariant = HufflepuffTertiary,
    onSurfaceVariant = HufflepuffOnSurfaceLight,
    inverseSurface = HufflepuffPrimary,
    inverseOnSurface = Color.White,
    error = Color.Red,
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD4),
    onErrorContainer = Color(0xFF410002),
    outline = HufflepuffSecondary,
    outlineVariant = HufflepuffTertiary,
    scrim = Color.Black
)

val HufflepuffDarkColors = darkColorScheme(
    primary = HufflepuffPrimary,
    onPrimary = Color.Black,
    primaryContainer = HufflepuffSecondary,
    onPrimaryContainer = Color.White,
    inversePrimary = HufflepuffTertiary,
    secondary = HufflepuffSecondary,
    onSecondary = Color.White,
    secondaryContainer = HufflepuffTertiary,
    onSecondaryContainer = Color.Black,
    tertiary = HufflepuffTertiary,
    onTertiary = Color.White,
    tertiaryContainer = HufflepuffSecondary,
    onTertiaryContainer = Color.Black,
    background = HufflepuffBackgroundDark,
    onBackground = HufflepuffOnBackgroundDark,
    surface = HufflepuffSurfaceDark,
    onSurface = HufflepuffOnSurfaceDark,
    surfaceVariant = HufflepuffTertiary,
    onSurfaceVariant = HufflepuffOnSurfaceDark,
    inverseSurface = HufflepuffPrimary,
    inverseOnSurface = Color.Black,
    error = Color.Red,
    onError = Color.Black,
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD4),
    outline = HufflepuffSecondary,
    outlineVariant = HufflepuffTertiary,
    scrim = Color.Black
)
