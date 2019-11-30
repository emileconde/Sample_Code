package com.example.android.conde.com.solutionssamplecode.viewmodels;

import com.example.android.conde.com.solutionssamplecode.networking.Response.ResponseBody;
import com.example.android.conde.com.solutionssamplecode.repositories.ReactiveActivityRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ReactiveActivityViewModel extends ViewModel {

    private ReactiveActivityRepository mRepository;

    public ReactiveActivityViewModel() {
        mRepository = ReactiveActivityRepository.getInstance();
    }

    public LiveData<ResponseBody> makeReactiveQuery(){
        return mRepository.makeReactiveQuery();
    }

}
