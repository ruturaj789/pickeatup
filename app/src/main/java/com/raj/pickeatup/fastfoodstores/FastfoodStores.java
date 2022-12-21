package com.raj.pickeatup.fastfoodstores;

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
import com.raj.pickeatup.breakfaststores.BreakfastStores;

public class FastfoodStores extends AppCompatActivity {
    ImageView bstore1,bstore2,bstore3,bstore4,bstore5,bstore6,bstore7,bstore8,bstore9,bstore10,bstore11,bstore12,bstore13,bstore14,bstore15,bstore16,bstore17,bstore18,bstore19,bstore20;

    TextView bstorename1,bstorename2,bstorename3,bstorename4,bstorename5,bstorename6,bstorename7,bstorename8,bstorename9,bstorename10,bstorename11,bstorename12,bstorename13,bstorename14,bstorename15,bstorename16,bstorename17,bstorename18,bstorename19,bstorename20;

    TextView bstoreadress1,bstoreadress2,bstoreadress3,bstoreadress4,bstoreadress5,bstoreadress6,bstoreadress7,bstoreadress8,bstoreadress9,bstoreadress10,bstoreadress11,bstoreadress12,bstoreadress13,bstoreadress14,bstoreadress15,bstoreadress16,bstoreadress17,bstoreadress18,bstoreadress19,bstoreadress20;

