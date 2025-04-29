package org.polihania.harrypotter.feature.start

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.mp.KoinPlatform.getKoin
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

@Composable
fun StartScreen(onClick: () -> Unit) {
    val rotationAngle by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(12000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val audioPlayer: AudioPlayer = getKoin().get()

    LaunchedEffect(Unit) {
        audioPlayer.playLooped("dj_theme")
    }

    DisposableEffect(Unit) {
        onDispose {
            audioPlayer.stop()
        }
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize().background(
            Brush.verticalGradient(
                colors = listOf(Color(0xFF0F0C29), Color(0xFF302B63), Color(0xFF24243e))
            )
        ),
        contentAlignment = Alignment.Center
    ) {
        DiscoCenter(onClick = onClick)

        RotatingElements(rotationAngle = rotationAngle)
    }
}

@Composable
fun DiscoCenter(onClick: () -> Unit) {
    val hue = remember { Animatable(0f) }

    // Запускаем бесконечную смену цвета
    LaunchedEffect(Unit) {
        while (true) {
            val nextHue = (0..360).random().toFloat()
            hue.animateTo(
                targetValue = nextHue,
                animationSpec = tween(durationMillis = 150, easing = LinearEasing)
            )
        }
    }

    val currentColor = Color.hsl(
        hue = hue.value,
        saturation = 1f,
        lightness = 0.5f
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(24.dp)
    ) {
        Text(
            "ПРЕПОД DJ Ебан",
            color = currentColor,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = currentColor,
                contentColor = Color.Black
            )
        ) {
            Text("ОтDJебанится")
        }
    }
}

@Composable
fun RotatingElements(
    rotationAngle: Float
) {
    val ringCount = 4
    val baseRadius = 120.dp
    val radiusStep = 60.dp

    val density = LocalDensity.current
    val switchStates = remember { mutableStateListOf<Boolean>() }
    val checkboxStates = remember { mutableStateListOf<Boolean>() }

    val elements = remember {
        buildList {
            repeat(ringCount) { ring ->
                val itemsInRing = 6 + ring * 4
                repeat(itemsInRing) { item ->
                    add(Pair(ring, item))
                    switchStates.add(true)
                    checkboxStates.add(true)
                }
            }
        }
    }

    Box(modifier = Modifier.graphicsLayer(rotationZ = rotationAngle)) {
        elements.forEachIndexed { index, (ring, itemIndexInRing) ->
            val radiusPx = with(density) { (baseRadius + radiusStep * ring).toPx() }
            val itemsInRing = 6 + ring * 4
            val angle = (360f / itemsInRing * itemIndexInRing) * (PI / 180)
            val x = radiusPx * cos(angle).toFloat()
            val y = radiusPx * sin(angle).toFloat()

            val hueOffset = rememberAnimatedHueFast(index).value
            val color = Color.hsl(
                hue = hueOffset % 360f,
                saturation = 0.8f,
                lightness = 0.5f
            )

            Box(
                modifier = Modifier
                    .offset { IntOffset(x.roundToInt(), y.roundToInt()) }
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                when (index % 4) {
                    0 -> Switch(
                        checked = switchStates[index],
                        onCheckedChange = { switchStates[index] = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = color,
                            uncheckedThumbColor = color.copy(alpha = 0.4f)
                        )
                    )

                    1 -> Checkbox(
                        checked = checkboxStates[index],
                        onCheckedChange = { checkboxStates[index] = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = color,
                            uncheckedColor = color.copy(alpha = 0.4f)
                        )
                    )

                    2 -> Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = color,
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(4.dp)
                    ) {
                        Text("🎵", fontSize = 12.sp)
                    }

                    3 -> Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = color
                    )
                }
            }
        }
    }
}

@Composable
fun rememberAnimatedHueFast(index: Int): State<Float> {
    val hue = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            val nextHue = (0..360).random().toFloat()
            hue.animateTo(
                targetValue = nextHue,
                animationSpec = tween(
                    durationMillis = 200 + (index % 5) * 30,
                    easing = LinearEasing
                )
            )
        }
    }

    return hue.asState()
}
