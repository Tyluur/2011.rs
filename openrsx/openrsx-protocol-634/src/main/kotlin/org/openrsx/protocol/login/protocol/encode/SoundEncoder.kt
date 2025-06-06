package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.JINGLE
import org.openrsx.protocol.login.Protocol.MIDI_SOUND
import org.openrsx.protocol.login.Protocol.PLAY_MUSIC
import org.openrsx.protocol.login.Protocol.SOUND_EFFECT
import org.openrsx.protocol.login.protocol.writeByteInverse
import org.openrsx.protocol.login.protocol.writeByteSubtract
import org.openrsx.protocol.login.protocol.writeMedium
import org.openrsx.protocol.login.protocol.writeShortAddLittle

fun Client.playMusicTrack(
    music: Int,
    delay: Int = 100,
    volume: Int = 255
) = send(PLAY_MUSIC) {
    writeByteSubtract(delay)
    writeByteSubtract(volume)
    writeShortAddLittle(music)
}

fun Client.playSoundEffect(
    sound: Int,
    delay: Int = 0,
    volume: Int = 255,
    speed: Int = 255,
    repeat: Int = 1
) = send(SOUND_EFFECT) {
    writeShort(sound)
    writeByte(repeat)
    writeShort(delay)
    writeByte(volume)
    writeShort(speed)
}

fun Client.playMIDI(
    sound: Int,
    delay: Int = 0,
    volume: Int = 255,
    speed: Int = 255,
    repeat: Int = 1
) = send(MIDI_SOUND) {
    writeShort(sound)
    writeByte(repeat)
    writeShort(delay)
    writeByte(volume)
    writeShort(speed)
}

fun Client.playJingle(
    effect: Int,
    volume: Int = 255
) = send(JINGLE) {
    writeMedium(0)
    writeShortAddLittle(effect)
    writeByteInverse(volume)
}
