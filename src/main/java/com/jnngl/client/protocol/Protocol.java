package com.jnngl.client.protocol;

import com.jnngl.client.exception.PacketAlreadyExistsException;

public class Protocol {

    public static void registerPackets() throws PacketAlreadyExistsException, NoSuchMethodException {
        Packet.registerPacket(new ServerboundHandshakePacket());
        Packet.registerPacket(new ClientboundHandshakePacket());
        Packet.registerPacket(new ClientboundDisconnectPacket());
        Packet.registerPacket(new ServerboundConnectPacket());
        Packet.registerPacket(new ClientboundConnectionSuccessPacket());
        Packet.registerPacket(new ClientboundPingPacket());
        Packet.registerPacket(new ServerboundPongPacket());
        Packet.registerPacket(new ClientboundCreationRequestPacket());
        Packet.registerPacket(new ServerboundCreationStatusPacket());
        Packet.registerPacket(new ClientboundDestroyPacket());
    }

}
