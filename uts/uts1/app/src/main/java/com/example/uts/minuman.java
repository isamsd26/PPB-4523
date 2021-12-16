package com.example.uts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class minuman extends AppCompatActivity{
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman);

        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[] { "Teh Hangat/Es", "Jeruk Hangat/Es", "Air Mineral", "Es Kelapa",
                "Lemon Tea Hangat/Es"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), Teh.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Jeruk.class);
                    startActivityForResult(myIntent, 1);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), AirMineral.class);
                    startActivityForResult(myIntent, 2);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Kelapa.class);
                    startActivityForResult(myIntent, 3);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), LemonTea.class);
                    startActivityForResult(myIntent, 4);
                }
            }
        });
    }

}
