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
import com.raj.pickeatup.bakerystores.Bstore1;
import com.raj.pickeatup.bakerystores.Bstore1ItemAdapter;
import com.raj.pickeatup.bakerystores.CartListBstore7;

import java.util.ArrayList;

public class ThankYou extends AppCompatActivity {


    RecyclerView rv;
    TextView totalpr,thankstxt;


    ArrayList<ProfilesOfItemInCart> list;
    ThankYouAdapter myAdapter;

    Button torder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

       totalpr=findViewById(R.id.totalpr);

       thankstxt=findViewById(R.id.thankstxt);

        rv=findViewById(R.id.rvthanks);




        list=new ArrayList<ProfilesOfItemInCart>();

        rv.setLayoutManager(new LinearLayoutManager(this));

//        String phoneno=getPhone();
        String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();


        String storeid=getIntent().getStringExtra("storeid");
        final String category=getIntent().getStringExtra("category");

        String totalp=getIntent().getStringExtra("totalprice");

        String name=getIntent().getStringExtra("name");

        totalpr.setText("Total= ₹"+totalp);

        thankstxt.setText("Thank You "+name+", Your Order is Sucessfully Placed!");




        final DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("cart").child(category).child(storeid).child(uidno);



        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    for (DataSnapshot dataSnapshot1 : snapshot.getChildren()) {


                        ProfilesOfItemInCart p = dataSnapshot1.getValue(ProfilesOfItemInCart.class);


                        list.add(p);

                    }


                    myAdapter = new ThankYouAdapter(ThankYou.this, list);

                    rv.setAdapter(myAdapter);


                }
                
                else {

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(ThankYou.this, "Its showing database error", Toast.LENGTH_SHORT).show();

            }
        });

        torder=findViewById(R.id.torder);

        torder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ThankYou.this,TrackOrder.class);
           //DatabaseReference delref1=FirebaseDatabase.getInstance().getReference().child("cart").child(category)
                reference.removeValue();
                startActivity(i);

            }
        });

    }


//    Activity activity = ThankYou.this;
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
//
//            return true;
//
//
//        }
//    }

}