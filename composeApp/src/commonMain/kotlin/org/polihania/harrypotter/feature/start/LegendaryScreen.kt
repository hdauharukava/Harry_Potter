package org.polihania.harrypotter.feature.start

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import org.koin.mp.KoinPlatform.getKoin
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun LegendaryScreen(config: LegendaryScreenConfig = LegendaryScreenConfig()) {
    val audioPlayer: AudioPlayer = getKoin().get()
    val pulseEvents = remember { MutableSharedFlow<Unit>() }
    val coroutineScope = rememberCoroutineScope()

    // 🔥 Shake state
    val shakeOffsetX = remember { Animatable(0f) }
    val shakeOffsetY = remember { Animatable(0f) }

    // ✨ Flash overlay state
    var flashAlpha by remember { mutableStateOf(0f) }
    val animatedFlashAlpha by animateFloatAsState(
        targetValue = flashAlpha,
        animationSpec = tween(200),
        label = "FlashAlpha"
    )

    // 🎵 Music
    LaunchedEffect(Unit) {
        if (config.enableMusic) {
            audioPlayer.playLooped("dj_theme")
        }
    }

    DisposableEffect(Unit) {
        onDispose { audioPlayer.stop() }
    }

    // 💥 Click ray angles (8 лучей)
    val rayAngles = remember { mutableStateListOf<Float>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .offset { IntOffset(shakeOffsetX.value.roundToInt(), shakeOffsetY.value.roundToInt()) }
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F0C29),
                        Color(0xFF302B63),
                        Color(0xFF24243e)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // ⚡ Smooth flash overlay
        if (config.enableFlashOverlay && animatedFlashAlpha > 0f) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White.copy(alpha = animatedFlashAlpha))
            )
        }

        // ☄️ Click rays
        rayAngles.forEach { angle ->
            Ray(angle = angle)
        }

        // 💡 Center
        DiscoCenter(
            onClick = {
                coroutineScope.launch {
                    if (config.enablePulseAnimation) pulseEvents.emit(Unit)

                    if (config.enableFlashOverlay) {
                        flashAlpha = 1f
                        delay(100)
                        flashAlpha = 0f
                    }

                    if (config.enableShakeOnClick) {
                        launch {
                            repeat(6) {
                                shakeOffsetX.snapTo((-10..10).random().toFloat())
                                shakeOffsetY.snapTo((-10..10).random().toFloat())
                                delay(10)
                            }
                            shakeOffsetX.snapTo(0f)
                            shakeOffsetY.snapTo(0f)
                        }
                    }

                    if (config.enableClickRays) {
                        rayAngles.clear()
                        rayAngles.addAll(List(8) { it * 45f })
                        delay(300)
                        rayAngles.clear()
                    }
                }
            },
            showColorAnimation = config.enableHueDiscoCenter,
            showText = config.enableCenterText,
            enableIdleBreathing = config.enableIdleBreathing
        )

        // 🔄 Rotating elements
        if (config.showRotatingElements) {
            RotatingElements(
                rotationAngle = rememberInfiniteRotation(),
                pulseFlow = pulseEvents,
                enablePulse = config.enablePulseAnimation,
                animateHue = config.animateHueInElements,
                toggleStates = config.toggleElementStates,
                enableGlitch = config.enableGlitchEffect,
                glitchAlpha = config.glitchAlphaEnabled,
                morphElements = config.enableMorphingElements
            )
        }
    }
}


@Composable
fun DiscoCenter(
    onClick: () -> Unit,
    showColorAnimation: Boolean,
    showText: Boolean,
    enableIdleBreathing: Boolean
) {
    val hue = remember { Animatable(0f) }
    val scale = remember { Animatable(1f) }

    // 🎨 Цвет анимации
    LaunchedEffect(showColorAnimation) {
        if (showColorAnimation) {
            while (true) {
                val nextHue = (0..360).random().toFloat()
                hue.animateTo(
                    targetValue = nextHue,
                    animationSpec = tween(150, easing = LinearEasing)
                )
            }
        }
    }

    // 🫁 Idle breathing
    LaunchedEffect(enableIdleBreathing) {
        if (enableIdleBreathing) {
            while (true) {
                scale.animateTo(1.05f, tween(1200))
                scale.animateTo(1f, tween(1200))
            }
        }
    }

    val currentColor = if (showColorAnimation)
        Color.hsl(hue.value, 1f, 0.5f)
    else Color.Cyan

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(24.dp)
            .graphicsLayer(scaleX = scale.value, scaleY = scale.value)
    ) {
        if (showText) {
            Text("Maddix - The Formula", color = currentColor, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
        }
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = currentColor,
                contentColor = Color.Black
            )
        ) {
            Text("CLICK ME")
        }
    }
}

