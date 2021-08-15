package nio;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClient02 {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
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
