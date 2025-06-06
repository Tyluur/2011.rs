package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.instruction.WorldMapClick
import org.openrsx.protocol.login.protocol.Decoder

class WorldMapClickDecoder : Decoder(4) {

    override suspend fun decode(packet: ByteReadPacket) = WorldMapClick(packet.readInt())

}
