/*
 * This file is part of ViaProxy - https://github.com/RaphiMC/ViaProxy
 * Copyright (C) 2023 RK_01/RaphiMC and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.raphimc.viaproxy.protocolhack.providers;

import com.viaversion.viaversion.api.connection.UserConnection;
import net.raphimc.vialegacy.protocols.classic.protocola1_0_15toc0_28_30.providers.ClassicWorldHeightProvider;
import net.raphimc.viaprotocolhack.util.VersionEnum;
import net.raphimc.viaproxy.proxy.session.ProxyConnection;

public class ViaProxyClassicWorldHeightProvider extends ClassicWorldHeightProvider {

    @Override
    public short getMaxChunkSectionCount(UserConnection user) {
        if (ProxyConnection.fromUserConnection(user).getClientVersion().isNewerThanOrEqualTo(VersionEnum.r1_17)) {
            return 64;
        }
        return 16;
    }

}
