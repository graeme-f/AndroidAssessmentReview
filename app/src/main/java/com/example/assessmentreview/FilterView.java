package com.example.assessmentreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class FilterView extends AppCompatActivity {

    private SharedPreferences mPrefs;

    private static final String TAG = "FilterView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_view);

        ImageButton btnFilter = findViewById(R.id.action_back_arrow);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Close Filter Page");
                finish();
            }
        });

        mPrefs = getSharedPreferences(getPackageName(),MODE_PRIVATE);
        CheckBox cb = (CheckBox) findViewById(R.id.CS);
        cb.setChecked(mPrefs.getBoolean("Computer Science", false));
        cb = (CheckBox) findViewById(R.id.Maths);
        cb.setChecked(mPrefs.getBoolean("Mathematics", false));
        cb = (CheckBox) findViewById(R.id.ASA);
        cb.setChecked(mPrefs.getBoolean("ASA", false));
        cb = (CheckBox) findViewById(R.id.Other);
        cb.setChecked(mPrefs.getBoolean("Other", false));
        cb = (CheckBox) findViewById(R.id.Grade12);
        cb.setChecked(mPrefs.getBoolean("Grade 12", false));
        cb = (CheckBox) findViewById(R.id.Grade11);
        cb.setChecked(mPrefs.getBoolean("Grade 11", false));
        cb = (CheckBox) findViewById(R.id.Grade10);
        cb.setChecked(mPrefs.getBoolean("Grade 10", false));
        cb = (CheckBox) findViewById(R.id.Grade9);
        cb.setChecked(mPrefs.getBoolean("Grade 9", false));
        cb = (CheckBox) findViewById(R.id.Grade8);
        cb.setChecked(mPrefs.getBoolean("Grade 8", false));
        cb = (CheckBox) findViewById(R.id.GradeNone);
        cb.setChecked(mPrefs.getBoolean("None", false));
    }

    public void onClassroomFilter(View view){
        MaterialRadioButton rb = (MaterialRadioButton)view;
        Log.d(TAG, "onClassroomFilter: " + rb.getText() + " " + rb.isChecked());
    }

    public void onSubjectClicked(View view){
        CheckBox cb = (CheckBox) view;
        Log.d(TAG, "onSubjectClicked: " + cb.getText() + " " + cb.isChecked());
        savePreference(cb.getText().toString(), cb.isChecked());
    }

    public void onGradeClicked(View view){
        CheckBox cb = (CheckBox) view;
        Log.d(TAG, "onGradeClicked: " + cb.getText() + " " + cb.isChecked());
        savePreference(cb.getText().toString(), cb.isChecked());
    }

    private void savePreference(String key, Boolean value){
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putBoolean(key, value);
        ed.apply();
    }
}