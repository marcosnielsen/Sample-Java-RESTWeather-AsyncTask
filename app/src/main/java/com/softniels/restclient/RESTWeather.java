package com.softniels.restclient;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RESTWeather {
    //    sample with  HttpURLConnection e URL
    //    public String Get() throws IOException, JSONException {
    //        URL url = new URL("https://api.hgbrasil.com/weather");
    //        HttpURLConnection con = (HttpURLConnection) url.openConnection();
    //        con.setRequestMethod("GET");
    //        con.setRequestProperty("User-Agent", "RESTWeather-1.0");
    //        BufferedReader in = new BufferedReader(
    //                new InputStreamReader(con.getInputStream()));
    //        String inputLine;
    //        StringBuffer response = new StringBuffer();
    //        while ((inputLine = in.readLine()) != null) {
    //            response.append(inputLine);
    //        }
    //        in.close();
    //        Log.i("JSON", response.toString());
    //        return response.toString();
    //    }

    //    *************************************************
    //    sample with  OkHttpClient  very simple
    //
    private OkHttpClient client = new OkHttpClient();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String Get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
