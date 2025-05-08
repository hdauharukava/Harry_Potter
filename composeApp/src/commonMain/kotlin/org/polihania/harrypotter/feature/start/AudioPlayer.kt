package org.polihania.harrypotter.feature.start

expect class AudioPlayer {
    fun playLooped(resource: String)
    fun stop()
}