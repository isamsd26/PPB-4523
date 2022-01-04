package com.example.uts ;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class makanan extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[]{"Ikan Bakar Kecap", "Ikan Bakar Mentega", "Ikan Saus Padang",
                "Ikan Saus Tiram", "Cumi Bakar", "Cumi Saus Tiram", "Cumi Saus Padang", "Udang Bakar",
                "Udang Saus Padang", "Udang Saus Tiram","Kepiting Saus Padang", "Lobster Saus Padang"

        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1,android.R.id.text1,values );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent myIntent = new Intent(view.getContext(), IkanBakarKecap.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1){
                    Intent myIntent = new Intent(view.getContext(), IkanBakarMentega.class);
                    startActivityForResult(myIntent, 1);
                }

                if (position == 2){
                    Intent myIntent = new Intent(view.getContext(), IkanSausTiram.class);
                    startActivityForResult(myIntent, 2);
                }

                if (position == 3){
                    Intent myIntent = new Intent(view.getContext(), IkanSausPadang.class);
                    startActivityForResult(myIntent, 3);
                }

                if (position == 4){
                    Intent myIntent = new Intent(view.getContext(), CumiBakar.class);
                    startActivityForResult(myIntent, 4);
                }

                if (position == 5){
                    Intent myIntent = new Intent(view.getContext(), CumiSausTiram.class);
                    startActivityForResult(myIntent, 5);
                }

                if (position == 6){
                    Intent myIntent = new Intent(view.getContext(), CumiSausPadang.class);
                    startActivityForResult(myIntent, 6);
                }

                if (position == 7){
                    Intent myIntent = new Intent(view.getContext(), UdangBakar.class);
                    startActivityForResult(myIntent, 7);
                }

                if (position == 8){
                    Intent myIntent = new Intent(view.getContext(), UdangSausPadang.class);
                    startActivityForResult(myIntent, 8);
                }

                if (position == 9){
                    Intent myIntent = new Intent(view.getContext(), UdangSausTiram.class);
                    startActivityForResult(myIntent, 9);
                }

                if (position == 10){
                    Intent myIntent = new Intent(view.getContext(), KepitingSausPadang.class);
                    startActivityForResult(myIntent, 10);
                }

                if (position == 10){
                    Intent myIntent = new Intent(view.getContext(), LobsterSausPadang.class);
                    startActivityForResult(myIntent, 10);
                }
            }
        });
    }
}
