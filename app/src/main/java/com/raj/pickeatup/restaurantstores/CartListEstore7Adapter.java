package com.raj.pickeatup.restaurantstores;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raj.pickeatup.CartListVishwaAdapterHelper;
import com.raj.pickeatup.ProfilesOfItemInCart;
import com.raj.pickeatup.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CartListEstore7Adapter extends RecyclerView.Adapter<com.raj.pickeatup.restaurantstores.CartListEstore7Adapter.MyViewHolder>{
    Context con;
    ArrayList<ProfilesOfItemInCart> profiles;


    int overTotalPrice=0;
    int overTotalSaving=0;



    public CartListEstore7Adapter(Context c,ArrayList<ProfilesOfItemInCart> p)
    {
        con =c;
        profiles=p;
    }

    public CartListEstore7Adapter(CartListEstore7 cartListEstore7, String title, String type, String peuprice, String saving, String quantity) {
    }


    @NonNull
    @Override
    public com.raj.pickeatup.restaurantstores.CartListEstore7Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.raj.pickeatup.restaurantstores.CartListEstore7Adapter.MyViewHolder(LayoutInflater.from(con).inflate(R.layout.cartlistvishwaitemcard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull com.raj.pickeatup.restaurantstores.CartListEstore7Adapter.MyViewHolder holder, int position) {


        holder.titlep.setText(profiles.get(position).getTitle());
        holder.typep.setText(profiles.get(position).getType());

        holder.peupricep.setText(profiles.get(position).getPeuprice());
        holder.savingp.setText(profiles.get(position).getSaving());
        holder.quantityp.setText(profiles.get(position).getQuantity());


        String peuprices= profiles.get(position).getPeuprice();
        String savings=profiles.get(position).getSaving();
        String quantities=profiles.get(position).getQuantity();

        String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();







        int oneTypeProductTPrice=(Integer.valueOf(peuprices)) * Integer.valueOf(quantities);

        overTotalPrice=overTotalPrice+oneTypeProductTPrice;

        String totalpeu=String.valueOf(overTotalPrice);

        DatabaseReference cartListRef= FirebaseDatabase.getInstance().getReference().child("totalprice").child("estore7");

        String saveCurrentDate, saveCurrentTime;

        Calendar calForDate=Calendar.getInstance();

        SimpleDateFormat currentDate= new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate=currentDate.format(calForDate.getTime());


        SimpleDateFormat currentTime= new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime=currentTime.format(calForDate.getTime());





        int oneTypeSaving=(Integer.valueOf(savings)) * Integer.valueOf(quantities);




        overTotalSaving=overTotalSaving + oneTypeSaving;

        String totalsaving=String.valueOf(overTotalSaving);


        CartListVishwaAdapterHelper cartHelper= new CartListVishwaAdapterHelper( totalpeu,totalsaving,uidno,saveCurrentDate,saveCurrentTime);

        cartListRef.child(uidno).setValue(cartHelper);









    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titlep,typep, peupricep, savingp, quantityp;


        Button remove;
//        int overTotalPrice=0;
        //      int overTotalSaving=0;


        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            titlep= itemView.findViewById(R.id.ctitle);
            typep= itemView.findViewById(R.id.ctype);

            peupricep=itemView.findViewById(R.id.cpeuprice);
            savingp=itemView.findViewById(R.id.csaving);
            quantityp=itemView.findViewById(R.id.cquantity);
            remove=itemView.findViewById(R.id.cremove);








            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    CharSequence options[] = new CharSequence[]{
                            "Cancel",
                            "Remove"
                    };
                    final AlertDialog.Builder builder= new AlertDialog.Builder(con);
                    final String title=titlep.getText().toString();
                    builder.setTitle("Do "+title+ " remove from your Cart?");

                    builder.setItems(options, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {

                            if(i==0){


                            }
                            if(i==1)
                            {




                                String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();

                                DatabaseReference cartListRef= FirebaseDatabase.getInstance().getReference().child("cart").child("restaurantstores").child("estore7").child(uidno);
                                final String titles=titlep.getText().toString();

                                cartListRef.child(titles).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(con, titles+" removed Sucessfully from your Cart.", Toast.LENGTH_SHORT).show();
                                            Intent intent=new Intent(con, Estore7.class);
                                            con.startActivity(intent);
                                        }

                                    }
                                });

                            }

                        }
                    });
                    builder.show();




                }
            });








        }



    }


    String TAG = "PhoneActivityTAG";
    //Activity activity = Context.this;
    String wantPermission = Manifest.permission.READ_PHONE_STATE;
    String wantPerm= Manifest.permission.CALL_PHONE;

    private static final int PERMISSION_REQUEST_CODE = 1;

    private String getPhone() {
        TelephonyManager phoneMgr = (TelephonyManager) con.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(con, wantPermission) != PackageManager.PERMISSION_GRANTED)
        {
            return null;
        }
        return phoneMgr.getLine1Number();
    }

    private void requestPermission(String permission){
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) con, permission)){
            Toast.makeText(con, "Phone state permission allows us to get phone number. Please allow it for additional functionality.", Toast.LENGTH_LONG).show();
        }
        ActivityCompat.requestPermissions((Activity) con, new String[]{permission},PERMISSION_REQUEST_CODE);
    }


    private boolean checkPermission(String permission){
        if (Build.VERSION.SDK_INT >= 23) {
            int result = ContextCompat.checkSelfPermission(con, permission);
            if (result == PackageManager.PERMISSION_GRANTED)
            {
                return true;
            }
            else
            {

                return false;
            }
        }
        else

        {
            return true;
        }
    }





}
