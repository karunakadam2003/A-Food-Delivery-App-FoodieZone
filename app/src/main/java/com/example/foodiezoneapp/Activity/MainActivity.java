package com.example.foodiezoneapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.foodiezoneapp.Adapter.CategoryAdapter;
import com.example.foodiezoneapp.Adapter.RecommendedAdapter;
import com.example.foodiezoneapp.Domain.CategoryDomain;
import com.example.foodiezoneapp.Domain.FoodDomain;

import com.example.foodiezoneapp.Interface.RecyclerViewInterface;
import com.example.foodiezoneapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView.Adapter adapter1,adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    // private CategoryAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();

        recyclerViewCategoryList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pizza = new Intent(MainActivity.this, PizzaActivity.class);
                startActivity(pizza);
            }
        });
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        ImageView bagBtn = findViewById(R.id.bagBtn);

        homeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent home = new Intent(MainActivity.this,MainActivity.class);
                startActivity(home);
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart = new Intent(MainActivity.this, CartActivity.class);
                startActivity(cart);
            }
        });

        bagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart = new Intent(MainActivity.this, CartActivity.class);
                startActivity(cart);
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.rvPopular);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> arrayFood = new ArrayList<>();
        arrayFood.add(new FoodDomain("Pepperoni pizza", "pop_1", "slices pepperoni,mozzerella cheese, fresh oregano, ground black pepper, pizza sauce", 8.76, 100, 4, 1000, 0));
        arrayFood.add(new FoodDomain("Jumbo Burger", "pop_2", "beef, Gouda Cheese, Special Sauce, Lettuce, tomato", 9.16, 100, 5, 900, 0));
        arrayFood.add(new FoodDomain("Vegetable pizza", "pop_3", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 10.76, 100, 5, 1200, 0));

        adapter2 = new RecommendedAdapter(arrayFood);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.rvCategories);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);


        ArrayList<CategoryDomain> arrayList = new ArrayList();
        arrayList.add(new CategoryDomain("Pizza","cat_1"));
        arrayList.add(new CategoryDomain("Burger","cat_2"));
        arrayList.add(new CategoryDomain("Hotdog","cat_3"));
        arrayList.add(new CategoryDomain("Drink","cat_4"));
        arrayList.add(new CategoryDomain("Donut","cat_5"));
        adapter1 = new CategoryAdapter(arrayList, this);
        recyclerViewCategoryList.setAdapter(adapter1);
    }

    @Override
    public void onClickItem(int position) {
        if(position == 0) {
            Intent pizza = new Intent(MainActivity.this, PizzaActivity.class);
            startActivity(pizza);
        }
        if(position == 1) {
            Intent burger = new Intent(MainActivity.this, BurgerActivity.class);
            startActivity(burger);
        }
        if(position == 2) {
            Intent hotdog = new Intent(MainActivity.this, HotdogActivity.class);
            startActivity(hotdog);
        }
        if(position == 3) {
            Intent drink = new Intent(MainActivity.this, DrinkActivity.class);
            startActivity(drink);
        }
        if(position == 4) {
            Intent donut = new Intent(MainActivity.this, DonutActivity.class);
            startActivity(donut);
        }
    }
}