package com.raj.pickeatup;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raj.pickeatup.bakerystores.Bstore1;
import com.raj.pickeatup.bakerystores.CartListBstore1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ThankYouAdapter extends RecyclerView.Adapter<com.raj.pickeatup.ThankYouAdapter.MyViewHolder>{
    Context con;
    ArrayList<ProfilesOfItemInCart> profiles;



    public ThankYouAdapter(Context c,ArrayList<ProfilesOfItemInCart> p)
    {
        con =c;
        profiles=p;
    }

    public ThankYouAdapter(ThankYou thankYou, String title, String type, String peuprice, String saving, String quantity) {
    }


    @NonNull
    @Override
    public com.raj.pickeatup.ThankYouAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.raj.pickeatup.ThankYouAdapter.MyViewHolder(LayoutInflater.from(con).inflate(R.layout.thankyoulistitemcard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull com.raj.pickeatup.ThankYouAdapter.MyViewHolder holder, int position) {


        holder.titlep.setText(profiles.get(position).getTitle());
        holder.typep.setText(profiles.get(position).getType());

        holder.peupricep.setText(profiles.get(position).getPeuprice());

        holder.quantityp.setText(profiles.get(position).getQuantity());







        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Order Confirmed");


        String saveCurrentDate, saveCurrentTime;


        Calendar calForDate = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());


        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calForDate.getTime());


        String orderingtime=saveCurrentDate+" "+saveCurrentTime;

        final String title=holder.titlep.getText().toString();
        String type = holder.typep.getText().toString();
        String mrp= "";
        String quantity=holder.quantityp.getText().toString();

        String peuprice =holder. peupricep.getText().toString();
        String saving ="";

     //   final String phoneno = getPhone();

        String uidno= FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString();



        final CartHelper cartHelper = new CartHelper(title, type, mrp, peuprice, saving, quantity, uidno);


        reference.child(uidno).child(title).setValue(cartHelper);

        String saveCurrentDate2, saveCurrentTime2;


        Calendar calForDate2 = Calendar.getInstance();

        SimpleDateFormat currentDate2 = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate2 = currentDate2.format(calForDate2.getTime());


        SimpleDateFormat currentTime2 = new SimpleDateFormat("HH:mm a");
        saveCurrentTime2 = currentTime2.format(calForDate2.getTime());

        String orderingtime2=saveCurrentDate2+" "+saveCurrentTime2;

        String saveCurrentDate3, saveCurrentTime3;
        Calendar calForDate3= Calendar.getInstance();

        SimpleDateFormat currentDate3 = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate3 = currentDate3.format(calForDate3.getTime());



        SimpleDateFormat currentTime3 = new SimpleDateFormat("HH a");
        saveCurrentTime3 = currentTime3.format(calForDate3.getTime());

        String orderingtime3=saveCurrentDate3+" "+saveCurrentTime3;


        DatabaseReference adminref = FirebaseDatabase.getInstance().getReference().child("adminview");

                    adminref.child("Confirmed Order List").child(uidno).child(orderingtime).child(title).setValue(cartHelper);

                    DatabaseReference shopref=FirebaseDatabase.getInstance().getReference().child("shopkeeperview");

                    shopref.child("Confirmed Order List").child(orderingtime).child(title).setValue(cartHelper);



        DatabaseReference shopref2=FirebaseDatabase.getInstance().getReference().child("shopkeeperview");

        shopref2.child("Confirmed Order List Hr Min").child(uidno).child(orderingtime2).child(title).setValue(cartHelper);



        DatabaseReference shopref3=FirebaseDatabase.getInstance().getReference().child("shopkeeperview");

        shopref3.child("Confirmed Order List Hr").child(uidno).child(orderingtime3).child(title).setValue(cartHelper);



//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//






    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titlep,typep, peupricep, savingp, quantityp;



        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            titlep= itemView.findViewById(R.id.ctitlep);
            typep= itemView.findViewById(R.id.ctypep);

            peupricep=itemView.findViewById(R.id.cpeupricep);
      //      savingp=itemView.findViewById(R.id.csaving);
            quantityp=itemView.findViewById(R.id.cquantityp);











        }



    }
//
//
//    String TAG = "PhoneActivityTAG";
//    //Activity activity = Context.this;
//    String wantPermission = Manifest.permission.READ_PHONE_STATE;
//    String wantPerm= Manifest.permission.CALL_PHONE;
//
//    private static final int PERMISSION_REQUEST_CODE = 1;
//
//    private String getPhone() {
//        TelephonyManager phoneMgr = (TelephonyManager) con.getSystemService(Context.TELEPHONY_SERVICE);
//        if (ActivityCompat.checkSelfPermission(con, wantPermission) != PackageManager.PERMISSION_GRANTED)
//        {
//            return null;
//        }
//        return phoneMgr.getLine1Number();
//    }
//
//    private void requestPermission(String permission){
//        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) con, permission)){
//            Toast.makeText(con, "Phone state permission allows us to get phone number. Please allow it for additional functionality.", Toast.LENGTH_LONG).show();
//        }
//        ActivityCompat.requestPermissions((Activity) con, new String[]{permission},PERMISSION_REQUEST_CODE);
//    }
//
//
//    private boolean checkPermission(String permission){
//        if (Build.VERSION.SDK_INT >= 23) {
//            int result = ContextCompat.checkSelfPermission(con, permission);
//            if (result == PackageManager.PERMISSION_GRANTED)
//            {
//                return true;
//            }
//            else
//            {
//
//                return false;
//            }
//        }
//        else
//
//        {
//            return true;
//        }
//    }





}
