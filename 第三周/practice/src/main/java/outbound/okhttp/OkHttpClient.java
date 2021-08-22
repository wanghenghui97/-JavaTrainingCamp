package outbound.okhttp;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpClient {
    public static void main(String[] args) {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        String url = "http://localhost:8802";
        Request request = new Request.Builder().url(url).get().build();
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            System.out.println("响应状态："+response.code());
            System.out.println("响应内容："+response.body().string());
            response.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
