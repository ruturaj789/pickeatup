package com.raj.pickeatup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;

import android.Manifest;
import android.app.Activity;
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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raj.pickeatup.bakerystores.Bstore1;
import com.raj.pickeatup.bakerystores.CartListBstore1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AdressVishwa extends AppCompatActivity {


    TextView aname, alastname, aadress1, aadress2, aadress3, acity, apincode, aphoneno,aemail,aamount,ascharge,atamount,anote;

    Button proceed;

    DatabaseReference reference1, reference2;

    int overTotalPrice=0;
    int overTotalPrice2=0;



 //   Button btpicker;
    TextView tvlat, tvlong;
    int PLACE_PICKER_REQUEST = 1  ;
    LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_vishwa);
        aname=findViewById(R.id.aname);
        alastname=findViewById(R.id.alastname);
        aadress1=findViewById(R.id.adress1);
        aadress2=findViewById(R.id.adress2);
        aadress3=findViewById(R.id.adress3);
        acity=findViewById(R.id.acity);

        apincode=findViewById(R.id.apincode);
        aphoneno=findViewById(R.id.aphoneno);
        aemail=findViewById(R.id.aemail);
        proceed=findViewById(R.id.proceed);
        aamount=findViewById(R.id.aamount);
        ascharge=findViewById(R.id.ascharge);
        atamount=findViewById(R.id.atamount);
        anote=findViewById(R.id.anote);




   //     btpicker=findViewById(R.id.bt_picker);

        tvlat=findViewById(R.id.alat);
        tvlong=findViewById(R.id.along);
//        tv=findViewById(R.id.tv1);
//        tv2=findViewById(R.id.tv2);



        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationEnabled();



