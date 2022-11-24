package com.example.foodiezoneapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodiezoneapp.Domain.FoodDomain;
import com.example.foodiezoneapp.Helper.ManagementClass;
import com.example.foodiezoneapp.R;

public class ShowDetails extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView titleTxt,feeTxt,numberOrderTxt,totalPriceTxt;
    private ImageView plusBtn, minusBtn, imgFood;
    private FoodDomain object;
    private ManagementClass managementClass;
    private int numberOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        managementClass = new ManagementClass(this);
        iniView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        // System.out.println("PIC URL" + object.getPic());
        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(imgFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$" + object.getFee());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        totalPriceTxt.setText("$" + numberOrder * object.getFee());

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder<10) {
                    numberOrder = numberOrder + 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$" + numberOrder * object.getFee());
            }

        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$" + numberOrder * object.getFee());

            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementClass.insertFood(object);
            }
        });
    }
    private void iniView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.feeTxt);
        numberOrderTxt=findViewById(R.id.numberItemTxt);
        plusBtn=findViewById(R.id.plusCardBtn);
        minusBtn=findViewById(R.id.minusCardBtn);
        imgFood = findViewById(R.id.imgFood);
        totalPriceTxt=findViewById(R.id.totalPrice);
    }
}