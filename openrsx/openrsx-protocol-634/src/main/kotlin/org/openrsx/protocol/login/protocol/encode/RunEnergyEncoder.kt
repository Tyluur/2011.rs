package org.openrsx.protocol.login.protocol.encode

import io.ktor.utils.io.*
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.RUN_ENERGY

/**
 * Sends run energy
 * @param energy The current energy value
 */
fun Client.sendRunEnergy(energy: Int) = send(RUN_ENERGY) {
    writeByte(energy)
}
