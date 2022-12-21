package com.raj.pickeatup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raj.pickeatup.bakerystores.BakeryStores;
import com.raj.pickeatup.bakerystores.Bstore1;
import com.raj.pickeatup.bakerystores.Bstore1ItemAdapter;
import com.raj.pickeatup.bookstores.BookStores;
import com.raj.pickeatup.breakfaststores.BreakfastStores;
import com.raj.pickeatup.fastfoodstores.FastfoodStores;
import com.raj.pickeatup.giftstores.GiftStores;
import com.raj.pickeatup.restaurantstores.RestaurantStores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.BLUETOOTH;
import static android.Manifest.permission.BLUETOOTH_ADMIN;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.SEND_SMS;

public class Welcome extends AppCompatActivity implements LocationListener {

    ImageView bakery, veg, nonveg;
   // ImageView breakfast, gift, books;

    DatabaseReference ref1;
    ArrayList<ProfileOfItemsInWelcome> list;


    RecyclerView rv;

    WelcomeSlideAdapter myAdapter;
    ImageView mainiv;


    LocationManager locationManager;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trackingorder,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent=new Intent(Welcome.this,TrackOrder.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    boolean checkperm() {



        int p1 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_PHONE_STATE);


        return p1 == PackageManager.PERMISSION_GRANTED ;

    }
    void requestdialogpermi() {

        ActivityCompat.requestPermissions(this, new String[]{READ_PHONE_STATE}, 200);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }




        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationEnabled();
        getLocation();



        Intent im= new Intent(Welcome.this, MyBackgroundProcess.class);

        im.setAction("BackgroundProcess1");

 //       PendingIntent pendingIntent= PendingIntent.getBroadcast(Welcome.this,0,im,0);

//        AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,0,10,pendingIntent);


























       nonveg=findViewById(R.id.bakery1);
       // breakfast=findViewById(R.id.breakfast1);

        bakery=findViewById(R.id.restaurant1);
        veg=findViewById(R.id.fastfood1);
        mainiv=findViewById(R.id.mainiv);




        mainiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this, BakeryStores.class);
                String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                // String number= getIntent().getStringExtra("number");
                i.putExtra("otpverifiednumber", otpverifiednumber);
                startActivity(i);            }
        });




    //    gift=findViewById(R.id.gift1);
    //    books=findViewById(R.id.books1);

        ActivityCompat.requestPermissions(this, new String[]{READ_PHONE_STATE}, 200);



        ref1= FirebaseDatabase.getInstance().getReference().child("welcomepage");


        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String bakeryurl = snapshot.child("bakery").getValue().toString();

                Glide.with(Welcome.this).load(bakeryurl).into(bakery);

                String vegurl = snapshot.child("veg").getValue().toString();

                Glide.with(Welcome.this).load(vegurl).into(veg);

                String nonvegurl = snapshot.child("nonveg").getValue().toString();

                Glide.with(Welcome.this).load(nonvegurl).into(nonveg);
//
//                String groceryurl = snapshot.child("grocery").getValue().toString();
//
//                Glide.with(Welcome.this).load(groceryurl).into(restaurant);
//
//                String gifturl = snapshot.child("gift").getValue().toString();
//
//                Glide.with(Welcome.this).load(gifturl).into(gift);
//
//                String booksurl = snapshot.child("books").getValue().toString();
//
//                Glide.with(Welcome.this).load(booksurl).into(books);
//

                String mainivurl = snapshot.child("mainiv").getValue().toString();

                Glide.with(Welcome.this).load(mainivurl).into(mainiv);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Welcome.this, "Please check your mobile Internet connection and try again.", Toast.LENGTH_SHORT).show();

            }
        });



        bakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkperm()) {
                    requestdialogpermi();
                }
                else {


                    Intent i = new Intent(Welcome.this, BakeryStores.class);
                    String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                    i.putExtra("otpverifiednumber", otpverifiednumber);


                    startActivity(i);


                }

            }
        });

        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkperm()) {
                    requestdialogpermi();
                }
                else {


                Intent i = new Intent(Welcome.this, BreakfastStores.class);
                String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                i.putExtra("otpverifiednumber", otpverifiednumber);


                startActivity(i);
                }

            }
        });


        nonveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkperm()) {
                    requestdialogpermi();

                    Toast.makeText(Welcome.this, "Please accept phone permission to proceed further.", Toast.LENGTH_SHORT).show();
                }


                else {
                Intent i = new Intent(Welcome.this, GiftStores.class);
                String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
                // String number= getIntent().getStringExtra("number");
                i.putExtra("otpverifiednumber", otpverifiednumber);

                startActivity(i);
                }
            }
        });




        //


//
//        breakfast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent i = new Intent(Welcome.this, BreakfastStores.class);
//                String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
//                i.putExtra("otpverifiednumber", otpverifiednumber);
//
//
//
//
//
//                startActivity(i);
//
//            }
//        });





//        gift.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent i = new Intent(Welcome.this, GiftStores.class);
//                String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
//                i.putExtra("otpverifiednumber", otpverifiednumber);
//
//
//
//                startActivity(i);
//
//            }
//        });

//        books.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent i = new Intent(Welcome.this, BookStores.class);
//                String otpverifiednumber = getIntent().getStringExtra("otpverifiednumber");
//                i.putExtra("otpverifiednumber", otpverifiednumber);
//
//
//
//
//                startActivity(i);
//
//            }
//        });

    }

    private void locationEnabled() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(Welcome.this)
                    .setTitle("Enable GPS Service")
                    .setMessage("We need your GPS location to show Near Places around you.")
                    .setCancelable(false)
                    .setPositiveButton("Enable", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                }
                            })
                    .setNegativeButton("Cancel", null)
                    .show();
        }
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, (LocationListener) this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        try {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);


            final String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();

            DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("totalprice").child("location").child(uidno);


            String saveCurrentDate, saveCurrentTime;

            Calendar calForDate = Calendar.getInstance();

            SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
            saveCurrentDate = currentDate.format(calForDate.getTime());


            SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");


            saveCurrentTime = currentTime.format(calForDate.getTime());




            reference1.child("latitude").setValue(String.valueOf(location.getLatitude()));
            reference1.child("longitude").setValue(String.valueOf(location.getLongitude()));
            reference1.child("city").setValue(addresses.get(0).getLocality());

            reference1.child("state").setValue(addresses.get(0).getAdminArea());

          //  reference1.child("country").setValue(addresses.get(0).getCountryName());

            reference1.child("pin").setValue(addresses.get(0).getPostalCode());
            reference1.child("adressline").setValue(addresses.get(0).getAddressLine(0));
            reference1.child("last seen date").setValue(saveCurrentDate);
            reference1.child("last seen time").setValue(saveCurrentTime);






        } catch (Exception e) {


        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}