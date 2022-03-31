package com.example.activityfragmentcomm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<TodoTask> {

    public CustomAdapter(@NonNull Context context, List<TodoTask> todoTaskList) {
        super(context, 0, todoTaskList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
            TodoTask todoTaskCurrent = getItem(position);
            onBind(view, todoTaskCurrent);
        }

        return view;
    }

    private void onBind(View view, TodoTask todoTaskCurrent) {

        TextView tv1 = view.findViewById(android.R.id.text1);
        TextView tv2 = view.findViewById(android.R.id.text2);
        tv1.setText(todoTaskCurrent.getTodoName());
        tv2.setText(todoTaskCurrent.getTodoCategory());
    }
}
