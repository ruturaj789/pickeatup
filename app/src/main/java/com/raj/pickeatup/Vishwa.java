package com.raj.pickeatup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Vishwa extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView rv;
    FloatingActionButton fab;



    ArrayList<ProfileOfItemsInVishwa> list;
    VishwaItemAdapter myAdapter;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vishwa);

        rv=findViewById(R.id.rv);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                Snackbar.make(v,"Your PickEatUp Cart",Snackbar.LENGTH_LONG)
                        .setAction("Review Cart", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String number= getIntent().getStringExtra("number");


                               Intent i= new Intent(Vishwa.this, CartListVishwa.class);
                                i.putExtra("number",number);

                             startActivity(i);

                            }
                        }).show();
            }

        });


        list=new ArrayList<ProfileOfItemsInVishwa>();

        rv.setLayoutManager(new LinearLayoutManager(this));



        reference= FirebaseDatabase.getInstance().getReference().child("bakerystore").child("brij");



        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot1: snapshot.getChildren())

                {




                    ProfileOfItemsInVishwa p=dataSnapshot1.getValue(ProfileOfItemsInVishwa.class);


                    list.add(p);

                }





                myAdapter=new VishwaItemAdapter(Vishwa.this,list);

                rv.setAdapter(myAdapter);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Vishwa.this, "Its showing database error", Toast.LENGTH_SHORT).show();

            }
        });








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);


        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                myAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}