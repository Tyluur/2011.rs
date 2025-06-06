package org.openrsx.protocol.login.protocol.encode.zone

import org.openrsx.protocol.login.Protocol

data class MidiAddition(
    val tile: Int,
    val id: Int,
    val radius: Int,
    val repeat: Int,
    val delay: Int,
    val volume: Int,
    val speed: Int
) : ZoneUpdate(
    Protocol.MIDI_AREA,
    Protocol.Batch.MIDI_AREA,
    8
)
