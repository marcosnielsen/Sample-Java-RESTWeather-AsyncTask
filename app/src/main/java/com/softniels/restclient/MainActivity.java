package com.softniels.restclient;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.myLabel);
        GetTask myTask = new GetTask();
        myTask.execute();
    }
    //****************************************************
    //        Context context = getApplicationContext();
    //        CharSequence text = "teste toast";
    //        int duration = Toast.LENGTH_SHORT;
    //        Toast toast = Toast.makeText(context, text, duration);
    //        toast.show();

    //****************************************************
    //        RESTWeather restWeather = new RESTWeather();
    //        String response = null;
    //        try {
    //            response = restWeather.Get("https://api.hgbrasil.com/weather");
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //        Log.i("RESPONSE HTTP", response);

    //****************************************************
    //        AsyncTask.execute(new Runnable() {
    //            @Override
    //            public void run() {
    //                Looper.prepare();
    //                RESTWeather restWeather = new RESTWeather();
    //                try {
    //                    JSONObject jsonObject = restWeather.GET();
    //                    Context context = MainActivity.this;
    //                    CharSequence text = jsonObject.getJSONObject("results").getString("description");
    //                    int duration = Toast.LENGTH_SHORT;
    //                    Toast toast = Toast.makeText(context, text, duration);
    //                    toast.show();
    //                    Log.i("toast", "toast showed");
    //                } catch (IOException e) {
    //                    e.printStackTrace();
    //                } catch (JSONException e) {
    //                    e.printStackTrace();
    //                }
    //            }
    //        });

        private class GetTask extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... params) {
            RESTWeather restWeather = new RESTWeather();
            String response = "";
            try {
                response = restWeather.Get("https://api.hgbrasil.com/weather");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String response) {
            Log.i("onPostExecute", response);
            textView.setText(response);
        }
    }
}
