package com.raj.pickeatup;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;

import static android.content.Context.MODE_PRIVATE;

public class VishwaItemAdapter extends RecyclerView.Adapter<VishwaItemAdapter.MyViewHolder> implements Filterable {
    Context con;
    ArrayList<ProfileOfItemsInVishwa> profiles;


    public VishwaItemAdapter(Context c,ArrayList<ProfileOfItemsInVishwa> p)
    {
        con =c;
        profiles=p;
    }

    public VishwaItemAdapter(Vishwa vishwa, String title, String type, String mrp, String peuprice, String saving) {
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(con).inflate(R.layout.vishwaitemcard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.titlep.setText(profiles.get(position).getTitle());
        holder.typep.setText(profiles.get(position).getType());
        holder.mrpp.setText(profiles.get(position).getMrp());
        holder.peupricep.setText(profiles.get(position).getPeuprice());
        holder.savingp.setText(profiles.get(position).getSaving());






        Glide.with(con).load(profiles.get(position).getProfilePic()).into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titlep, typep, mrpp, peupricep, savingp;

        ImageView iv;
        ElegantNumberButton numberButton;
        //       SharedPreferences sp;


        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            titlep = itemView.findViewById(R.id.title);
            typep = itemView.findViewById(R.id.type);
            mrpp = itemView.findViewById(R.id.mrp);
            peupricep = itemView.findViewById(R.id.peuprice);
            savingp = itemView.findViewById(R.id.saving);


            iv = itemView.findViewById(R.id.iv);


            numberButton = itemView.findViewById(R.id.nb);
//            final String s=numberButton.getNumber();


            numberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
                @Override
                public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                    if (!checkPermission(wantPermission)) {
                        requestPermission(wantPermission);
                    } else {

                        //Toast.makeText(Context.this, "Phone number is: "+ getPhone(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(con, numberButton.getNumber() + " " + titlep.getText() + " " +typep.getText()+ "  Added to Cart", Toast.LENGTH_SHORT).show();

                    }


                    //                  final HashMap<String, Object> cartmap = new HashMap<>();
                    //                  final String s=numberButton.getNumber();


//                    SharedPreferences pref = con.getSharedPreferences("Students", MODE_PRIVATE);


//                        cartmap.put("title",profiles.get(oldValue).getTitle());
//
//                        cartmap.put("type",profiles.get(oldValue).getType());
//
//                        cartmap.put("mrp",profiles.get(oldValue).getType());
//                        cartmap.put("peuprice",profiles.get(oldValue).getPeuprice());
//                        cartmap.put("saving",profiles.get(oldValue).getSaving());
//                        cartmap.put("quantity",s);
//
//                        cartListRef.child(profiles.get(oldValue).getTitle()).updateChildren(cartmap);


//                        cartListRef.child("peuprice").updateChildren(cartmap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task)
//                            {
//                                if (task.isSuccessful())
//                                {
//
//
//
//                                }
//                            }
//                        });

                    DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("cart").child("bakerystores").child("godavari");


                    String saveCurrentDate, saveCurrentTime;

                    Calendar calForDate = Calendar.getInstance();

                    SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                    saveCurrentDate = currentDate.format(calForDate.getTime());


                    SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
                    saveCurrentTime = currentTime.format(calForDate.getTime());


                    //    String num=pref.getString("number",null).toString();


                    String title = titlep.getText().toString();
                    String type = typep.getText().toString();
                    String mrp = mrpp.getText().toString();
                    String peuprice = peupricep.getText().toString();
                    String saving = savingp.getText().toString();
                    String quantity = numberButton.getNumber();
                    String phoneno = getPhone();

                    //String phoneno=Prevalent.getUserPhone().toString();
                    //
                    //String phoneno=Otp.getnumbers().toString();

                    CartHelper cartHelper = new CartHelper(title, type, mrp, peuprice, saving, quantity, phoneno);

                    cartListRef.child(phoneno).child(title).setValue(cartHelper);


                }


            });









        }


    }


    @Override
    public Filter getFilter() {
        return exampleFiltre;
    }
    private Filter exampleFiltre=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ProfileOfItemsInVishwa> filteredList= new ArrayList<>();

            if (constraint==null||constraint.length()==0){
                filteredList.addAll(profiles);

            }
            else {
                String filtrePattern = constraint.toString().toLowerCase().trim();

                for (ProfileOfItemsInVishwa profile: profiles){
                    if(profile.getTitle().toLowerCase().contains(filtrePattern)){

                        filteredList.add(profile);

                    }
                }
            }


            FilterResults results=new FilterResults();
            results.values=filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            profiles.clear();



            profiles.addAll((List)results.values);

            notifyDataSetChanged();



        }
    };





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

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//
//                    Toast.makeText(con, "Phone number is"+getPhone(), Toast.LENGTH_SHORT).show();
//
//
//
//                } else {
//                    Toast.makeText(con,"Permission Denied. We can't get phone number.", Toast.LENGTH_LONG).show();
//                }
//                break;
//        }
//    }

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
