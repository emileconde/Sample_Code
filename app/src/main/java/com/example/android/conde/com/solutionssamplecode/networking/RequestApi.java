package com.example.android.conde.com.solutionssamplecode.networking;

import com.example.android.conde.com.solutionssamplecode.networking.Response.ResponseBody;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface RequestApi {

    @GET("todos/1")
    Flowable<ResponseBody> makeFlowableQuery();

}
