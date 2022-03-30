package com.example.activityfragmentcomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final int OPEN_CODE_ACTIVITY = 1;
    private ArrayAdapter<String> adapter;
    private ListView lvDisplayToDo;
    private FloatingActionButton createToDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        createToDo = findViewById(R.id.fabCreateTodo);
        lvDisplayToDo = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvDisplayToDo.setAdapter(adapter);
        createToDo.setOnClickListener(this::onClickFab);
    }

    private void onClickFab(View view) {

        Intent intent = new Intent(this, CreateToDoActivity.class);
        startActivityForResult(intent, OPEN_CODE_ACTIVITY);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == OPEN_CODE_ACTIVITY){
            if (data != null) {
                String todo = data.getStringExtra(CreateToDoActivity.KEY_NEW_TODO);
                updateAdapter(todo);
            }
        }
    }

    private void updateAdapter(String todo) {
        adapter.add(todo);
    }
}