package com.example.didongsqlite;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterList extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Student> studentList;
    private int pos = -1;
    static int id=-1;
    View view;

    public AdapterList(Context context, int idLayout, List<Student> studentList) {
        this.context = context;
        this.idLayout = idLayout;
        this.studentList = studentList;

    }

    @Override
    public int getCount() {
        if (studentList.size() != 0 && !studentList.isEmpty()) {
            return studentList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.textView);
        view = convertView.findViewById(R.id.view);
        Student st = studentList.get(position);
        name.setText(st.getName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pos = position;
                notifyDataSetChanged();
                id = st.getId();
            }


        });

        if (pos == position) {
            view.setBackgroundResource(R.drawable.ic_launcher_background);
        } else {
            view.setBackgroundColor(Color.rgb(111, 189, 161));
        }

        return convertView;
    }

}