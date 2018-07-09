package me.yummykang.httpserver;

/**
 * Nothing to describe.
 *
 * @author demon
 * @create 2018-07-09 16:42
 */
public abstract class AbstractConnector implements Connector {
    private int port;

    @Override
    public AbstractConnector port(int port) {
        this.port = port;
        return this;
    }

    protected int getPort() {
        return this.port;
    }
}
