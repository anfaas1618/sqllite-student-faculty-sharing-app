package com.epics.student_facultyapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MyListAdapter extends ArrayAdapter<Material> {

    private final Activity context;
    private final ArrayList<Material> materials;


    public MyListAdapter(Activity context,  ArrayList<Material> materials) {
        super(context, R.layout.listview_layout,materials);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.materials = materials;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_layout, null,true);

        TextView nameT = (TextView) rowView.findViewById(R.id.name1);
        TextView subjectT = (TextView) rowView.findViewById(R.id.subject1);
        TextView linkT = (TextView) rowView.findViewById(R.id.link1);

        nameT.setText(materials.get(position).getName());
        subjectT.setText(materials.get(position).getSubject());
        linkT.setText(materials.get(position).getLink());
        return rowView;

    };
}