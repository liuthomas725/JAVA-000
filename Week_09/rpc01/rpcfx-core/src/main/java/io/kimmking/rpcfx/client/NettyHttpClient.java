package io.kimmking.rpcfx.client;//package io.github.kimmking.gateway.outbound;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.util.AttributeKey;

public class NettyHttpClient {
    public RpcfxResponse connect(RpcfxRequest req,String host, int port) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    //ch.pipeline().addLast(new HttpClientOutboundHandler());
                }
            });
            // Start the client.
            ChannelFuture f = b.connect(host, port).sync();
            //f.channel().writeAndFlush(JSONObject.toJSONString(req)+"\r\n");
            f.channel().write(req);
            f.channel().flush();
            f.channel().closeFuture().sync();
            AttributeKey<String> key = AttributeKey.valueOf("ServerData");
            return JSON.parseObject(f.channel().attr(key).get(), RpcfxResponse.class);
        } finally {
            workerGroup.shutdownGracefully();
        }

    }

}