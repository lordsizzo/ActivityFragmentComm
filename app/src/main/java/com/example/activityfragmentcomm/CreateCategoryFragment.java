package com.example.activityfragmentcomm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class CreateCategoryFragment extends Fragment {

    private EditText et_category_name;
    private Button btn_create_category;

    public interface CreateCategoryListener {
        void addNewCreateCategory(String categoryName);
    }

    private CreateCategoryListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof CreateCategoryListener) {
            listener = (CreateCategoryListener) context;
        }else {
            throw new IllegalArgumentException("Context must implement CreateCategoryListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        final View rootView = inflater.inflate(R.layout.create_fragment_category,
                container, false);
        initViews(rootView);
        return rootView;
    }

    private void initViews(View rootView) {
        et_category_name = rootView.findViewById(R.id.et_create_category);
        btn_create_category = rootView.findViewById(R.id.btn_create_category);

        btn_create_category.setOnClickListener((__) -> {
                String categoryName = et_category_name.getText().toString();
                if (!categoryName.isEmpty()) {
                    listener.addNewCreateCategory(categoryName);
                }
        });
    }
}
