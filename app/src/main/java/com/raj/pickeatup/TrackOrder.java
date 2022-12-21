package com.raj.pickeatup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raj.pickeatup.bakerystores.CartListBstore1;

import java.util.ArrayList;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.READ_PHONE_STATE;

public class TrackOrder extends AppCompatActivity {

    TextView dbdetails,deliveredtext, shipped, totalamount, step1;

    Button customercare;

    RecyclerView rv;
    ImageView iv1, iv2, iv3, iv4;


    ArrayList<ProfilesOfItemInCart> list;
    TrackOrderAdapter myAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order);

        dbdetails=findViewById(R.id.dbdetails);
        deliveredtext=findViewById(R.id.deliveredtext);

        shipped=findViewById(R.id.shipped);

        rv=findViewById(R.id.rv111);


        iv1=findViewById(R.id.iv1);
        iv2=findViewById(R.id.iv2);
        iv3=findViewById(R.id.iv3);
        iv4=findViewById(R.id.iv4);

     //   iv9=findViewById(R.id.iv9);

        totalamount=findViewById(R.id.totalamount);
        step1=findViewById(R.id.step1);

//        final String phoneno=getPhone();
      final  String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();



        DatabaseReference totalamountref=FirebaseDatabase.getInstance().getReference().child("delivaryboy");

        totalamountref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.child(uidno).exists()){
                    step1.setText("Step 1. Your Order Is getting ready by the shop.");

                    String totalprice=snapshot.child(uidno).child("totalp").getValue().toString();

                    totalamount.setText("Total = ₹"+totalprice);

                 //   Glide.with(TrackOrder.this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSh9JdemHcKX0zqPrHIIkfUXDwMGDwSsgFUSQ&usqp=CAU").into(iv1);
                    Glide.with(TrackOrder.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/welcomepage%2Fcooking.gif?alt=media&token=5d7151a8-39c9-4bf0-b1b0-144affe15475").into(iv1);


                }
                else {

                    step1.setText(" No Order for delivery found.");





                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });










        DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("takeorderdb").child("Takenorder");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot snapshot) {

                if((snapshot.child(uidno).exists())){


                    String dbdetail="Step 2 :"+snapshot.child(uidno).child("dbname").getValue().toString()+" has taken your order. Contact No: "+snapshot.child(uidno).child("dbphoneno").getValue().toString() ;



                    dbdetails.setText(dbdetail);

                    Glide.with(TrackOrder.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/welcomepage%2Fdelivery%20boy%20take%20order.gif?alt=media&token=428db415-47e2-496a-867d-3e4eed9c32a0").into(iv2);





                    notificationstep2();





                }
                else{




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        DatabaseReference ref3=FirebaseDatabase.getInstance().getReference().child("takeorderdb").child("ReceivedOrder");

        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if((snapshot.child(uidno).exists())){


                    String ship="Step 3: "+ snapshot.child(uidno).child("dbname").getValue().toString();

                    Glide.with(TrackOrder.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/welcomepage%2Frider.gif?alt=media&token=5a1119d1-60cc-48dd-9ec5-4657abe32ebc").into(iv3);


                    shipped.setText(ship);

                    notificationstep3();


                }
                else{




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



























        DatabaseReference ref2=FirebaseDatabase.getInstance().getReference().child("takeorderdb").child("DeliveredOrder");

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if((snapshot.child(uidno).exists())){


                    String delivered="Step 4: "+snapshot.child(uidno).child("dbname").getValue().toString();



                    deliveredtext.setText(delivered);

                    Glide.with(TrackOrder.this).load("https://firebasestorage.googleapis.com/v0/b/pickeatup-c2713.appspot.com/o/welcomepage%2Ftrackingorderic%2Fdelivered-icon-10.jpg?alt=media&token=e9cbda88-6635-49bd-b13d-5914543f4319").into(iv4);


                    notificationstep4();

                }

                else{




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        customercare=findViewById(R.id.customercare);

        customercare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(this,"Opening Profile",Toast.LENGTH_SHORT).show();
                Intent w=new Intent(Intent.ACTION_VIEW,Uri.parse("https://pickeatup.page.link/whatsapp"));
                startActivity(w);

            }
        });
















        list=new ArrayList<ProfilesOfItemInCart>();

        rv.setLayoutManager(new LinearLayoutManager(this));





        DatabaseReference referenc= FirebaseDatabase.getInstance().getReference().child("Order Confirmed").child(uidno);



        referenc.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(!(snapshot.child(uidno).exists())) {


                    for (DataSnapshot dataSnapshot1 : snapshot.getChildren()) {


                        ProfilesOfItemInCart p = dataSnapshot1.getValue(ProfilesOfItemInCart.class);


                        list.add(p);

                    }


                    myAdapter = new TrackOrderAdapter(TrackOrder.this, list);

                    rv.setAdapter(myAdapter);

                }

                else{

                    Toast.makeText(TrackOrder.this, "You do not have any Live Orders Present Now.", Toast.LENGTH_SHORT).show();
                }









            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(TrackOrder.this, "Its showing database error", Toast.LENGTH_SHORT).show();

            }
        });

    }







    private void notificationstep2(){

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel channel= new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager= getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);

            NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"n").setContentText("PickEatUp").setSmallIcon(R.drawable.pickeatupicon).setAutoCancel(false).setContentText("Delivary partner is now assigned to your delivary .");

            NotificationManagerCompat managerCompat= NotificationManagerCompat.from(this);

            managerCompat.notify(999,builder.build());
        }

    }

    private void notificationstep3(){

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel channel= new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager= getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);

            NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"n").setContentText("PickEatUp").setSmallIcon(R.drawable.pickeatupicon).setAutoCancel(false).setContentText("Your order is now left from the shop.");

            NotificationManagerCompat managerCompat= NotificationManagerCompat.from(this);

            managerCompat.notify(999,builder.build());
        }

    }

    private void notificationstep4(){

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel channel= new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager= getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);

            NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"n").setContentText("PickEatUp").setSmallIcon(R.drawable.pickeatupicon).setAutoCancel(false).setContentText("Your order is sucessfully delivered.");

            NotificationManagerCompat managerCompat= NotificationManagerCompat.from(this);

            managerCompat.notify(999,builder.build());
        }

    }










































