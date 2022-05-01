package com.epics.student_facultyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class Student extends AppCompatActivity {
    ListView list;
    ArrayList<Material> material= new ArrayList<>();
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        MyListAdapter adapter=new MyListAdapter(this, material);
        list=(ListView)findViewById(R.id.list);
        DB = new DBHelper(this);
        Cursor res = DB.getdata();
        if(res.getCount()==0){
            Toast.makeText(Student.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }

        while(res.moveToNext()){
            Material m=new Material(res.getString(0),res.getString(1),res.getString(2));
            material.add(m);
        }
        list.setAdapter(adapter);
        list.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(material.get(i).link));
            startActivity(browserIntent);
        });
    }
}