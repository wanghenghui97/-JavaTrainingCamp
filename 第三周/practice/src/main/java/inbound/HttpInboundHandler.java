package inbound;

import filter.HeaderHttpRequestFilter;
import filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import outbound.httpclient4.HttpOutboundHandler;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();

    private final List<String> proxyServer;
    private HttpOutboundHandler handler;

    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpOutboundHandler(this.proxyServer);

    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            logger.info("channelRead流量接口请求开始，时间为{}", new Date());
            FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
            String uri = fullHttpRequest.getUri();
            logger.info("接收到的请求url为{}", uri);
            System.out.println("接收到的请求url为" + uri);
            filter.filter(fullHttpRequest,null);
            System.out.println("请求头："+fullHttpRequest.headers());
            ExecutorService executorService =  Executors.newFixedThreadPool(10);

            if(uri.contains("/test1")){
                
            }

            handler.handle(fullHttpRequest, ctx, filter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }

    }
}
