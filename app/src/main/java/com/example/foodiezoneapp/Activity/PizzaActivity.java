package com.example.foodiezoneapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiezoneapp.Adapter.GridAdapter;
import com.example.foodiezoneapp.R;
import com.example.foodiezoneapp.databinding.ActivityPizzaBinding;

public class PizzaActivity extends AppCompatActivity {

    ActivityPizzaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPizzaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // setContentView(R.layout.activity_pizza);

        String[] pizzaNames = {"Pepperoni Pizza", "Vegetable Pizza", "Mushroom Pizza", "Margherita Pizza"};
        int[] pizzaImages = {R.drawable.pop_1, R.drawable.pop_3, R.drawable.pizza1, R.drawable.pizza2};

        GridAdapter gridAdapter = new GridAdapter(PizzaActivity.this, pizzaNames, pizzaImages);
        binding.gridView.setAdapter(gridAdapter);
    }
}