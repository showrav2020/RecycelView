package com.example.recycelview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                //continents?api_token=8encidp1gBTafShSHCfntCqI6cGgJITTl1JKL6zP6iWVXTHBss4RYKnXml2n
                .addConverterFactory(GsonConverterFactory.create()).build();


        RequestInterface requestInterface=(RequestInterface) retrofit.create(RequestInterface.class);
        Call<ArrayDataItem> call= requestInterface.getData("8encidp1gBTafShSHCfntCqI6cGgJITTl1JKL6zP6iWVXTHBss4RYKnXml2n");

        call.enqueue(new Callback<ArrayDataItem>() {
            @Override
            public void onResponse(Call<ArrayDataItem> call, Response<ArrayDataItem> response) {
                List<ItemData> list = response.body().getData();
                for (ItemData itemData : list){
                    Log.e("id", itemData.getId());
                    Log.e("name", itemData.getName());
                    Log.e("resource", itemData.getResource());
                    //Log.e("getupdated_at", itemData.getUpdated_at());
                }
                Toast.makeText(getApplicationContext(),"Onresponse",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ArrayDataItem> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Onrfailure",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