//
//        btpicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                PlacePicker.IntentBuilder builder= new PlacePicker.IntentBuilder();
//                try {
//                    startActivityForResult(builder.build(AdressVishwa.this),PLACE_PICKER_REQUEST);
//
//                }
//                catch (GooglePlayServicesRepairableException e){
//                    e.printStackTrace();
//                }
//                catch (GooglePlayServicesNotAvailableException e){
//                    e.printStackTrace();
//                }
//            }
//        });








































































































        DatabaseReference servicechargeref=FirebaseDatabase.getInstance().getReference().child("adminview").child("Deliverycharge");



        servicechargeref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot snapshot11) {
               String servicecharge=snapshot11.child("charge").getValue().toString();
                String servicecharge2=snapshot11.child("charge2").getValue().toString();



                String amountwithoutcharge=getIntent().getStringExtra("totalprice");

                String minorder=snapshot11.child("minorderprice").getValue().toString();

                String note1=snapshot11.child("note").getValue().toString();
                String note2=snapshot11.child("note2").getValue().toString();

                final String closedmessage= snapshot11.child("appavailability").child("closedmessage").getValue().toString();







                if((Integer.valueOf(amountwithoutcharge)) < (Integer.valueOf(minorder))){
                    Toast.makeText(AdressVishwa.this, note1, Toast.LENGTH_SHORT).show();

                    int oneTypeProductTPrice=(Integer.valueOf(amountwithoutcharge))+(Integer.valueOf(servicecharge)) ;
                    overTotalPrice=overTotalPrice+oneTypeProductTPrice;

                    final String tamountwithcharge=String.valueOf(overTotalPrice);
                    proceed.setText("Proceed to pay = ₹"+tamountwithcharge);




                    aamount.setText(amountwithoutcharge);
                    ascharge.setText(servicecharge);
                    atamount.setText(tamountwithcharge);
                    anote.setText(note1);







                    proceed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(final View v) {







//////////////////

                            if (snapshot11.child("appavailability").child("status").getValue().equals("closed")){



                                Toast.makeText(AdressVishwa.this, closedmessage, Toast.LENGTH_LONG).show();

                            }

                                else {


                                final String name = aname.getText().toString();
                                final String lastname = alastname.getText().toString();
                                final String adress1 = aadress1.getText().toString();
                                final String adress2 = aadress2.getText().toString();
                                final String adress3 = aadress3.getText().toString();
                                final String city = acity.getText().toString();
                                final String pincode = apincode.getText().toString();
                                final String receiversnumber = aphoneno.getText().toString();
                                final String email = aemail.getText().toString();
                                final String lati= tvlat.getText().toString();
                                final String longi= tvlong.getText().toString();


//                                final String phoneno = getPhone();
                                final String uidno1= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();


                                reference1 = FirebaseDatabase.getInstance().getReference().child("adress").child(uidno1);


                                AdressVishwaHelper myhelper = new AdressVishwaHelper(name, lastname, adress1, adress2, adress3, city, pincode, receiversnumber, email, lati, longi);

                                reference1.setValue(myhelper);


                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Order Confirmed");

                                ref.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                                        if (!(snapshot.child(uidno1).exists())) {


                                            if (receiversnumber.isEmpty() || receiversnumber.length() < 10 || receiversnumber.length() > 10) {
                                                aphoneno.setError("Enter the Valid 10 digit mobile number");
                                                aphoneno.requestFocus();


                                                return;
                                            }



                                            if (name.isEmpty() || name.length() < 3) {
                                                aname.setError("Minimum 3 letters");
                                                aname.requestFocus();


                                                return;
                                            }


                                            if (lastname.isEmpty() || lastname.length() < 3) {
                                                alastname.setError("Minimum 3 letters");
                                                alastname.requestFocus();


                                                return;
                                            }


                                            if (adress1.isEmpty() || adress1.length() < 5) {
                                                aadress1.setError("Minimum 5 letters");
                                                aadress1.requestFocus();


                                                return;
                                            }

                                            if (adress2.isEmpty() || adress2.length() < 5) {
                                                aadress2.setError("Minimum 5 letters");
                                                aadress2.requestFocus();


                                                return;
                                            }

                                            if (adress3.isEmpty() || adress3.length() < 5) {
                                                aadress3.setError("Minimum 5 letters");
                                                aadress3.requestFocus();


                                                return;
                                            }
//
//                                            if (lati.isEmpty()|| longi.isEmpty()) {
//                                                btpicker.setError("Select Delivery Location");
//                                                btpicker.requestFocus();
//
//
//                                                return;
//                                            }




                                            Intent i = new Intent(AdressVishwa.this, PaymentVishwa.class);



                                            String bstoreaddress_1 = getIntent().getStringExtra("bstoreaddress_1");

                                            String bstorename_1 = getIntent().getStringExtra("bstorename_1");
                                            String storeid = getIntent().getStringExtra("storeid");

                                            String category = getIntent().getStringExtra("category");
                                            String totalp = tamountwithcharge;
                                            String otpverifiednumber = "";
                                            String bstoretime = getIntent().getStringExtra("bstoretime").toString();
                                            i.putExtra("bstoretime", bstoretime);
                                            i.putExtra("otpverifiednumber", otpverifiednumber);

                                            i.putExtra("totalprice", totalp);
                                            i.putExtra("category", category);


                                            i.putExtra("email", email);
                                            i.putExtra("bstorename_1", bstorename_1);
                                            i.putExtra("bstoreaddress_1", bstoreaddress_1);
                                            i.putExtra("adress1", adress1);
                                            i.putExtra("adress2", adress2);
                                            i.putExtra("adress3", adress3);
                                            i.putExtra("city", city);
                                            i.putExtra("pincode", pincode);
                                            i.putExtra("receiversnumber", receiversnumber);
                                            i.putExtra("name", name);
                                            i.putExtra("lastname", lastname);
                                            i.putExtra("phno", uidno1);
                                            i.putExtra("storeid", storeid);
                                            i.putExtra("latitude", lati);
                                            i.putExtra("longitude",longi);


                                            startActivity(i);


                                        } else {


                                            Snackbar.make(v, "Dear Customer, your order is already in progress", Snackbar.LENGTH_INDEFINITE)
                                                    .setAction("View Order", new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {


                                                            Intent i = new Intent(AdressVishwa.this, TrackOrder.class);


                                                            startActivity(i);

                                                        }
                                                    }).show();

                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Toast.makeText(AdressVishwa.this, "Check  Your Mobile Internet Connection", Toast.LENGTH_SHORT).show();

                                    }
                                });


                            }







                        }
                    });






                }
                else {
                    Toast.makeText(AdressVishwa.this, note2, Toast.LENGTH_SHORT).show();


                    int oneTypeProductTPrice2=(Integer.valueOf(amountwithoutcharge))+(Integer.valueOf(servicecharge2));
                    overTotalPrice2=overTotalPrice2+oneTypeProductTPrice2;

                    final String tamountwithcharge2=String.valueOf(overTotalPrice2);

                    proceed.setText("Proceed to pay = ₹"+tamountwithcharge2);


                    aamount.setText(amountwithoutcharge);
                    ascharge.setText(servicecharge2);
                    atamount.setText(tamountwithcharge2);
                    anote.setText(note2);






                    proceed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(final View v) {



                            if (snapshot11.child("appavailability").child("status").getValue().equals("closed")){



                                Toast.makeText(AdressVishwa.this, closedmessage, Toast.LENGTH_LONG).show();

                            }
                            else {


                                final String name = aname.getText().toString();
                                final String lastname = alastname.getText().toString();
                                final String adress1 = aadress1.getText().toString();
                                final String adress2 = aadress2.getText().toString();
                                final String adress3 = aadress3.getText().toString();
                                final String city = acity.getText().toString();
                                final String pincode = apincode.getText().toString();
                                final String receiversnumber = aphoneno.getText().toString();
                                final String email = aemail.getText().toString();
                                final String lati= tvlat.getText().toString();
                                final String longi= tvlong.getText().toString();
//                                final String phoneno = getPhone();

                                final String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();



                                reference1 = FirebaseDatabase.getInstance().getReference().child("adress").child(uidno);


                                AdressVishwaHelper myhelper = new AdressVishwaHelper(name, lastname, adress1, adress2, adress3, city, pincode, receiversnumber, email, lati, longi);

                                reference1.setValue(myhelper);


                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Order Confirmed");

                                ref.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                                        if (!(snapshot.child(uidno).exists())) {


                                            if (receiversnumber.isEmpty() || receiversnumber.length() < 10 || receiversnumber.length() > 10) {
                                                aphoneno.setError("Enter the Valid 10 digit mobile number");
                                                aphoneno.requestFocus();


                                                return;
                                            }


                                            if (name.isEmpty() || name.length() < 3) {
                                                aname.setError("Minimum 3 letters");
                                                aname.requestFocus();


                                                return;
                                            }


                                            if (lastname.isEmpty() || lastname.length() < 3) {
                                                alastname.setError("Minimum 3 letters");
                                                alastname.requestFocus();


                                                return;
                                            }


                                            if (adress1.isEmpty() || adress1.length() < 5) {
                                                aadress1.setError("Minimum 5 letters");
                                                aadress1.requestFocus();


                                                return;
                                            }

                                            if (adress2.isEmpty() || adress2.length() < 5) {
                                                aadress2.setError("Minimum 5 letters");
                                                aadress2.requestFocus();


                                                return;
                                            }

                                            if (adress3.isEmpty() || adress3.length() < 5) {
                                                aadress3.setError("Minimum 5 letters");
                                                aadress3.requestFocus();


                                                return;
                                            }
//
//                                            if (lati.isEmpty()|| longi.isEmpty()) {
//                                                btpicker.setError("Select Delivery Location");
//                                                btpicker.requestFocus();
//                                                Toast.makeText(AdressVishwa.this, "Please provide Delivery location on map", Toast.LENGTH_SHORT).show();
//
//
//                                                return;
//                                            }
//

                                            Intent i = new Intent(AdressVishwa.this, PaymentVishwa.class);



                                            String bstoreaddress_1 = getIntent().getStringExtra("bstoreaddress_1");

                                            String bstorename_1 = getIntent().getStringExtra("bstorename_1");
                                            String storeid = getIntent().getStringExtra("storeid");

                                            String category = getIntent().getStringExtra("category");
                                            String totalp = tamountwithcharge2;
                                            String otpverifiednumber = "";
                                            String bstoretime = getIntent().getStringExtra("bstoretime").toString();
                                            i.putExtra("bstoretime", bstoretime);
                                            i.putExtra("otpverifiednumber", otpverifiednumber);

                                            i.putExtra("totalprice", totalp);
                                            i.putExtra("category", category);


                                            i.putExtra("email", email);
                                            i.putExtra("bstorename_1", bstorename_1);
                                            i.putExtra("bstoreaddress_1", bstoreaddress_1);
                                            i.putExtra("adress1", adress1);
                                            i.putExtra("adress2", adress2);
                                            i.putExtra("adress3", adress3);
                                            i.putExtra("city", city);
                                            i.putExtra("pincode", pincode);
                                            i.putExtra("receiversnumber", receiversnumber);
                                            i.putExtra("name", name);
                                            i.putExtra("lastname", lastname);
                                            i.putExtra("phno", uidno);
                                            i.putExtra("storeid", storeid);
                                            i.putExtra("latitude", lati);
                                            i.putExtra("longitude",longi);

                                            startActivity(i);


                                        } else {


                                            Snackbar.make(v, "Dear Customer, your order is already in progress", Snackbar.LENGTH_INDEFINITE)
                                                    .setAction("View Order", new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {


                                                            Intent i = new Intent(AdressVishwa.this, TrackOrder.class);


                                                            startActivity(i);

                                                        }
                                                    }).show();

                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Toast.makeText(AdressVishwa.this, "Check  Your Mobile Internet Connection", Toast.LENGTH_SHORT).show();

                                    }
                                });


                            }





                        }




                    });





                }





















            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


                Toast.makeText(AdressVishwa.this, "Check  Your Mobile Internet Connection", Toast.LENGTH_SHORT).show();


            }
        });




