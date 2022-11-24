package com.example.foodiezoneapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiezoneapp.Adapter.GridAdapter;
import com.example.foodiezoneapp.R;
import com.example.foodiezoneapp.databinding.ActivityDrinkBinding;

public class DrinkActivity extends AppCompatActivity {

    ActivityDrinkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrinkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] pizzaNames = {"Blue Lagoon", "Tropical Drink", "Lime Mocktail", "Watermelon Crush"};
        int[] pizzaImages = {R.drawable.drink1, R.drawable.drink2, R.drawable.drink3, R.drawable.drink4};

        GridAdapter gridAdapter = new GridAdapter(DrinkActivity.this, pizzaNames, pizzaImages);
        binding.gridView3.setAdapter(gridAdapter);
    }
}
