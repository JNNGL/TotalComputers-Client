package com.jnngl.client.protocol;

import com.jnngl.client.exception.TooSmallPacketException;
import io.netty.buffer.ByteBuf;

public class ServerboundFramePacket extends Packet {

    @Override
    public byte getPacketID() {
        return (byte)0xC0;
    }

    @Override
    public void writeData(ByteBuf buf) {
        buf.writeShort(id);
        buf.writeBytes(compressedData);
    }

    @Override
    public void readData(ByteBuf buf, int length) throws Exception {
        if(length < 2) throw new TooSmallPacketException(length, 2);
        id = buf.readShort();
        compressedData = new byte[buf.readableBytes()];
        buf.readBytes(compressedData, 0, compressedData.length);
        if(compressedData.length != length-2) {
            System.err.println("Received incomplete frame buffer");
            compressedData = null;
        }
    }

    @Override
    public int getLength() {
        if(compressedData == null) return 2;
        return 2+compressedData.length;
    }

    public short id;
    public byte[] compressedData;

}
