package org.openrsx.protocol.login

import kotlinx.coroutines.channels.SendChannel
import org.openrsx.protocol.client.Client
import org.openrsx.protocol.client.Instruction

/**
 * Loads and checks existing accounts
 */
interface AccountLoader {
    fun exists(username: String): Boolean

    fun password(username: String): String?

    suspend fun load(client: Client, username: String, passwordHash: String, displayMode: Int): SendChannel<Instruction>?
}
