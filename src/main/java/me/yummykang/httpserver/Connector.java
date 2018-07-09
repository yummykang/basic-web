package me.yummykang.httpserver;

/**
 * Nothing to describe.
 *
 * @author demon
 * @create 2018-07-09 15:18
 */
public interface Connector {

    /**
     * 设置端口
     *
     * @param port 端口
     * @return Connector
     */
    Connector port(int port);

    /**
     * 停止
     *
     * @return Connector
     * @throws Exception Something bad would happened
     */
    Connector stop() throws Exception;

    /**
     * 启动
     *
     * @return Connector
     * @throws Exception Something bad would happened
     */
    Connector start() throws Exception;
}
