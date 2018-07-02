package me.yummykang.httpserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Nothing to describe.
 *
 * @author demon
 * @create 2018-07-02 15:31
 */
@Slf4j
public class HttpServer {
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new HttpServerInitializer());
        try {
            ChannelFuture channelFuture = bootstrap.bind(8080).sync();
            log.info("                       _oo0oo_\n" +
                    "                      o8888888o\n" +
                    "                      88\" . \"88\n" +
                    "                      (| -_- |)\n" +
                    "                      0\\  =  /0\n" +
                    "                    ___/`---'\\___\n" +
                    "                  .' \\\\|     |// '.\n" +
                    "                 / \\\\|||  :  |||// \\\n" +
                    "                / _||||| -:- |||||- \\\n" +
                    "               |   | \\\\\\  -  /// |   |\n" +
                    "               | \\_|  ''\\---/''  |_/ |\n" +
                    "               \\  .-\\__  '-'  ___/-. /\n" +
                    "             ___'. .'  /--.--\\  `. .'___\n" +
                    "          .\"\" '<  `.___\\_<|>_/___.' >' \"\".\n" +
                    "         | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                    "         \\  \\ `_.   \\_ __\\ /__ _/   .-` /  /\n" +
                    "     =====`-.____`.___ \\_____/___.-`___.-'=====\n" +
                    "                       `=---='\n" +
                    "\n" +
                    "\n" +
                    "     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "\n" +
                    "               佛祖保佑         永无BUG");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("server failed start up:{}", e.getMessage());
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
