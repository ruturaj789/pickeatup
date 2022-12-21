package com.raj.pickeatup;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TrackOrderAdapter extends RecyclerView.Adapter<com.raj.pickeatup.TrackOrderAdapter.MyViewHolder>{
    Context con;
    ArrayList<ProfilesOfItemInCart> profiles;



    public TrackOrderAdapter(Context c,ArrayList<ProfilesOfItemInCart> p)
    {
        con =c;
        profiles=p;
    }

    public TrackOrderAdapter(TrackOrder trackOrder, String title, String type, String peuprice, String saving, String quantity) {
    }


    @NonNull
    @Override
    public com.raj.pickeatup.TrackOrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.raj.pickeatup.TrackOrderAdapter.MyViewHolder(LayoutInflater.from(con).inflate(R.layout.thankyoulistitemcard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull com.raj.pickeatup.TrackOrderAdapter.MyViewHolder holder, int position) {


        holder.titlep.setText(profiles.get(position).getTitle());
        holder.typep.setText(profiles.get(position).getType());

        holder.peupricep.setText(profiles.get(position).getPeuprice());

        holder.quantityp.setText(profiles.get(position).getQuantity());













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

            quantityp=itemView.findViewById(R.id.cquantityp);











        }



    }






}