    TextView bstoretime1,bstoretime2,bstoretime3,bstoretime4,bstoretime5,bstoretime6,bstoretime7,bstoretime8,bstoretime9,bstoretime10,bstoretime11,bstoretime12,bstoretime13,bstoretime14,bstoretime15,bstoretime16,bstoretime17,bstoretime18,bstoretime19,bstoretime20;
    DatabaseReference bakerystoreref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastfood_stores);

        bstore1=findViewById(R.id.dstore1);
        bstore2=findViewById(R.id.dstore2);
        bstore3=findViewById(R.id.dstore3);
        bstore4=findViewById(R.id.dstore4);
        bstore5=findViewById(R.id.dstore5);
        bstore6=findViewById(R.id.dstore6);
        bstore7=findViewById(R.id.dstore7);
        bstore8=findViewById(R.id.dstore8);
        bstore9=findViewById(R.id.dstore9);
        bstore10=findViewById(R.id.dstore10);
        bstore11=findViewById(R.id.dstore11);
        bstore12=findViewById(R.id.dstore12);
        bstore13=findViewById(R.id.dstore13);
        bstore14=findViewById(R.id.dstore14);
        bstore15=findViewById(R.id.dstore15);
        bstore16=findViewById(R.id.dstore16);
        bstore17=findViewById(R.id.dstore17);
        bstore18=findViewById(R.id.dstore18);
        bstore19=findViewById(R.id.dstore19);
        bstore20=findViewById(R.id.dstore20);

        bstorename1=findViewById(R.id.dstorename1);
        bstorename2=findViewById(R.id.dstorename2);
        bstorename3=findViewById(R.id.dstorename3);
        bstorename4=findViewById(R.id.dstorename4);
        bstorename5=findViewById(R.id.dstorename5);
        bstorename6=findViewById(R.id.dstorename6);
        bstorename7=findViewById(R.id.dstorename7);
        bstorename8=findViewById(R.id.dstorename8);
        bstorename9=findViewById(R.id.dstorename9);
        bstorename10=findViewById(R.id.dstorename10);
        bstorename11=findViewById(R.id.dstorename11);
        bstorename12=findViewById(R.id.dstorename12);
        bstorename13=findViewById(R.id.dstorename13);
        bstorename14=findViewById(R.id.dstorename14);
        bstorename15=findViewById(R.id.dstorename15);
        bstorename16=findViewById(R.id.dstorename16);
        bstorename17=findViewById(R.id.dstorename17);
        bstorename18=findViewById(R.id.dstorename18);
        bstorename19=findViewById(R.id.dstorename19);
        bstorename20=findViewById(R.id.dstorename20);

        bstoreadress1=findViewById(R.id.dstoreadress1);
        bstoreadress2=findViewById(R.id.dstoreadress2);
        bstoreadress3=findViewById(R.id.dstoreadress3);
        bstoreadress4=findViewById(R.id.dstoreadress4);
        bstoreadress5=findViewById(R.id.dstoreadress5);
        bstoreadress6=findViewById(R.id.dstoreadress6);
        bstoreadress7=findViewById(R.id.dstoreadress7);
        bstoreadress8=findViewById(R.id.dstoreadress8);
        bstoreadress9=findViewById(R.id.dstoreadress9);
        bstoreadress10=findViewById(R.id.dstoreadress10);
        bstoreadress11=findViewById(R.id.dstoreadress11);
        bstoreadress12=findViewById(R.id.dstoreadress12);
        bstoreadress13=findViewById(R.id.dstoreadress13);
        bstoreadress14=findViewById(R.id.dstoreadress14);
        bstoreadress15=findViewById(R.id.dstoreadress15);
        bstoreadress16=findViewById(R.id.dstoreadress16);
        bstoreadress17=findViewById(R.id.dstoreadress17);
        bstoreadress18=findViewById(R.id.dstoreadress18);
        bstoreadress19=findViewById(R.id.dstoreadress19);
        bstoreadress20=findViewById(R.id.dstoreadress20);


        bstoretime1=findViewById(R.id.dstoretime1);
        bstoretime2=findViewById(R.id.dstoretime2);
        bstoretime3=findViewById(R.id.dstoretime3);
        bstoretime4=findViewById(R.id.dstoretime4);
        bstoretime5=findViewById(R.id.dstoretime5);
        bstoretime6=findViewById(R.id.dstoretime6);
        bstoretime7=findViewById(R.id.dstoretime7);
        bstoretime8=findViewById(R.id.dstoretime8);
        bstoretime9=findViewById(R.id.dstoretime9);
        bstoretime10=findViewById(R.id.dstoretime10);
        bstoretime11=findViewById(R.id.dstoretime11);
        bstoretime12=findViewById(R.id.dstoretime12);
        bstoretime13=findViewById(R.id.dstoretime13);
        bstoretime14=findViewById(R.id.dstoretime14);
        bstoretime15=findViewById(R.id.dstoretime15);
        bstoretime16=findViewById(R.id.dstoretime16);
        bstoretime17=findViewById(R.id.dstoretime17);
        bstoretime18=findViewById(R.id.dstoretime18);
        bstoretime19=findViewById(R.id.dstoretime19);
        bstoretime20=findViewById(R.id.dstoretime20);












        bakerystoreref= FirebaseDatabase.getInstance().getReference().child("stores").child("fastfoodstore");

        bakerystoreref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String bstorepic1 = snapshot.child("dstore1").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic1).into(bstore1);


                String bstorepic2 = snapshot.child("dstore2").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic2).into(bstore2);



                String bstorepic3 = snapshot.child("dstore3").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic3).into(bstore3);


                String bstorepic4 = snapshot.child("dstore4").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic4).into(bstore4);


                String bstorepic5 = snapshot.child("dstore5").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic5).into(bstore5);


                String bstorepic6 = snapshot.child("dstore6").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic6).into(bstore6);


                String bstorepic7 = snapshot.child("dstore7").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic7).into(bstore7);

                String bstorepic8 = snapshot.child("dstore8").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic8).into(bstore8);


                String bstorepic9 = snapshot.child("dstore9").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic9).into(bstore9);


                String bstorepic10 = snapshot.child("dstore10").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic10).into(bstore10);


                String bstorepic11 = snapshot.child("dstore11").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic11).into(bstore11);


                String bstorepic12 = snapshot.child("dstore12").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic12).into(bstore12);


                String bstorepic13 = snapshot.child("dstore13").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic13).into(bstore13);

                String bstorepic14 = snapshot.child("dstore14").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic14).into(bstore14);


                String bstorepic15 = snapshot.child("dstore15").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic15).into(bstore15);


                String bstorepic16 = snapshot.child("dstore16").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic16).into(bstore16);


                String bstorepic17 = snapshot.child("dstore17").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic17).into(bstore17);


                String bstorepic18 = snapshot.child("dstore18").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic18).into(bstore18);


                String bstorepic19 = snapshot.child("dstore19").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic19).into(bstore19);


                String bstorepic20 = snapshot.child("dstore20").child("photo").getValue().toString();

                Glide.with(FastfoodStores.this).load(bstorepic20).into(bstore20);





                final String bstorename_1=snapshot.child("dstore1").child("name").getValue().toString();
                final String bstorename_2=snapshot.child("dstore2").child("name").getValue().toString();
                final String bstorename_3=snapshot.child("dstore3").child("name").getValue().toString();
                final String bstorename_4=snapshot.child("dstore4").child("name").getValue().toString();
                final String bstorename_5=snapshot.child("dstore5").child("name").getValue().toString();
                final String bstorename_6=snapshot.child("dstore6").child("name").getValue().toString();
                final String bstorename_7=snapshot.child("dstore7").child("name").getValue().toString();
                final String bstorename_8=snapshot.child("dstore8").child("name").getValue().toString();
                final String bstorename_9=snapshot.child("dstore9").child("name").getValue().toString();
                final String bstorename_10=snapshot.child("dstore10").child("name").getValue().toString();
                final String bstorename_11=snapshot.child("dstore11").child("name").getValue().toString();
                final String bstorename_12=snapshot.child("dstore12").child("name").getValue().toString();
                final String bstorename_13=snapshot.child("dstore13").child("name").getValue().toString();
                final String bstorename_14=snapshot.child("dstore14").child("name").getValue().toString();
                final String bstorename_15=snapshot.child("dstore15").child("name").getValue().toString();
                final String bstorename_16=snapshot.child("dstore16").child("name").getValue().toString();
                final String bstorename_17=snapshot.child("dstore17").child("name").getValue().toString();
                final String bstorename_18=snapshot.child("dstore18").child("name").getValue().toString();
                final String bstorename_19=snapshot.child("dstore19").child("name").getValue().toString();
                final String bstorename_20=snapshot.child("dstore20").child("name").getValue().toString();



                final String bstoreaddress_1=snapshot.child("dstore1").child("adress").getValue().toString();
                final String bstoreaddress_2=snapshot.child("dstore2").child("adress").getValue().toString();
                final String bstoreaddress_3=snapshot.child("dstore3").child("adress").getValue().toString();
                final String bstoreaddress_4=snapshot.child("dstore4").child("adress").getValue().toString();
                final String bstoreaddress_5=snapshot.child("dstore5").child("adress").getValue().toString();
                final String bstoreaddress_6=snapshot.child("dstore6").child("adress").getValue().toString();
                final String bstoreaddress_7=snapshot.child("dstore7").child("adress").getValue().toString();
                final String bstoreaddress_8=snapshot.child("dstore8").child("adress").getValue().toString();
                final String bstoreaddress_9=snapshot.child("dstore9").child("adress").getValue().toString();
                final String bstoreaddress_10=snapshot.child("dstore10").child("adress").getValue().toString();
                final String bstoreaddress_11=snapshot.child("dstore11").child("adress").getValue().toString();
                final String bstoreaddress_12=snapshot.child("dstore12").child("adress").getValue().toString();
                final String bstoreaddress_13=snapshot.child("dstore13").child("adress").getValue().toString();
                final String bstoreaddress_14=snapshot.child("dstore14").child("adress").getValue().toString();
                final String bstoreaddress_15=snapshot.child("dstore15").child("adress").getValue().toString();
                final String bstoreaddress_16=snapshot.child("dstore16").child("adress").getValue().toString();
                final String bstoreaddress_17=snapshot.child("dstore17").child("adress").getValue().toString();
                final String bstoreaddress_18=snapshot.child("dstore18").child("adress").getValue().toString();
                final String bstoreaddress_19=snapshot.child("dstore19").child("adress").getValue().toString();
                final String bstoreaddress_20=snapshot.child("dstore20").child("adress").getValue().toString();

                final String bstoretime_1=snapshot.child("dstore1").child("time").getValue().toString();
                final String bstoretime_2=snapshot.child("dstore2").child("time").getValue().toString();
                final String bstoretime_3=snapshot.child("dstore3").child("time").getValue().toString();
                final String bstoretime_4=snapshot.child("dstore4").child("time").getValue().toString();
                final String bstoretime_5=snapshot.child("dstore5").child("time").getValue().toString();
                final String bstoretime_6=snapshot.child("dstore6").child("time").getValue().toString();
                final String bstoretime_7=snapshot.child("dstore7").child("time").getValue().toString();
                final String bstoretime_8=snapshot.child("dstore8").child("time").getValue().toString();
                final String bstoretime_9=snapshot.child("dstore9").child("time").getValue().toString();
                final String bstoretime_10=snapshot.child("dstore10").child("time").getValue().toString();
                final String bstoretime_11=snapshot.child("dstore11").child("time").getValue().toString();
                final String bstoretime_12=snapshot.child("dstore12").child("time").getValue().toString();
                final String bstoretime_13=snapshot.child("dstore13").child("time").getValue().toString();
                final String bstoretime_14=snapshot.child("dstore14").child("time").getValue().toString();
                final String bstoretime_15=snapshot.child("dstore15").child("time").getValue().toString();
                final String bstoretime_16=snapshot.child("dstore16").child("time").getValue().toString();
                final String bstoretime_17=snapshot.child("dstore17").child("time").getValue().toString();
                final String bstoretime_18=snapshot.child("dstore18").child("time").getValue().toString();
                final String bstoretime_19=snapshot.child("dstore19").child("time").getValue().toString();
                final String bstoretime_20=snapshot.child("dstore20").child("time").getValue().toString();






                bstorename1.setText(bstorename_1);
                bstorename2.setText(bstorename_2);
                bstorename3.setText(bstorename_3);
                bstorename4.setText(bstorename_4);
                bstorename5.setText(bstorename_5);
                bstorename6.setText(bstorename_6);
                bstorename7.setText(bstorename_7);
                bstorename8.setText(bstorename_8);
                bstorename9.setText(bstorename_9);
                bstorename10.setText(bstorename_10);
                bstorename11.setText(bstorename_11);
                bstorename12.setText(bstorename_12);
                bstorename13.setText(bstorename_13);
                bstorename14.setText(bstorename_14);
                bstorename15.setText(bstorename_15);
                bstorename16.setText(bstorename_16);
                bstorename17.setText(bstorename_17);
                bstorename18.setText(bstorename_18);
                bstorename19.setText(bstorename_19);
                bstorename20.setText(bstorename_20);


                bstoreadress1.setText(bstoreaddress_1);
                bstoreadress2.setText(bstoreaddress_2);
                bstoreadress3.setText(bstoreaddress_3);
                bstoreadress4.setText(bstoreaddress_4);
                bstoreadress5.setText(bstoreaddress_5);
                bstoreadress6.setText(bstoreaddress_6);
                bstoreadress7.setText(bstoreaddress_7);
                bstoreadress8.setText(bstoreaddress_8);
                bstoreadress9.setText(bstoreaddress_9);
                bstoreadress10.setText(bstoreaddress_10);
                bstoreadress11.setText(bstoreaddress_11);
                bstoreadress12.setText(bstoreaddress_12);
                bstoreadress13.setText(bstoreaddress_13);
                bstoreadress14.setText(bstoreaddress_14);
                bstoreadress15.setText(bstoreaddress_15);
                bstoreadress16.setText(bstoreaddress_16);
                bstoreadress17.setText(bstoreaddress_17);
                bstoreadress18.setText(bstoreaddress_18);
                bstoreadress19.setText(bstoreaddress_19);
                bstoreadress20.setText(bstoreaddress_20);


                bstoretime1.setText(bstoretime_1);
                bstoretime2.setText(bstoretime_2);
                bstoretime3.setText(bstoretime_3);
                bstoretime4.setText(bstoretime_4);
                bstoretime5.setText(bstoretime_5);
                bstoretime6.setText(bstoretime_6);
                bstoretime7.setText(bstoretime_7);
                bstoretime8.setText(bstoretime_8);
                bstoretime9.setText(bstoretime_9);
                bstoretime10.setText(bstoretime_10);
                bstoretime11.setText(bstoretime_11);
                bstoretime12.setText(bstoretime_12);
                bstoretime13.setText(bstoretime_13);
                bstoretime14.setText(bstoretime_14);
                bstoretime15.setText(bstoretime_15);
                bstoretime16.setText(bstoretime_16);
                bstoretime17.setText(bstoretime_17);
                bstoretime18.setText(bstoretime_18);
                bstoretime19.setText(bstoretime_19);
                bstoretime20.setText(bstoretime_20);



                DatabaseReference shopavailablityref=FirebaseDatabase.getInstance().getReference().child("adminview").child("Deliverycharge").child("shopavailability");

                shopavailablityref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot snapshot2) {



                bstore1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore1").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {

                            Intent i = new Intent(FastfoodStores.this, Dstore1.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_1);


                            i.putExtra("bstorename_1", bstorename_1);
                            i.putExtra("bstoreaddress_1", bstoreaddress_1);
                            i.putExtra("storeid", "dstore1");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore2").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore2.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_2);


                            i.putExtra("bstorename_1", bstorename_2);
                            i.putExtra("bstoreaddress_1", bstoreaddress_2);
                            i.putExtra("storeid", "dstore2");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        if (snapshot2.child("dstore3").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore3.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_3);


                            i.putExtra("bstorename_1", bstorename_3);
                            i.putExtra("bstoreaddress_1", bstoreaddress_3);
                            i.putExtra("storeid", "dstore3");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore4").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore4.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_4);


                            i.putExtra("bstorename_1", bstorename_4);
                            i.putExtra("bstoreaddress_1", bstoreaddress_4);
                            i.putExtra("storeid", "dstore4");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore5").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore5.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_5);


                            i.putExtra("bstorename_1", bstorename_5);
                            i.putExtra("bstoreaddress_1", bstoreaddress_5);
                            i.putExtra("storeid", "dstore5");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore6").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore6.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_6);


                            i.putExtra("bstorename_1", bstorename_6);
                            i.putExtra("bstoreaddress_1", bstoreaddress_6);
                            i.putExtra("storeid", "dstore6");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);

                        }
                    }
                });


                bstore7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore7").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore7.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_7);


                            i.putExtra("bstorename_1", bstorename_7);
                            i.putExtra("bstoreaddress_1", bstoreaddress_7);
                            i.putExtra("storeid", "dstore7");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (snapshot2.child("dstore8").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore8.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_8);


                            i.putExtra("bstorename_1", bstorename_8);
                            i.putExtra("bstoreaddress_1", bstoreaddress_8);
                            i.putExtra("storeid", "dstore8");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (snapshot2.child("dstore9").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore9.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_9);


                            i.putExtra("bstorename_1", bstorename_9);
                            i.putExtra("bstoreaddress_1", bstoreaddress_9);
                            i.putExtra("storeid", "dstore9");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore10").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore10.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_10);


                            i.putExtra("bstorename_1", bstorename_10);
                            i.putExtra("bstoreaddress_1", bstoreaddress_10);
                            i.putExtra("storeid", "dstore10");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });



                bstore11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore11").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore11.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_11);


                            i.putExtra("bstorename_1", bstorename_11);
                            i.putExtra("bstoreaddress_1", bstoreaddress_11);
                            i.putExtra("storeid", "dstore11");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore12").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore12.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_12);


                            i.putExtra("bstorename_1", bstorename_12);
                            i.putExtra("bstoreaddress_1", bstoreaddress_12);
                            i.putExtra("storeid", "dstore12");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore13").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore13.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_13);


                            i.putExtra("bstorename_1", bstorename_13);
                            i.putExtra("bstoreaddress_1", bstoreaddress_13);
                            i.putExtra("storeid", "dstore13");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore14").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore14.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_14);


                            i.putExtra("bstorename_1", bstorename_14);
                            i.putExtra("bstoreaddress_1", bstoreaddress_14);
                            i.putExtra("storeid", "dstore14");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore14").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore15.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_15);


                            i.putExtra("bstorename_1", bstorename_15);
                            i.putExtra("bstoreaddress_1", bstoreaddress_15);
                            i.putExtra("storeid", "dstore15");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore16").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore16.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_15);


                            i.putExtra("bstorename_1", bstorename_16);
                            i.putExtra("bstoreaddress_1", bstoreaddress_16);
                            i.putExtra("storeid", "dstore16");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore17").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore17.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_17);


                            i.putExtra("bstorename_1", bstorename_17);
                            i.putExtra("bstoreaddress_1", bstoreaddress_17);
                            i.putExtra("storeid", "dstore17");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore18").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore18.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_18);


                            i.putExtra("bstorename_1", bstorename_18);
                            i.putExtra("bstoreaddress_1", bstoreaddress_18);
                            i.putExtra("storeid", "dstore18");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore19").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore19.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_19);


                            i.putExtra("bstorename_1", bstorename_19);
                            i.putExtra("bstoreaddress_1", bstoreaddress_19);
                            i.putExtra("storeid", "dstore19");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });


                bstore20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (snapshot2.child("dstore20").exists()){



                            Toast.makeText(FastfoodStores.this, "Opps! This shop is currently not Accepting orders.", Toast.LENGTH_SHORT).show();



                        }

                        else {
                            Intent i = new Intent(FastfoodStores.this, Dstore20.class);
                            String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                            i.putExtra("otpverifiednumber", otpverifiednumber);
                            i.putExtra("bstoretime_1", bstoretime_20);


                            i.putExtra("bstorename_1", bstorename_20);
                            i.putExtra("bstoreaddress_1", bstoreaddress_20);
                            i.putExtra("storeid", "dstore20");
                            i.putExtra("category", "fastfoodstores");


                            startActivity(i);
                        }
                    }
                });












                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(FastfoodStores.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
             Toast.makeText(FastfoodStores.this, "Please check your mobile Internet connection and try again.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}