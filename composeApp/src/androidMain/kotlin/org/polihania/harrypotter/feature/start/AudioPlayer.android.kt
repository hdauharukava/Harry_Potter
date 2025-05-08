package org.polihania.harrypotter.feature.start

import android.content.Context
import android.media.MediaPlayer

actual class AudioPlayer(private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    actual fun playLooped(resource: String) {
        val resId = context.resources.getIdentifier(resource, "raw", context.packageName)
        mediaPlayer = MediaPlayer.create(context, resId).apply {
            isLooping = true
            start()
        }
    }

    actual fun stop() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
