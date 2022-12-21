package com.raj.pickeatup.breakfaststores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raj.pickeatup.R;
import com.raj.pickeatup.bakerystores.BakeryStores;
import com.raj.pickeatup.bakerystores.Bstore1;
import com.raj.pickeatup.bakerystores.Bstore10;
import com.raj.pickeatup.bakerystores.Bstore11;
import com.raj.pickeatup.bakerystores.Bstore12;
import com.raj.pickeatup.bakerystores.Bstore13;
import com.raj.pickeatup.bakerystores.Bstore14;
import com.raj.pickeatup.bakerystores.Bstore15;
import com.raj.pickeatup.bakerystores.Bstore16;
import com.raj.pickeatup.bakerystores.Bstore17;
import com.raj.pickeatup.bakerystores.Bstore18;
import com.raj.pickeatup.bakerystores.Bstore19;
import com.raj.pickeatup.bakerystores.Bstore2;
import com.raj.pickeatup.bakerystores.Bstore20;
import com.raj.pickeatup.bakerystores.Bstore3;
import com.raj.pickeatup.bakerystores.Bstore4;
import com.raj.pickeatup.bakerystores.Bstore5;
import com.raj.pickeatup.bakerystores.Bstore6;
import com.raj.pickeatup.bakerystores.Bstore7;
import com.raj.pickeatup.bakerystores.Bstore8;
import com.raj.pickeatup.bakerystores.Bstore9;

public class BreakfastStores extends AppCompatActivity {
    ImageView cstore1, cstore2, cstore3, cstore4, cstore5, cstore6, cstore7, cstore8, cstore9, cstore10, cstore11, cstore12, cstore13, cstore14, cstore15, cstore16, cstore17, cstore18, cstore19, cstore20;

    TextView cstorename1, cstorename2, cstorename3, cstorename4, cstorename5, cstorename6, cstorename7, cstorename8, cstorename9, cstorename10, cstorename11, cstorename12, cstorename13, cstorename14, cstorename15, cstorename16, cstorename17, cstorename18, cstorename19, cstorename20;

    TextView cstoreadress1, cstoreadress2, cstoreadress3, cstoreadress4, cstoreadress5, cstoreadress6, cstoreadress7, cstoreadress8, cstoreadress9, cstoreadress10, cstoreadress11, cstoreadress12, cstoreadress13, cstoreadress14, cstoreadress15, cstoreadress16, cstoreadress17, cstoreadress18, cstoreadress19, cstoreadress20;

