package nio;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient01 {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        String url = "http://localhost:8802/";
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(2000) //服务器响应超时时间
                .setConnectTimeout(2000) //连接服务器超时时间
                .build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println("响应状态："+response.getStatusLine());
            System.out.println("响应内容："+EntityUtils.toString(entity));
            client.close();
        } catch (IOException e) {
            System.out.println("出现异常了");
            e.printStackTrace();
        }


    }
}
