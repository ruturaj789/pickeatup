package com.raj.pickeatup.giftstores;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raj.pickeatup.AdressVishwa;
import com.raj.pickeatup.ProfilesOfItemInCart;
import com.raj.pickeatup.R;

import java.util.ArrayList;

public class CartListFstore14 extends AppCompatActivity {

    DatabaseReference reference2, reference;

    RecyclerView rvcart;

    Button co;

    ArrayList<ProfilesOfItemInCart> list;

    CartListFstore14Adapter myadapter;

    TextView totalprice, totalsaving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list_fstore14);

        rvcart=findViewById(R.id.rvcartfstore14);
        co=findViewById(R.id.cofstore14);
        totalprice=findViewById(R.id.totalpricesfstore14);
        totalsaving=findViewById(R.id.totalsavingsfstore14);




        list=new ArrayList<ProfilesOfItemInCart>();

        rvcart.setLayoutManager(new LinearLayoutManager(this));

        String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();



        reference= FirebaseDatabase.getInstance().getReference().child("cart").child("giftstores").child("fstore14").child(uidno);






        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    for (DataSnapshot dataSnapshot1 : snapshot.getChildren()) {


                        ProfilesOfItemInCart p = dataSnapshot1.getValue(ProfilesOfItemInCart.class);


                        list.add(p);

                    }


                    myadapter = new CartListFstore14Adapter(CartListFstore14.this, list);

                    rvcart.setAdapter(myadapter);


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(CartListFstore14.this, "Please Check your mobile Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });

        reference2=FirebaseDatabase.getInstance().getReference().child("totalprice").child("fstore14").child(uidno);

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    String totalprices = "Total= ???" + snapshot.child("totalpeu").getValue().toString();

                    String totalsave = "You Save= ???" + snapshot.child("totalsaving").getValue().toString();


                    totalprice.setText(totalprices);

                    totalsaving.setText(totalsave);



                    co.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DatabaseReference refe=FirebaseDatabase.getInstance().getReference().child("stores").child("giftstore").child("fstore14");
                            refe.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull final DataSnapshot snapshot2) {

                                    if(snapshot2.exists()) {


                                        Intent i = new Intent(CartListFstore14.this, AdressVishwa.class);

                                        String bstoreaddress_1 = snapshot2.child("adress").getValue().toString();

                                        String bstorename_1 = snapshot2.child("name").getValue().toString();
                                        String bstoretime = snapshot2.child("time").getValue().toString();
                                        String storeid = "fstore14";

                                        String category = "giftstores";
                                        String totalp = snapshot.child("totalpeu").getValue().toString();


                                        i.putExtra("bstoretime", bstoretime);


                                        i.putExtra("totalprice", totalp);
                                        i.putExtra("category", category);


                                        i.putExtra("bstorename_1", bstorename_1);
                                        i.putExtra("bstoreaddress_1", bstoreaddress_1);
                                        i.putExtra("storeid", storeid);


                                        startActivity(i);
                                    }



                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                        }
                    });
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

                Toast.makeText(CartListFstore14.this, "Please Check your mobile Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });












    }


    Activity activity = CartListFstore14.this;
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
