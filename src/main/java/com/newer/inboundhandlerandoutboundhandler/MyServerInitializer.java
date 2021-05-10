package com.newer.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //入站的handler进行解码
        pipeline.addLast(new MyByteToLongDecoder());

        //自定义的handler处理业务逻辑
        pipeline.addLast(new MyServerHandler());
    }
}
