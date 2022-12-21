package com.raj.pickeatup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GroceryStores extends AppCompatActivity {
    ImageView ivvishwa, iv2, iv3,iv4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grocery_stores);

        ivvishwa=findViewById(R.id.ivvishwa);


        ivvishwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number= getIntent().getStringExtra("number");
                Intent i = new Intent(GroceryStores.this,Vishwa.class);
                i.putExtra("number",number);

                startActivity(i);
            }
        });

        iv2=findViewById(R.id.iv2);

//        Glide.with(GroceryStores.this).load("").into(ivvishwa);

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GroceryStores.this,Vishwa.class);

                startActivity(i);
            }
        });

        iv3=findViewById(R.id.iv3);

//        Glide.with(GroceryStores.this).load("").into(ivvishwa);

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GroceryStores.this,Vishwa.class);

                startActivity(i);
            }
        });

//        iv4=findViewById(R.id.iv4);
//
////        Glide.with(GroceryStores.this).load("").into(ivvishwa);
//
//
//
//        iv4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(GroceryStores.this,Vishwa.class);
//
//                startActivity(i);
//            }
//        });
//












    }
}