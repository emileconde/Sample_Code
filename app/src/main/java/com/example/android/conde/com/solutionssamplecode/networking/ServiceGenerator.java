package com.example.android.conde.com.solutionssamplecode.networking;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit sRetrofit = retrofitBuilder.build();

    private static RequestApi sRequestApi = sRetrofit.create(RequestApi.class);

    public static RequestApi getRequestApi() {
        return sRequestApi;
    }
}
