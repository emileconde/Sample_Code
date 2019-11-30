package com.example.android.conde.com.solutionssamplecode.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.android.conde.com.solutionssamplecode.R;

import androidx.appcompat.app.AppCompatActivity;

public class MemoryLeaksActivity extends AppCompatActivity {
    private static final String TAG = "MemoryLeaksActivity";
    private static int num = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leaks);
        //clicking on this button and pressing the back button
        // will cause memory leak which will trigger LeakCanary
        findViewById(R.id.btn_leak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask<Void, Void, Void>(){

                    @Override
                    protected Void doInBackground(Void... voids) {
                        operation(num);
                        return null;
                    }

                    private void operation(int num) {
                        for(int i = 0; i < num; i++){
                            try {
                                Thread.sleep(1000*num);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.execute();
            }
        });
    }


}