//      final String phoneno=getPhone();

      final  String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();


      reference2= FirebaseDatabase.getInstance().getReference().child("adress").child(uidno);



        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(!(snapshot.exists())){


                }

                else{


                            String name = snapshot.child("name").getValue().toString();
                            String lastname = snapshot.child("lastname").getValue().toString();
                    final String[] adress1 = {snapshot.child("adress1").getValue().toString()};
                            String adress2 = snapshot.child("adress2").getValue().toString();
                            String adress3 = snapshot.child("adress3").getValue().toString();
                    final String[] city = {snapshot.child("city").getValue().toString()};
                    final String[] pincode = {snapshot.child("pincode").getValue().toString()};
                            String receiversnumber = snapshot.child("receiversnumber").getValue().toString();
                            String email = snapshot.child("email").getValue().toString();




//                            if (snapshot.child("latitude").exists()|| snapshot.child("longitude").exists()){
//                                String latitude = snapshot.child("latitude").getValue().toString();
//                                String longitude = snapshot.child("longitude").getValue().toString();
//
//                                tvlat.setText(latitude);
//                                tvlong.setText(longitude);
//
//
//
//                            }
//
//                    if (snapshot.child("longitude").exists()){
//                        String longitude = snapshot.child("longitude").getValue().toString();
//
//                        tvlong.setText(longitude);
//
//                    }




                    //////////////////////////////////////////////////////////////////////////////////////////////






                    aname.setText(name);
                    alastname.setText(lastname);
                    aadress1.setText(adress1[0]);
                    aadress2.setText(adress2);
                    aadress3.setText(adress3);
                    acity.setText(city[0]);
                    apincode.setText(pincode[0]);
                    aphoneno.setText(receiversnumber);
                    aemail.setText(email);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AdressVishwa.this, "Check  Your Mobile Internet Connection", Toast.LENGTH_SHORT).show();


            }
        });



        reference2= FirebaseDatabase.getInstance().getReference().child("totalprice").child("location").child(uidno);



        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot2) {

                if(!(snapshot2.exists())){


                }

                else{




                    if (snapshot2.child("latitude").exists()&&snapshot2.child("longitude").exists()){
                        String latitude = snapshot2.child("latitude").getValue().toString();
                        String longitude = snapshot2.child("longitude").getValue().toString();

                        tvlat.setText(latitude);
                        tvlong.setText(longitude);

                    }

                    if (acity.length()==0&&snapshot2.child("city").exists())
                    {
                        acity.setText(snapshot2.child("city").getValue().toString());

                    }
                    if(apincode.length()==0&&snapshot2.child("pin").exists())
                    {
                        apincode.setText(snapshot2.child("pin").getValue().toString());


                    }











                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AdressVishwa.this, "Check  Your Mobile Internet Connection", Toast.LENGTH_SHORT).show();


            }
        });



        /////////////////////////////////////////////////////////////////////////////////////////////
































































    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    private void locationEnabled() {
//        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        boolean gps_enabled = false;
//        boolean network_enabled = false;
//        try {
//            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (!gps_enabled && !network_enabled) {
//            new AlertDialog.Builder(AdressVishwa.this)
//                    .setTitle("Enable GPS Service")
//                    .setMessage("We need your GPS location to show Near Places around you.")
//                    .setCancelable(false)
//                    .setPositiveButton("Enable", new
//                            DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
//                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
//                                }
//                            })
//                    .setNegativeButton("Cancel", null)
//                    .show();
//        }
//    }
//
//
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode==PLACE_PICKER_REQUEST){
//            if (resultCode==RESULT_OK){
//
//                Place place = PlacePicker.getPlace(this,data);
//                String latitude= String.valueOf(place.getLatLng().latitude);
//                String longitude=String.valueOf(place.getLatLng().longitude);
//
//                Toast.makeText(this, "Delivery Location Updated Sucessfully.", Toast.LENGTH_SHORT).show();
//
//                tvlat.setText(latitude);
//                tvlong.setText(longitude);
//
//
//
//
//
//
//
//            }
//        }
//    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////























//
//
//    String TAG = "PhoneActivityTAG";
//    Activity activity = AdressVishwa.this;
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




//}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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
            new AlertDialog.Builder(AdressVishwa.this)
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


    public void onLocationChanged(Location location) {
        try {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);


            final String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();

            DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("totalprice").child("location2").child(uidno);


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


    public void onStatusChanged(String provider, int status, Bundle extras) {

    }


    public void onProviderEnabled(String provider) {

    }


    public void onProviderDisabled(String provider) {

    }
}