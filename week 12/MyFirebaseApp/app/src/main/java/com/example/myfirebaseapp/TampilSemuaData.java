package com.example.myfirebaseapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TampilSemuaData extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;

    ArrayList<String> arrayEdit= new ArrayList<>();
    ArrayList<String> arrayHapus= new ArrayList<>();
    ArrayList<String> arrayTampil=new ArrayList<>();


    DatabaseReference databaseReference;
    public String data1, data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_semua_data);

        listView=findViewById(R.id.listdataku);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("siswa");
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayTampil);
        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String hasil=dataSnapshot.getValue(Mahasiswa.class).toPrint();
                arrayTampil.add(hasil);
                String key=dataSnapshot.getKey();
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String hasil=dataSnapshot.getValue(Mahasiswa.class).toPrint();
                String key=dataSnapshot.getKey();
                int indek=arrayEdit.indexOf(key);
                arrayEdit.add(key);
                arrayTampil.set(indek,hasil);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String hasil=dataSnapshot.getValue(Mahasiswa.class).toPrint();
                String key=dataSnapshot.getKey();
                int indek=arrayHapus.indexOf(key);
                arrayHapus.remove(indek);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}



