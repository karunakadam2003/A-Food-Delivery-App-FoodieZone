package com.example.foodiezoneapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiezoneapp.Adapter.GridAdapter;
import com.example.foodiezoneapp.R;
import com.example.foodiezoneapp.databinding.ActivityDonutBinding;

public class DonutActivity extends AppCompatActivity {

    ActivityDonutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDonutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] pizzaNames = {"Strawberry Cream Donut", "Choco-Chip Donut", "Butterscotch Crunch Donut"};
        int[] pizzaImages = {R.drawable.donut1, R.drawable.donut2, R.drawable.donut3};

        GridAdapter gridAdapter = new GridAdapter(DonutActivity.this, pizzaNames, pizzaImages);
        binding.gridView4.setAdapter(gridAdapter);
    }
}
