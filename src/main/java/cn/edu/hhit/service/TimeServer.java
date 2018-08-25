package cn.edu.hhit.service;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 时间服务器, 粘包拆包初步解决:LineBasedFrameDecoder通过标识符号哦换行符
 * Created by Lovell on 30/09/2016.
 */
/*
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 @@@@  @@@@@@@@        @@  @@@@@@@  @@        @@  @@@@@@@@@  @@@@@@@@@@
 @@@@  @@@@@@@@  @@@@  @@@  @@@@@  @@@  @@@@@@@@  @@@@@@@@@  @@@@@@@@@@
 @@@@  @@@@@@@@  @@@@  @@@@  @@@  @@@@       @@@  @@@@@@@@@  @@@@@@@@@@
 @@@@  @@@@@@@@  @@@@  @@@@@  @  @@@@@  @@@@@@@@  @@@@@@@@@  @@@@@@@@@@
 @@@@        @@        @@@@@@   @@@@@@        @@        @@@        @@@@
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 */

public class TimeServer {

    public void bind(int port) throws Exception {
        // 配置服务端的NIO线程组
        // NioEventLoopGroup类是个线程组，包含一组NIO线程，用于网络事件的处理
        // （实际上他就是Reactor 线程组）

        // 创建2个线程组， 1个是服务端接收客户端的连接，
        // 另一个是进行SocketChannel的网络读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // ServerBootstrap 类， 是启动NIO服务器的辅助启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)  // NIO Socket管道
                    .option(ChannelOption.SO_BACKLOG, 1024) // 握手成功缓存大小
                    .option(ChannelOption.SO_KEEPALIVE, true) // 2小时无数据激活心跳机制
                    .childHandler(new ServerChannelHandler());

            /**
             * 这个都是socket的标准参数，并不是netty自己的。
             * 具体为：

             * ChannelOption.SO_BACKLOG, 1024
             * BACKLOG用于构造服务端套接字ServerSocket对象，标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度。
             * 如果未设置或所设置的值小于1，Java将使用默认值50。

             * ChannelOption.SO_KEEPALIVE, true
             * 是否启用心跳保活机制。在双方TCP套接字建立连接后（即都进入ESTABLISHED状态）并且在两个小时左右上层没有任何数据传输的情况下，
             * 这套机制才会被激活。

             * ChannelOption.TCP_NODELAY, true
             * 在TCP/IP协议中，无论发送多少数据，总是要在数据前面加上协议头，同时，对方接收到数据，也需要发送ACK表示确认。
             * 为了尽可能的利用网络带宽，TCP总是希望尽可能的发送足够大的数据。
             * 这里就涉及到一个名为Nagle的算法，该算法的目的就是为了尽可能发送大块数据，避免网络中充斥着许多小数据块。
             * TCP_NODELAY就是用于启用或关于Nagle算法。如果要求高实时性，有数据发送时就马上发送，就将该选项设置为true关闭Nagle算法；
             * 如果要减少发送次数减少网络交互，就设置为false等累积一定大小后再发送。默认为false。
             */

            // 绑定端口，同步等待成功
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();

            // 等待服务端监听端口关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    private class ServerChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            // 为了解决TCP粘包拆包的问题，Netty默认提供了多种编码器来处理，以下通过代码来说明；
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1111;
        if (args != null && args.length > 0) {
            try{
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException ex) {

            }
        }
        new TimeServer().bind(port);
    }
}