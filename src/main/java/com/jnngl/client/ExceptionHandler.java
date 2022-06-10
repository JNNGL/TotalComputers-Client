package com.jnngl.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ExceptionHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.err.println("Unexpected error: "+cause.getMessage());
        System.err.println("Disconnecting...");
        ctx.disconnect();
    }
}
