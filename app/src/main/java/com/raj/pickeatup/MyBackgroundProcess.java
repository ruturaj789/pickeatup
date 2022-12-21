package com.raj.pickeatup;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MyBackgroundProcess extends BroadcastReceiver {

    LocationManager locationManager;


    @Override
    public void onReceive(final Context context, Intent intent)  {
//
//        Ringtone ringtone= RingtoneManager.getRingtone(context,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
//
//        ringtone.play();
//
//        Toast.makeText(context, "This is my background process"+ Calendar.getInstance().getTime().toString(), Toast.LENGTH_LONG).show();
//
//
//        SystemClock.sleep(10000);
//
//        ringtone.stop();



        DatabaseReference notifyref= FirebaseDatabase.getInstance().getReference().child("adminview").child("Confirmed Orders");


        notifyref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                Ringtone ringtone= RingtoneManager.getRingtone(context,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

                ringtone.play();






            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






//
//        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
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
//            new AlertDialog.Builder(context)
//                    .setTitle("Enable GPS Service")
//                    .setMessage("We need your GPS location to show Near Places around you.")
//                    .setCancelable(false)
//                    .setPositiveButton("Enable", new
//                            DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
//                                    context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
//                                }
//                            })
//                    .setNegativeButton("Cancel", null)
//                    .show();
//        }
//
//







































//
//        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//        try {
//            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, (LocationListener) this);
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        }




    }


//    void getLocation() {
//        try {
//            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, (LocationListener) this);
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        try {
//            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
//            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//
//
//            final String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();
//
//            DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("totalprice").child("location").child(uidno);
//
//
//            String saveCurrentDate, saveCurrentTime;
//
//            Calendar calForDate = Calendar.getInstance();
//
//            SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
//            saveCurrentDate = currentDate.format(calForDate.getTime());
//
//
//            SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
//
//
//            saveCurrentTime = currentTime.format(calForDate.getTime());
//
//
//
//
//            reference1.child("latitude").setValue(String.valueOf(location.getLatitude()));
//            reference1.child("longitude").setValue(String.valueOf(location.getLongitude()));
//            reference1.child("city").setValue(addresses.get(0).getLocality());
//
//            reference1.child("state").setValue(addresses.get(0).getAdminArea());
//
//            //  reference1.child("country").setValue(addresses.get(0).getCountryName());
//
//            reference1.child("pin").setValue(addresses.get(0).getPostalCode());
//
//            reference1.child("adressline").setValue(addresses.get(0).getAddressLine(0));
//            reference1.child("last seen date").setValue(saveCurrentDate);
//            reference1.child("last seen time").setValue(saveCurrentTime);
//
//
//
//
//
//
//        } catch (Exception e) {
//
//
//        }
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }



}
