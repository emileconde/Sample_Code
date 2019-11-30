package com.example.android.conde.com.solutionssamplecode.repositories;

import com.example.android.conde.com.solutionssamplecode.networking.Response.ResponseBody;
import com.example.android.conde.com.solutionssamplecode.networking.ServiceGenerator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import io.reactivex.schedulers.Schedulers;

public class ReactiveActivityRepository {

    private static ReactiveActivityRepository instance;

    public static ReactiveActivityRepository getInstance(){
        if(instance == null)
            instance = new ReactiveActivityRepository();

        return instance;
    }

    /*
     * Converting a Flowable into a LiveData that can
     * be observed in the Actvity
     * */
    public LiveData<ResponseBody> makeReactiveQuery(){
        return LiveDataReactiveStreams.fromPublisher(ServiceGenerator.getRequestApi()
        .makeFlowableQuery()
        .subscribeOn(Schedulers.io()));
    }

}
