package com.example.assessmentreview;

import androidx.annotation.LongDef;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    private ArrayList<String> mClassrooms = new java.util.ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");

        ImageButton btnFilter = findViewById(R.id.action_bar_filter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Filtering");
                showFilter();
            }
        });
        initClassroomData();
    }

    public void showFilter(){
        Intent intent = new Intent(this, FilterView.class);
        startActivity(intent);
    }

    private void initClassroomData(){
        Log.d(TAG, "initClassroomData: getting classroom data");

        mClassrooms.add("CS HL/SL Gr 12 D1P1");
        Log.d(TAG, "initClassroomData: CS HL/SL Gr 12 D1P1 (size: " + mClassrooms.size()+")");
        mClassrooms.add("AI SL Gr 11 D1P2");
        Log.d(TAG, "initClassroomData: AI SL Gr 11 D1P2 (size: " + mClassrooms.size()+")");
        mClassrooms.add("AI HL Gr 11 D1P4");
        Log.d(TAG, "initClassroomData: AI HL Gr 11 D1P4 (size: " + mClassrooms.size()+")");
        mClassrooms.add("CS HL/SL Gr 11 D2P1");
        Log.d(TAG, "initClassroomData: CS HL/SL Gr 11 D2P1 (size: " + mClassrooms.size()+")");
        mClassrooms.add("AI HL Gr 12 D2P3");
        Log.d(TAG, "initClassroomData: AI HL Gr 12 D2P3 (size: " + mClassrooms.size()+")");
        mClassrooms.add("AA SL Gr 12 D2P4");
        Log.d(TAG, "initClassroomData: AA SL Gr 12 D2P4 (size: " + mClassrooms.size()+")");
        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recycler view");

        RecyclerView recyclerView = findViewById(R.id.classroomView);
        ClassroomViewAdapter adapter = new ClassroomViewAdapter(mClassrooms, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}