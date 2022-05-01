package com.epics.student_facultyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button stud,faculty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stud= findViewById(R.id.studentbtn);
        faculty=findViewById(R.id.facultybtn);
        stud.setOnClickListener(view -> {
            Intent fact = new Intent(MainActivity.this,Student.class);
            startActivity(fact);
        });
        faculty.setOnClickListener(view -> {
            Intent fact = new Intent(MainActivity.this,Faculty.class);
            startActivity(fact);
        });
    }
}