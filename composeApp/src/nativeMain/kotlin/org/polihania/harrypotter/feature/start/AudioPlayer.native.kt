package org.polihania.harrypotter.feature.start

import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioPlayer
import platform.Foundation.NSBundle
import platform.Foundation.NSURL

actual class AudioPlayer {

    private var player: AVAudioPlayer? = null

    @OptIn(ExperimentalForeignApi::class)
    actual fun playLooped(resource: String) {
        val path = NSBundle.mainBundle.pathForResource(name = resource, ofType = "mp3") ?: return
        val url = NSURL.fileURLWithPath(path)

        player = AVAudioPlayer(contentsOfURL = url, error = null).apply {
            numberOfLoops = -1
            prepareToPlay()
            play()
        }
    }

    actual fun stop() {
        player?.stop()
        player = null
    }
}