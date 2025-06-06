package org.openrsx.protocol.client


sealed class ClientState {
    data object Connected : ClientState()
    /**
     * Waiting for [ConnectionQueue] to allow disconnection
     */
    data object Disconnecting : ClientState()
    data object Disconnected : ClientState()
}
