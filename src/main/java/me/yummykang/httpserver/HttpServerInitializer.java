package me.yummykang.httpserver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;


/**
 * Nothing to describe.
 *
 * @author demon
 * @create 2018-07-02 15:36
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpResponseEncoder())
                .addLast(new HttpRequestDecoder())
                .addLast(new HttpObjectAggregator(10 * 1024 * 1024))
                .addLast(new HttpServerHandler());
    }
}
