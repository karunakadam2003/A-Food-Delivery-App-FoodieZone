package com.example.foodiezoneapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.foodiezoneapp.Adapter.CartListAdapter;
import com.example.foodiezoneapp.Helper.ManagementClass;
import com.example.foodiezoneapp.Interface.ChangeNumberItemsListener;
import com.example.foodiezoneapp.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementClass managementClass;
    private TextView totalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;
    private ScrollView scrollView;
    private ConstraintLayout checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementClass = new ManagementClass(this);
        initView();
        initList();
        calculateCard();
        bottomNavigation();

        checkoutButton = findViewById(R.id.checkoutBtn);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkout = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(checkout);
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
                Intent home = new Intent(CartActivity.this, MainActivity.class);
                startActivity(home);
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart = new Intent(CartActivity.this, CartActivity.class);
                startActivity(cart);
            }
        });

        bagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart = new Intent(CartActivity.this, CartActivity.class);
                startActivity(cart);
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementClass.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });
        recyclerViewList.setAdapter(adapter);
        if(managementClass.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentageTax = 0.02;
        double delivery = 5.2;
        double tax = Math.round((managementClass.getTotalFee()*percentageTax)*100.0)/100.0;
        double total = Math.round((managementClass.getTotalFee()+tax+delivery)*100.0)/100.0;
        double itemTotal = Math.round(managementClass.getTotalFee()*100.0)/100.0;
        totalFeeTxt.setText("$" + itemTotal);
        taxTxt.setText("$" + tax);
        deliveryTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt =findViewById(R.id.deliveryTxt);
        totalTxt  = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view);
        scrollView = findViewById(R.id.scrollView);
        emptyTxt  = findViewById(R.id.emptyTxt);
    }
}
