package com.example.foodiezoneapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiezoneapp.Adapter.GridAdapter;
import com.example.foodiezoneapp.R;
import com.example.foodiezoneapp.databinding.ActivityBurgerBinding;

public class BurgerActivity extends AppCompatActivity {

    ActivityBurgerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBurgerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // setContentView(R.layout.activity_burger);

        String[] pizzaNames = {"Jumbo Burger", "Veggie Burger", "Aloo Tikki Burger"};
        int[] pizzaImages = {R.drawable.pop_2, R.drawable.burger1, R.drawable.burger2};

        GridAdapter gridAdapter = new GridAdapter(BurgerActivity.this, pizzaNames, pizzaImages);
        binding.gridView1.setAdapter(gridAdapter);
    }
}