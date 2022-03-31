package com.example.activityfragmentcomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateToDoActivity extends AppCompatActivity implements View.OnClickListener, CreateCategoryFragment.CreateCategoryListener {

    public static final String KEY_NEW_TODO = "CreateToDoActivity_KEY_NEW_TODO";
    public static final String KEY_NEW_CAT = "CreateToDoActivity_KEY_NEW_CAT";

    private Button saveButton;
    private EditText etToDo;
    private Spinner spinner;
    private ArrayAdapter<String> categoryAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);

        initViews();
    }

    private void initViews() {

        String[] categories = getResources().getStringArray(R.array.default_category_names);
        categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);

        saveButton = findViewById(R.id.btn_add_todo);
        etToDo = findViewById(R.id.et_new_todo);
        spinner = findViewById(R.id.sp_category);
        saveButton.setOnClickListener(this);

        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(categoryAdapter);

        for (int i = 0; i < categories.length; i++) {
            categoryAdapter.add(categories[i]);
        }
    }

    @Override
    public void onClick(View view) {
        if(etToDo.getText().toString().trim().isEmpty()){
            showToast("Please enter a todo");
        }else{
            if (view.getId() == R.id.btn_add_todo) {
                Intent passData = new Intent();
                passData.putExtra(KEY_NEW_TODO, etToDo.getText().toString());
                passData.putExtra(KEY_NEW_CAT, spinner.getSelectedItem().toString());
                setResult(MainActivity.OPEN_CODE_ACTIVITY, passData);
                finish();//Terminate the activity
            }
        }
            
    }

    private void showToast(String please_enter_a_todo) {
        Toast.makeText(this, please_enter_a_todo, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addNewCreateCategory(String categoryName) {
        categoryAdapter.add(categoryName);
        Toast.makeText(this, "New Category: " + categoryName, Toast.LENGTH_SHORT).show();
    }
}
