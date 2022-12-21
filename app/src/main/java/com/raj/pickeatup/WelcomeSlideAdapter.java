package com.raj.pickeatup;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raj.pickeatup.bakerystores.Bstore1;
import com.raj.pickeatup.bakerystores.CartListBstore1;
import com.raj.pickeatup.fastfoodstores.Dstore1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WelcomeSlideAdapter extends RecyclerView.Adapter<WelcomeSlideAdapter.MyViewHolder> {
    Context con;
    ArrayList<ProfileOfItemsInWelcome> profiles;


    public WelcomeSlideAdapter(Context c,ArrayList<ProfileOfItemsInWelcome> p)
    {
        con =c;
        profiles=p;
    }

    public WelcomeSlideAdapter(Welcome welcome, String photo) {
    }


    @NonNull
    @Override
    public WelcomeSlideAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WelcomeSlideAdapter.MyViewHolder(LayoutInflater.from(con).inflate(R.layout.imageslidewelcomecard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WelcomeSlideAdapter.MyViewHolder holder, int position) {
//
        Glide.with(con).load(profiles.get(position).getPhoto()).into(holder.iv);
        final String s= "Bstore1";


        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(con, s.class);

//                con.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView iv;




        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);



            iv= itemView.findViewById(R.id.slideimage);



        }



    };



}