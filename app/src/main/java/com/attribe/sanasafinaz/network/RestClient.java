package com.attribe.sanasafinaz.network;

import com.attribe.sanasafinaz.utils.Constants;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maaz on 7/14/2016.
 */
public class RestClient {

    private static ApiInterface mApiInterface;

    public RestClient(){}

    static { setUpRestClient(); }

    public static void setUpRestClient() {

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {

                request.addHeader("Content-Type","application/json");
                request.addHeader("Accept","application/json");
                request.addHeader("Authorization","5743f995-0f34-4082-855f-c5c22e20ca07");

            }
        };

        OkHttpClient okHttpClient=new OkHttpClient();
        okHttpClient.setReadTimeout(Constants.TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.setConnectTimeout(Constants.TIMEOUT, TimeUnit.MILLISECONDS);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL_PROD)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)

                .setClient(new OkClient(okHttpClient))
                .build();

        mApiInterface = restAdapter.create(ApiInterface.class);
    }

    public static ApiInterface getAdapter(){
        return mApiInterface;
    }

}
