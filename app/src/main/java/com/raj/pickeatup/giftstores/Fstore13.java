package com.raj.pickeatup.giftstores;

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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raj.pickeatup.ProfileOfItemsInVishwa;
import com.raj.pickeatup.R;

import java.util.ArrayList;

public class Fstore13 extends AppCompatActivity {


    RecyclerView rv;

    FloatingActionButton fab1;

    ArrayList<ProfileOfItemsInVishwa> list;
    Fstore13ItemAdapter myAdapter;
    TextView bstoretimep1,bstorenamep1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fstore13);
        rv=findViewById(R.id.rvfstore13);
        fab1=findViewById(R.id.fafstore13);
        bstoretimep1=findViewById(R.id.fstoretimep13);
        bstorenamep1=findViewById(R.id.fstorenamep13);
        final String bstoretime=getIntent().getStringExtra("bstoretime_1");

        String bstorenam=getIntent().getStringExtra("bstorename_1");
        bstorenamep1.setText(bstorenam);
        bstoretimep1.setText(bstoretime);



        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                Snackbar.make(v,"Your PickEatUp Cart",Snackbar.LENGTH_LONG)
                        .setAction("View Cart", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                                Intent i= new Intent(Fstore13.this, CartListFstore13.class);

                                String bstoreaddress_1=getIntent().getStringExtra("bstoreaddress_1");

                                String bstorename_1=getIntent().getStringExtra("bstorename_1");
                                String storeid=getIntent().getStringExtra("storeid");
                                String category=getIntent().getStringExtra("category");
                                String otpverifiednumber= getIntent().getStringExtra("otpverifiednumber");
                                i.putExtra("otpverifiednumber",otpverifiednumber);
                                i.putExtra("bstoretime",bstoretime);


                                i.putExtra("category",category);
                                i.putExtra("bstorename_1",bstorename_1);
                                i.putExtra("bstoreaddress_1",bstoreaddress_1);
                                i.putExtra("storeid",storeid);

                                startActivity(i);

                            }
                        }).show();
            }

        });






        list=new ArrayList<ProfileOfItemsInVishwa>();

        rv.setLayoutManager(new LinearLayoutManager(this));




        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("giftstores").child("fstore13");



        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot1: snapshot.getChildren())

                {




                    ProfileOfItemsInVishwa p=dataSnapshot1.getValue(ProfileOfItemsInVishwa.class);


                    list.add(p);

                }





                myAdapter=new Fstore13ItemAdapter(Fstore13.this,list);

                rv.setAdapter(myAdapter);








            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Fstore13.this, "Its showing database error", Toast.LENGTH_SHORT).show();

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