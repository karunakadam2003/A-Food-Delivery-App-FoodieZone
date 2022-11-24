package com.example.foodiezoneapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiezoneapp.Adapter.GridAdapter;
import com.example.foodiezoneapp.R;
import com.example.foodiezoneapp.databinding.ActivityHotdogBinding;

public class HotdogActivity extends AppCompatActivity {

    ActivityHotdogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotdogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] pizzaNames = {"Veggie Hotdog", "Simple Hotdog"};
        int[] pizzaImages = {R.drawable.hotdog1, R.drawable.hotdog2};

        GridAdapter gridAdapter = new GridAdapter(HotdogActivity.this, pizzaNames, pizzaImages);
        binding.gridView2.setAdapter(gridAdapter);
    }
}
