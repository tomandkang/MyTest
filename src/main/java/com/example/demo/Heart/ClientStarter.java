package com.example.demo.Heart;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/5/5 15:59
 **/
public class ClientStarter {


    private Bootstrap bootstrap;
    private int times = 0;

    public ClientStarter(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
        ClientStarter clientStarter = this;
        bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                        ch.pipeline().addLast(new StringDecoder());
                        //发送消息频率。单位秒。此设置是60秒发送一次消息
                        ch.pipeline().addLast(new IdleStateHandler(60, 60, 60));
                        ch.pipeline().addLast(new HeartBeatClientHandler(clientStarter));
                    }
                });
    }

    public void connect() {
        ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("ip", 9090));
        channelFuture.addListener(future ->{
            if (future.isSuccess()) {
                System.out.println("connect to server success");
            } else {
                System.out.println("connect to server failed,try times:" + ++times);
                connect();
            }
        });
    }
}
