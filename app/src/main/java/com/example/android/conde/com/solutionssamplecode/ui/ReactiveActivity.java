package com.example.android.conde.com.solutionssamplecode.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.conde.com.solutionssamplecode.R;
import com.example.android.conde.com.solutionssamplecode.networking.Response.ResponseBody;
import com.example.android.conde.com.solutionssamplecode.viewmodels.ReactiveActivityViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class ReactiveActivity extends AppCompatActivity {
    private static final String TAG = "ReactiveActivity";
    private ReactiveActivityViewModel mViewModel;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reactive);
        mViewModel = ViewModelProviders.of(this).get(ReactiveActivityViewModel.class);
        mTextView = findViewById(R.id.tv_task);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReactiveActivity.this, MemoryLeaksActivity.class));
            }
        });

        subscribeObservers();
    }

    /*
     * If there is any change on the api side it'ss automatically reflect on the ui
     * */
    private void subscribeObservers() {
        mViewModel.makeReactiveQuery().observe(this, new Observer<ResponseBody>() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onChanged(ResponseBody responseBody) {
                mTextView.setText(String.format("TaskID: %d\n" +
                        "Title: %s\n" +
                        "User ID: %d", responseBody.getId(), responseBody.getTitle(), responseBody.getUserId()));
            }
        });
    }
}