//
//    Activity activity = TrackOrder.this;
//    String wantPermission = Manifest.permission.READ_PHONE_STATE;
//    String wantPerm= Manifest.permission.CALL_PHONE;
//
//    private static final int PERMISSION_REQUEST_CODE = 1;
//
//    public String getPhone() {
//        TelephonyManager phoneMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        if (ActivityCompat.checkSelfPermission(activity, wantPermission) != PackageManager.PERMISSION_GRANTED)
//        {
//            return null;
//        }
//        return phoneMgr.getLine1Number();
//    }
//
//    private void requestPermission(String permission){
//        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)){
//            Toast.makeText(activity, "Phone state permission allows us to get phone number. Please allow it for additional functionality.", Toast.LENGTH_LONG).show();
//        }
//        ActivityCompat.requestPermissions(activity, new String[]{permission},PERMISSION_REQUEST_CODE);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
//                {
//                    Toast.makeText(activity,"ok", Toast.LENGTH_LONG).show();
//
//
//
//                } else
//                {
//
//                    Toast.makeText(activity,"Permission Denied. We can't DETECT phone number.", Toast.LENGTH_LONG).show();
//                }
//                break;
//        }
//    }
//
//    private boolean checkPermission(String permission){
//        if (Build.VERSION.SDK_INT >= 23) {
//            int result = ContextCompat.checkSelfPermission(activity, permission);
//            if (result == PackageManager.PERMISSION_GRANTED){
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return true;
//        }
//    }
}