    TextView cstoretime1, cstoretime2, cstoretime3, cstoretime4, cstoretime5, cstoretime6, cstoretime7, cstoretime8, cstoretime9, cstoretime10, cstoretime11, cstoretime12, cstoretime13, cstoretime14, cstoretime15, cstoretime16, cstoretime17, cstoretime18, cstoretime19, cstoretime20;
    DatabaseReference breakfaststoresref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_stores);

        cstore1 = findViewById(R.id.cstore1);
        cstore2 = findViewById(R.id.cstore2);
        cstore3 = findViewById(R.id.cstore3);
        cstore4 = findViewById(R.id.cstore4);
        cstore5 = findViewById(R.id.cstore5);
        cstore6 = findViewById(R.id.cstore6);
        cstore7 = findViewById(R.id.cstore7);
        cstore8 = findViewById(R.id.cstore8);
        cstore9 = findViewById(R.id.cstore9);
        cstore10 = findViewById(R.id.cstore10);
        cstore11 = findViewById(R.id.cstore11);
        cstore12 = findViewById(R.id.cstore12);
        cstore13 = findViewById(R.id.cstore13);
        cstore14 = findViewById(R.id.cstore14);
        cstore15 = findViewById(R.id.cstore15);
        cstore16 = findViewById(R.id.cstore16);
        cstore17 = findViewById(R.id.cstore17);
        cstore18 = findViewById(R.id.cstore18);
        cstore19 = findViewById(R.id.cstore19);
        cstore20 = findViewById(R.id.cstore20);

        cstorename1 = findViewById(R.id.cstorename1);
        cstorename2 = findViewById(R.id.cstorename2);
        cstorename3 = findViewById(R.id.cstorename3);
        cstorename4 = findViewById(R.id.cstorename4);
        cstorename5 = findViewById(R.id.cstorename5);
        cstorename6 = findViewById(R.id.cstorename6);
        cstorename7 = findViewById(R.id.cstorename7);
        cstorename8 = findViewById(R.id.cstorename8);
        cstorename9 = findViewById(R.id.cstorename9);
        cstorename10 = findViewById(R.id.cstorename10);
        cstorename11 = findViewById(R.id.cstorename11);
        cstorename12 = findViewById(R.id.cstorename12);
        cstorename13 = findViewById(R.id.cstorename13);
        cstorename14 = findViewById(R.id.cstorename14);
        cstorename15 = findViewById(R.id.cstorename15);
        cstorename16 = findViewById(R.id.cstorename16);
        cstorename17 = findViewById(R.id.cstorename17);
        cstorename18 = findViewById(R.id.cstorename18);
        cstorename19 = findViewById(R.id.cstorename19);
        cstorename20 = findViewById(R.id.cstorename20);

        cstoreadress1 = findViewById(R.id.cstoreadress1);
        cstoreadress2 = findViewById(R.id.cstoreadress2);
        cstoreadress3 = findViewById(R.id.cstoreadress3);
        cstoreadress4 = findViewById(R.id.cstoreadress4);
        cstoreadress5 = findViewById(R.id.cstoreadress5);
        cstoreadress6 = findViewById(R.id.cstoreadress6);
        cstoreadress7 = findViewById(R.id.cstoreadress7);
        cstoreadress8 = findViewById(R.id.cstoreadress8);
        cstoreadress9 = findViewById(R.id.cstoreadress9);
        cstoreadress10 = findViewById(R.id.cstoreadress10);
        cstoreadress11 = findViewById(R.id.cstoreadress11);
        cstoreadress12 = findViewById(R.id.cstoreadress12);
        cstoreadress13 = findViewById(R.id.cstoreadress13);
        cstoreadress14 = findViewById(R.id.cstoreadress14);
        cstoreadress15 = findViewById(R.id.cstoreadress15);
        cstoreadress16 = findViewById(R.id.cstoreadress16);
        cstoreadress17 = findViewById(R.id.cstoreadress17);
        cstoreadress18 = findViewById(R.id.cstoreadress18);
        cstoreadress19 = findViewById(R.id.cstoreadress19);
        cstoreadress20 = findViewById(R.id.cstoreadress20);


        cstoretime1 = findViewById(R.id.cstoretime1);
        cstoretime2 = findViewById(R.id.cstoretime2);
        cstoretime3 = findViewById(R.id.cstoretime3);
        cstoretime4 = findViewById(R.id.cstoretime4);
        cstoretime5 = findViewById(R.id.cstoretime5);
        cstoretime6 = findViewById(R.id.cstoretime6);
        cstoretime7 = findViewById(R.id.cstoretime7);
        cstoretime8 = findViewById(R.id.cstoretime8);
        cstoretime9 = findViewById(R.id.cstoretime9);
        cstoretime10 = findViewById(R.id.cstoretime10);
        cstoretime11 = findViewById(R.id.cstoretime11);
        cstoretime12 = findViewById(R.id.cstoretime12);
        cstoretime13 = findViewById(R.id.cstoretime13);
        cstoretime14 = findViewById(R.id.cstoretime14);
        cstoretime15 = findViewById(R.id.cstoretime15);
        cstoretime16 = findViewById(R.id.cstoretime16);
        cstoretime17 = findViewById(R.id.cstoretime17);
        cstoretime18 = findViewById(R.id.cstoretime18);
        cstoretime19 = findViewById(R.id.cstoretime19);
        cstoretime20 = findViewById(R.id.cstoretime20);


        breakfaststoresref = FirebaseDatabase.getInstance().getReference().child("stores").child("breakfaststore");

        breakfaststoresref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String bstorepic1 = snapshot.child("cstore1").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic1).into(cstore1);


                String bstorepic2 = snapshot.child("cstore2").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic2).into(cstore2);


                String bstorepic3 = snapshot.child("cstore3").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic3).into(cstore3);


                String bstorepic4 = snapshot.child("cstore4").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic4).into(cstore4);


                String bstorepic5 = snapshot.child("cstore5").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic5).into(cstore5);


                String bstorepic6 = snapshot.child("cstore6").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic6).into(cstore6);


                String bstorepic7 = snapshot.child("cstore7").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic7).into(cstore7);

                String bstorepic8 = snapshot.child("cstore8").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic8).into(cstore8);


                String bstorepic9 = snapshot.child("cstore9").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic9).into(cstore9);


                String bstorepic10 = snapshot.child("cstore10").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic10).into(cstore10);


                String bstorepic11 = snapshot.child("cstore11").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic11).into(cstore11);


                String bstorepic12 = snapshot.child("cstore12").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic12).into(cstore12);


                String bstorepic13 = snapshot.child("cstore13").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic13).into(cstore13);

                String bstorepic14 = snapshot.child("cstore14").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic14).into(cstore14);


                String bstorepic15 = snapshot.child("cstore15").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic15).into(cstore15);


                String bstorepic16 = snapshot.child("cstore16").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic16).into(cstore16);


                String bstorepic17 = snapshot.child("cstore17").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic17).into(cstore17);


                String bstorepic18 = snapshot.child("cstore18").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic18).into(cstore18);


                String bstorepic19 = snapshot.child("cstore19").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic19).into(cstore19);


                String bstorepic20 = snapshot.child("cstore20").child("photo").getValue().toString();

                Glide.with(BreakfastStores.this).load(bstorepic20).into(cstore20);


                final String bstorename_1 = snapshot.child("cstore1").child("name").getValue().toString();
                final String bstorename_2 = snapshot.child("cstore2").child("name").getValue().toString();
                final String bstorename_3 = snapshot.child("cstore3").child("name").getValue().toString();
                final String bstorename_4 = snapshot.child("cstore4").child("name").getValue().toString();
                final String bstorename_5 = snapshot.child("cstore5").child("name").getValue().toString();
                final String bstorename_6 = snapshot.child("cstore6").child("name").getValue().toString();
                final String bstorename_7 = snapshot.child("cstore7").child("name").getValue().toString();
                final String bstorename_8 = snapshot.child("cstore8").child("name").getValue().toString();
                final String bstorename_9 = snapshot.child("cstore9").child("name").getValue().toString();
                final String bstorename_10 = snapshot.child("cstore10").child("name").getValue().toString();
                final String bstorename_11 = snapshot.child("cstore11").child("name").getValue().toString();
                final String bstorename_12 = snapshot.child("cstore12").child("name").getValue().toString();
                final String bstorename_13 = snapshot.child("cstore13").child("name").getValue().toString();
                final String bstorename_14 = snapshot.child("cstore14").child("name").getValue().toString();
                final String bstorename_15 = snapshot.child("cstore15").child("name").getValue().toString();
                final String bstorename_16 = snapshot.child("cstore16").child("name").getValue().toString();
                final String bstorename_17 = snapshot.child("cstore17").child("name").getValue().toString();
                final String bstorename_18 = snapshot.child("cstore18").child("name").getValue().toString();
                final String bstorename_19 = snapshot.child("cstore19").child("name").getValue().toString();
                final String bstorename_20 = snapshot.child("cstore20").child("name").getValue().toString();


                final String bstoreaddress_1 = snapshot.child("cstore1").child("adress").getValue().toString();
                final String bstoreaddress_2 = snapshot.child("cstore2").child("adress").getValue().toString();
                final String bstoreaddress_3 = snapshot.child("cstore3").child("adress").getValue().toString();
                final String bstoreaddress_4 = snapshot.child("cstore4").child("adress").getValue().toString();
                final String bstoreaddress_5 = snapshot.child("cstore5").child("adress").getValue().toString();
                final String bstoreaddress_6 = snapshot.child("cstore6").child("adress").getValue().toString();
                final String bstoreaddress_7 = snapshot.child("cstore7").child("adress").getValue().toString();
                final String bstoreaddress_8 = snapshot.child("cstore8").child("adress").getValue().toString();
                final String bstoreaddress_9 = snapshot.child("cstore9").child("adress").getValue().toString();
                final String bstoreaddress_10 = snapshot.child("cstore10").child("adress").getValue().toString();
                final String bstoreaddress_11 = snapshot.child("cstore11").child("adress").getValue().toString();
                final String bstoreaddress_12 = snapshot.child("cstore12").child("adress").getValue().toString();
                final String bstoreaddress_13 = snapshot.child("cstore13").child("adress").getValue().toString();
                final String bstoreaddress_14 = snapshot.child("cstore14").child("adress").getValue().toString();
                final String bstoreaddress_15 = snapshot.child("cstore15").child("adress").getValue().toString();
                final String bstoreaddress_16 = snapshot.child("cstore16").child("adress").getValue().toString();
                final String bstoreaddress_17 = snapshot.child("cstore17").child("adress").getValue().toString();
                final String bstoreaddress_18 = snapshot.child("cstore18").child("adress").getValue().toString();
                final String bstoreaddress_19 = snapshot.child("cstore19").child("adress").getValue().toString();
                final String bstoreaddress_20 = snapshot.child("cstore20").child("adress").getValue().toString();

                final String bstoretime_1 = snapshot.child("cstore1").child("time").getValue().toString();
                final String bstoretime_2 = snapshot.child("cstore2").child("time").getValue().toString();
                final String bstoretime_3 = snapshot.child("cstore3").child("time").getValue().toString();
                final String bstoretime_4 = snapshot.child("cstore4").child("time").getValue().toString();
                final String bstoretime_5 = snapshot.child("cstore5").child("time").getValue().toString();
                final String bstoretime_6 = snapshot.child("cstore6").child("time").getValue().toString();
                final String bstoretime_7 = snapshot.child("cstore7").child("time").getValue().toString();
                final String bstoretime_8 = snapshot.child("cstore8").child("time").getValue().toString();
                final String bstoretime_9 = snapshot.child("cstore9").child("time").getValue().toString();
                final String bstoretime_10 = snapshot.child("cstore10").child("time").getValue().toString();
                final String bstoretime_11 = snapshot.child("cstore11").child("time").getValue().toString();
                final String bstoretime_12 = snapshot.child("cstore12").child("time").getValue().toString();
                final String bstoretime_13 = snapshot.child("cstore13").child("time").getValue().toString();
                final String bstoretime_14 = snapshot.child("cstore14").child("time").getValue().toString();
                final String bstoretime_15 = snapshot.child("cstore15").child("time").getValue().toString();
                final String bstoretime_16 = snapshot.child("cstore16").child("time").getValue().toString();
                final String bstoretime_17 = snapshot.child("cstore17").child("time").getValue().toString();
                final String bstoretime_18 = snapshot.child("cstore18").child("time").getValue().toString();
                final String bstoretime_19 = snapshot.child("cstore19").child("time").getValue().toString();
                final String bstoretime_20 = snapshot.child("cstore20").child("time").getValue().toString();


                cstorename1.setText(bstorename_1);
                cstorename2.setText(bstorename_2);
                cstorename3.setText(bstorename_3);
                cstorename4.setText(bstorename_4);
                cstorename5.setText(bstorename_5);
                cstorename6.setText(bstorename_6);
                cstorename7.setText(bstorename_7);
                cstorename8.setText(bstorename_8);
                cstorename9.setText(bstorename_9);
                cstorename10.setText(bstorename_10);
                cstorename11.setText(bstorename_11);
                cstorename12.setText(bstorename_12);
                cstorename13.setText(bstorename_13);
                cstorename14.setText(bstorename_14);
                cstorename15.setText(bstorename_15);
                cstorename16.setText(bstorename_16);
                cstorename17.setText(bstorename_17);
                cstorename18.setText(bstorename_18);
                cstorename19.setText(bstorename_19);
                cstorename20.setText(bstorename_20);


                cstoreadress1.setText(bstoreaddress_1);
                cstoreadress2.setText(bstoreaddress_2);
                cstoreadress3.setText(bstoreaddress_3);
                cstoreadress4.setText(bstoreaddress_4);
                cstoreadress5.setText(bstoreaddress_5);
                cstoreadress6.setText(bstoreaddress_6);
                cstoreadress7.setText(bstoreaddress_7);
                cstoreadress8.setText(bstoreaddress_8);
                cstoreadress9.setText(bstoreaddress_9);
                cstoreadress10.setText(bstoreaddress_10);
                cstoreadress11.setText(bstoreaddress_11);
                cstoreadress12.setText(bstoreaddress_12);
                cstoreadress13.setText(bstoreaddress_13);
                cstoreadress14.setText(bstoreaddress_14);
                cstoreadress15.setText(bstoreaddress_15);
                cstoreadress16.setText(bstoreaddress_16);
                cstoreadress17.setText(bstoreaddress_17);
                cstoreadress18.setText(bstoreaddress_18);
                cstoreadress19.setText(bstoreaddress_19);
                cstoreadress20.setText(bstoreaddress_20);


                cstoretime1.setText(bstoretime_1);
                cstoretime2.setText(bstoretime_2);
                cstoretime3.setText(bstoretime_3);
                cstoretime4.setText(bstoretime_4);
                cstoretime5.setText(bstoretime_5);
                cstoretime6.setText(bstoretime_6);
                cstoretime7.setText(bstoretime_7);
                cstoretime8.setText(bstoretime_8);
                cstoretime9.setText(bstoretime_9);
                cstoretime10.setText(bstoretime_10);
                cstoretime11.setText(bstoretime_11);
                cstoretime12.setText(bstoretime_12);
                cstoretime13.setText(bstoretime_13);
                cstoretime14.setText(bstoretime_14);
                cstoretime15.setText(bstoretime_15);
                cstoretime16.setText(bstoretime_16);
                cstoretime17.setText(bstoretime_17);
                cstoretime18.setText(bstoretime_18);
                cstoretime19.setText(bstoretime_19);
                cstoretime20.setText(bstoretime_20);


                DatabaseReference shopavailablityref=FirebaseDatabase.getInstance().getReference().child("adminview").child("Deliverycharge").child("shopavailability");

                shopavailablityref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot snapshot2) {


                        cstore1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore1").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore1.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_1);


                                    i.putExtra("bstorename_1", bstorename_1);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_1);
                                    i.putExtra("storeid", "cstore1");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore2").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore2.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_2);


                                    i.putExtra("bstorename_1", bstorename_2);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_2);
                                    i.putExtra("storeid", "cstore2");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore3").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore3.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_3);


                                    i.putExtra("bstorename_1", bstorename_3);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_3);
                                    i.putExtra("storeid", "cstore3");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore4").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore4.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_4);


                                    i.putExtra("bstorename_1", bstorename_4);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_4);
                                    i.putExtra("storeid", "cstore4");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore5").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore5.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_5);


                                    i.putExtra("bstorename_1", bstorename_5);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_5);
                                    i.putExtra("storeid", "cstore5");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore6").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore6.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_6);


                                    i.putExtra("bstorename_1", bstorename_6);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_6);
                                    i.putExtra("storeid", "cstore6");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore7").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore7.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_7);


                                    i.putExtra("bstorename_1", bstorename_7);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_7);
                                    i.putExtra("storeid", "cstore7");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore8").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore8.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_8);


                                    i.putExtra("bstorename_1", bstorename_8);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_8);
                                    i.putExtra("storeid", "cstore8");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore9").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore9.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_9);


                                    i.putExtra("bstorename_1", bstorename_9);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_9);
                                    i.putExtra("storeid", "cstore9");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore10").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore10.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_10);


                                    i.putExtra("bstorename_1", bstorename_10);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_10);
                                    i.putExtra("storeid", "cstore10");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore11").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore11.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_11);


                                    i.putExtra("bstorename_1", bstorename_11);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_11);
                                    i.putExtra("storeid", "cstore11");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore12").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore12.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_12);


                                    i.putExtra("bstorename_1", bstorename_12);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_12);
                                    i.putExtra("storeid", "cstore12");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore13").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore13.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_13);


                                    i.putExtra("bstorename_1", bstorename_13);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_13);
                                    i.putExtra("storeid", "cstore13");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore14").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {
                                    Intent i = new Intent(BreakfastStores.this, Cstore14.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_14);


                                    i.putExtra("bstorename_1", bstorename_14);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_14);
                                    i.putExtra("storeid", "bstore14");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore15").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore15.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_15);


                                    i.putExtra("bstorename_1", bstorename_15);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_15);
                                    i.putExtra("storeid", "cstore15");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore16").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore16.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_15);


                                    i.putExtra("bstorename_1", bstorename_16);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_16);
                                    i.putExtra("storeid", "cstore16");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);

                                }
                            }
                        });


                        cstore17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore17").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore17.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_17);


                                    i.putExtra("bstorename_1", bstorename_17);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_17);
                                    i.putExtra("storeid", "cstore17");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore18").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore18.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_18);


                                    i.putExtra("bstorename_1", bstorename_18);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_18);
                                    i.putExtra("storeid", "cstore18");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore19").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore19.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_19);


                                    i.putExtra("bstorename_1", bstorename_19);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_19);
                                    i.putExtra("storeid", "cstore19");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });


                        cstore20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (snapshot2.child("cstore20").exists()){



                                    Toast.makeText(BreakfastStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                                }

                                else {

                                    Intent i = new Intent(BreakfastStores.this, Cstore20.class);
                                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                                    i.putExtra("otpverifiednumber", otpverifiednumber);
                                    i.putExtra("bstoretime_1", bstoretime_20);


                                    i.putExtra("bstorename_1", bstorename_20);
                                    i.putExtra("bstoreaddress_1", bstoreaddress_20);
                                    i.putExtra("storeid", "cstore20");
                                    i.putExtra("category", "breakfaststores");


                                    startActivity(i);
                                }
                            }
                        });









                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
 //            Toast.makeText(Welcome.this, "Please check your mobile Internet connection and try again.", Toast.LENGTH_SHORT).show();
//
            }
        });
    }

}
