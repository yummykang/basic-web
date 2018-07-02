package me.yummykang.httpserver;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Nothing to describe.
 *
 * @author demon
 * @create 2018-07-02 15:40
 */
@Slf4j
public class HttpServerHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                Unpooled.copiedBuffer("Hello servlet", CharsetUtil.UTF_8));

        TestServlet servlet = new TestServlet();
        ServletResponse servletResponse = new ServletResponse(response, ctx);
        servlet.service(new ServletReqeust((FullHttpRequest) msg), servletResponse);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.error("server handler error: {}", cause.getMessage());
        ctx.close();
    }
}
