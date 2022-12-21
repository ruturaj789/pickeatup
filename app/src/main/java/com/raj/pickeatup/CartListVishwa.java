package com.raj.pickeatup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CartListVishwa extends AppCompatActivity {

    DatabaseReference reference2, reference;

    RecyclerView rvcart;

    Button co;

    ArrayList<ProfilesOfItemInCart> list;

    CartListVishwaAdapter myadapter;

    TextView totalprice, totalsaving;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list_vishwa);

        rvcart=findViewById(R.id.rvcart);
        co=findViewById(R.id.co);
        totalprice=findViewById(R.id.totalprice);
        totalsaving=findViewById(R.id.totalsaving);




        list=new ArrayList<ProfilesOfItemInCart>();

        rvcart.setLayoutManager(new LinearLayoutManager(this));

        String phoneno=getPhone();



        reference= FirebaseDatabase.getInstance().getReference().child("cart").child("bakerystores").child("godavari").child(phoneno);






        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot1: snapshot.getChildren())

                {




                    ProfilesOfItemInCart p=dataSnapshot1.getValue(ProfilesOfItemInCart.class);


                    list.add(p);

                }





                myadapter=new CartListVishwaAdapter(CartListVishwa.this,list);

                rvcart.setAdapter(myadapter);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(CartListVishwa.this, "Please Check your mobile Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });

        reference2=FirebaseDatabase.getInstance().getReference().child("totalprice").child("godavari").child(phoneno);

      reference2.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {

              String totalprices="Total Price= ₹"+snapshot.child("totalpeu").getValue().toString();

              String totalsave="You Save= ₹"+snapshot.child("totalsaving").getValue().toString();


             totalprice.setText(totalprices);

             totalsaving.setText(totalsave);



          }

          @Override
          public void onCancelled(@NonNull DatabaseError error)
          {

              Toast.makeText(CartListVishwa.this, "Please Check your mobile Internet Connection", Toast.LENGTH_SHORT).show();

          }
      });

      co.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent i= new Intent(CartListVishwa.this, AdressVishwa.class);



              startActivity(i);
          }
      });










    }


    Activity activity = CartListVishwa.this;
    String wantPermission = Manifest.permission.READ_PHONE_STATE;
    String wantPerm= Manifest.permission.CALL_PHONE;

    private static final int PERMISSION_REQUEST_CODE = 1;

    public String getPhone() {
        TelephonyManager phoneMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(activity, wantPermission) != PackageManager.PERMISSION_GRANTED)
        {
            return null;
        }
        return phoneMgr.getLine1Number();
    }

    private void requestPermission(String permission){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)){
            Toast.makeText(activity, "Phone state permission allows us to get phone number. Please allow it for additional functionality.", Toast.LENGTH_LONG).show();
        }
        ActivityCompat.requestPermissions(activity, new String[]{permission},PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(activity,"ok", Toast.LENGTH_LONG).show();



                } else
                {

                    Toast.makeText(activity,"Permission Denied. We can't DETECT phone number.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private boolean checkPermission(String permission){
        if (Build.VERSION.SDK_INT >= 23) {
            int result = ContextCompat.checkSelfPermission(activity, permission);
            if (result == PackageManager.PERMISSION_GRANTED){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }









}