@Composable
fun RotatingElements(
    rotationAngle: Float,
    pulseFlow: SharedFlow<Unit>,
    enablePulse: Boolean,
    animateHue: Boolean,
    toggleStates: Boolean,
    enableGlitch: Boolean,
    glitchAlpha: Boolean,
    morphElements: Boolean
) {
    val scale = remember { Animatable(1f) }

    if (enablePulse) {
        LaunchedEffect(Unit) {
            pulseFlow.collect {
                scale.animateTo(1.2f, tween(100))
                scale.animateTo(1f, tween(100))
            }
        }
    }

    val ringCount = 7
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

    Box(
        modifier = Modifier.graphicsLayer(
            rotationZ = rotationAngle,
            scaleX = scale.value,
            scaleY = scale.value
        )
    ) {
        elements.forEachIndexed { index, (ring, itemIndexInRing) ->
            val radiusPx = with(density) { (baseRadius + radiusStep * ring).toPx() }
            val itemsInRing = 6 + ring * 4
            val angle = (360f / itemsInRing * itemIndexInRing) * (PI / 180)
            val x = radiusPx * cos(angle).toFloat()
            val y = radiusPx * sin(angle).toFloat()

            val hueOffset = if (animateHue) rememberAnimatedHueFast(index).value else 200f
            val color = Color.hsl(hueOffset % 360f, 0.8f, 0.5f)

            RotationContent(
                x = x,
                y = y,
                index = index,
                switchStates = switchStates,
                checkboxStates = checkboxStates,
                color = color,
                enableToggle = toggleStates,
                enableGlitch = enableGlitch,
                glitchAlpha = glitchAlpha,
                morphElements = morphElements
            )
        }
    }
}


@Composable
private fun RotationContent(
    x: Float,
    y: Float,
    index: Int,
    switchStates: MutableList<Boolean>,
    checkboxStates: MutableList<Boolean>,
    color: Color,
    enableToggle: Boolean,
    enableGlitch: Boolean,
    glitchAlpha: Boolean,
    morphElements: Boolean
) {
    val glitchOffsetX by remember { mutableStateOf((0..10).random() - 5) }
    val glitchOffsetY by remember { mutableStateOf((0..10).random() - 5) }
    val alpha by remember {
        mutableFloatStateOf(
            if (glitchAlpha) Random.nextFloat() * 0.7f + 0.3f else 1f
        )
    }

    if (enableToggle) {
        LaunchedEffect(index) {
            while (true) {
                delay((100..1000).random().toLong())
                when (index % 4) {
                    0 -> switchStates[index] = !switchStates[index]
                    1 -> checkboxStates[index] = !checkboxStates[index]
                }
            }
        }
    }

    val elementType = remember(index, morphElements) {
        if (!morphElements) index % 4
        else (0..3).random()
    }

    val offset = if (enableGlitch && (elementType == 2 || elementType == 3)) {
        IntOffset(
            x.roundToInt() + glitchOffsetX,
            y.roundToInt() + glitchOffsetY
        )
    } else IntOffset(x.roundToInt(), y.roundToInt())

    val finalAlpha = if (enableGlitch && (elementType == 2 || elementType == 3)) alpha else 1f

    Box(
        modifier = Modifier
            .offset { offset }
            .size(40.dp)
            .graphicsLayer(alpha = finalAlpha),
        contentAlignment = Alignment.Center
    ) {
        when (elementType) {
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

@Composable
fun Ray(angle: Float) {
    val length = 300.dp
    val fade = remember { Animatable(1f) }

    LaunchedEffect(angle) {
        fade.animateTo(0f, animationSpec = tween(300))
    }

    Box(
        modifier = Modifier
            .graphicsLayer(
                rotationZ = angle,
                alpha = fade.value
            )
            .offset { IntOffset(0, -20) } // сместить от центра
            .width(4.dp)
            .height(length)
            .background(Color.White.copy(alpha = fade.value))
    )
}


data class LegendaryScreenConfig(
    val enablePulseAnimation: Boolean = false,
    val enableFlashOverlay: Boolean = false,
    val enableHueDiscoCenter: Boolean = true,
    val enableCenterText: Boolean = true,
    val enableMusic: Boolean = true,
    val showRotatingElements: Boolean = true,
    val animateHueInElements: Boolean = true,
    val toggleElementStates: Boolean = true,

    val enableShakeOnClick: Boolean = false,
    val enableIdleBreathing: Boolean = false,
    val enableClickRays: Boolean = false,
    val enableGlitchEffect: Boolean = false,
    val glitchAlphaEnabled: Boolean = false,
    val enableSmoothFlash: Boolean = false,
    val enableMorphingElements: Boolean = false
)

@Composable
fun rememberInfiniteRotation(): Float {
    val rotation by rememberInfiniteTransition(label = "Rotation").animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(12000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "RotationAnim"
    )
    return rotation
}

