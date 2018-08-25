package cn.edu.hhit.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
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

public class TimeClientHandler extends SimpleChannelInboundHandler{
    private static Logger logger = LoggerFactory.getLogger(TimeClientHandler.class);

    // 写日志
    private int counter;
    private byte[] req;

    public TimeClientHandler(){
        req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String)msg;
        System.out.println("收到的msg为："+body);
        System.out.println("Now is : " + body+", the countor is : "+ ++counter);     }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        // 当客户端和服务端建立tcp成功之后，Netty的NIO线程会调用channelActive
        // 发送查询时间的指令给服务端。
        // 调用ChannelHandlerContext的writeAndFlush方法，将请求消息发送给服务端
        // 当服务端应答时，channelRead方法被调用

        ByteBuf firstMessage;
        try {
            for (int i = 0; i < 100; i++) {
                firstMessage = Unpooled.buffer(req.length);
                firstMessage.writeBytes(req);
                System.out.println("发送的req为："+new String(req,"Utf-8"));
                ctx.writeAndFlush(firstMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        logger.warn("message from:"+cause.getMessage());
        ctx.close();
    }
}
