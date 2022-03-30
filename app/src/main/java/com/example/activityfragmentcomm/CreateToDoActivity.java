package com.example.activityfragmentcomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateToDoActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_NEW_TODO = "CreateToDoActivity_KEY_NEW_TODO";
    private Button saveButton;
    private EditText etToDo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);

        initViews();
    }

    private void initViews() {

        saveButton = findViewById(R.id.btn_add_todo);
        etToDo = findViewById(R.id.et_new_todo);
        saveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(etToDo.getText().toString().trim().isEmpty()){
            showToast("Please enter a todo");
        }else{
            if (view.getId() == R.id.btn_add_todo) {
                Intent passData = new Intent();
                passData.putExtra(KEY_NEW_TODO, etToDo.getText().toString());
                setResult(MainActivity.OPEN_CODE_ACTIVITY, passData);
                finish();//Terminate the activity
            }
        }
            
    }

    private void showToast(String please_enter_a_todo) {
        Toast.makeText(this, please_enter_a_todo, Toast.LENGTH_SHORT).show();
    }
}
