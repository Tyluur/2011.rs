package org.openrsx.protocol.login.protocol.encode

import org.openrsx.protocol.client.Client
import org.openrsx.protocol.login.Protocol.LOGOUT

fun Client.logout() = send(LOGOUT) {}
