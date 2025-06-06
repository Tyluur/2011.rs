package org.openrsx.protocol.login.protocol.decode

import io.ktor.utils.io.core.*
import org.openrsx.protocol.client.Instruction
import org.openrsx.protocol.client.instruction.ReportAbuse
import org.openrsx.protocol.login.protocol.Decoder
import org.openrsx.protocol.login.protocol.readString

class ReportAbuseDecoder : Decoder(BYTE) {

    override suspend fun decode(packet: ByteReadPacket): Instruction {
        val name = packet.readString()
        val type = packet.readByte().toInt()
        val integer = packet.readByte().toInt()
        val string = packet.readString()
        return ReportAbuse(name, type, integer, string)
    }

}
