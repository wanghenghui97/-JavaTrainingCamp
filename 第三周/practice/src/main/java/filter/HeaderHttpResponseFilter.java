package filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HeaderHttpResponseFilter implements HttpResponseFilter{
    @Override
    public void filter(FullHttpResponse fullHttpResponse) {
        fullHttpResponse.headers().set("whh","perfect");
    }
}
