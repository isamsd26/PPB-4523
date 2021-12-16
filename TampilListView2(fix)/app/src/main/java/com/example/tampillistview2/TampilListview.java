<<<<<<< HEAD
package com.example.tampillistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TampilLisview extends AppCompatActivity {
    BantuDatabase bd;
    ListView listView;
    EditText editText;
    Button tblTambah;

    ArrayAdapter adapter;

    ArrayList<String> listviewku;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_Lisview);

        listView=(listView) findViewById(R.id.listdatabuah);
        editText=findViewById(R.id.databuah);
        tblTambah=findViewById(R.id.tbltambah);

        listviewku=new ArrayList<>();
        tampilkan_buah();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String noid=listviewku.get(position);
                final int nomor=noid.substring(0,2);
                editText.setText(nomor.toString());
                //editText.setText(nomor.toString());

                new AlertDialog.Builder(TampilLisview.this)
                        .setTitle("Perhatian !")
                        .setMessage("Yakin Menghapus data ini ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                bd.hapusRekord(Integer.parseInt(nomor));
                                listviewku.remove(position);
                                listView.invalidateViews();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return false;
            }
        });

        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.tambahData(editText.getText().toString());
                Toast.makeText(TampilLisview.this,"Data Tersimpan", Toast.LENGTH_SHORT).show();
                listView.clear();
                tampilkan_buah();
            }
        });
    }

    private void tampilkan_buah() {
        Cursor cursor=bd.tampilbuah();
        if (cursor.getCount()==0)
        {
            Toast.makeText(this, "Record Kosong Coy", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext())
            {
                listviewku.add(String.valueOf()cursor.getInt(0))+" "+cursor.getString(1));
            }
            adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listviewku);
            listView.setAdapter(adapter);
        }
    }
=======
package com.example.tampillistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TampilLisview extends AppCompatActivity {
    BantuDatabase bd;
    ListView listView;
    EditText editText;
    Button tblTambah;

    ArrayAdapter adapter;

    ArrayList<String> listviewku;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_Lisview);

        listView=(listView) findViewById(R.id.listdatabuah);
        editText=findViewById(R.id.databuah);
        tblTambah=findViewById(R.id.tbltambah);

        listviewku=new ArrayList<>();
        tampilkan_buah();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String noid=listviewku.get(position);
                final int nomor=noid.substring(0,2);
                editText.setText(nomor.toString());
                //editText.setText(nomor.toString());

                new AlertDialog.Builder(TampilLisview.this)
                        .setTitle("Perhatian !")
                        .setMessage("Yakin Menghapus data ini ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                bd.hapusRekord(Integer.parseInt(nomor));
                                listviewku.remove(position);
                                listView.invalidateViews();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return false;
            }
        });

        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.tambahData(editText.getText().toString());
                Toast.makeText(TampilLisview.this,"Data Tersimpan", Toast.LENGTH_SHORT).show();
                listView.clear();
                tampilkan_buah();
            }
        });
    }

    private void tampilkan_buah() {
        Cursor cursor=bd.tampilbuah();
        if (cursor.getCount()==0)
        {
            Toast.makeText(this, "Record Kosong Coy", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext())
            {
                listviewku.add(String.valueOf()cursor.getInt(0))+" "+cursor.getString(1));
            }
            adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listviewku);
            listView.setAdapter(adapter);
        }
    }
>>>>>>> 1d68be83ab08f8d7ba70bf07a8332f2502cbef17
}