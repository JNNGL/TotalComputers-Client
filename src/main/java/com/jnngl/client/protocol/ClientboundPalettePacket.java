package com.jnngl.client.protocol;

import io.netty.buffer.ByteBuf;

public class ClientboundPalettePacket extends Packet {

    @Override
    public byte getPacketID() {
        return (byte)0xC1;
    }

    @Override
    public void writeData(ByteBuf buf) {
        buf.writeInt(palette.length);
        for(int color : palette) buf.writeInt(color);
    }

    @Override
    public void readData(ByteBuf buf, int length) throws Exception {
        palette = new int[buf.readInt()];
        for(int i = 0; i < palette.length; i++)
            palette[i] = buf.readInt();
    }

    @Override
    public int getLength() {
        return 4*palette.length;
    }

    public int[] palette;

}
