package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hurufKounter;
    int huruf = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hurufKounter = findViewById(R.id.kounter);

    }


    public void tblkounter(View view) {
        huruf=huruf+1;
        hurufKounter.setText(Integer.toString(huruf));


    }

    public void toastklik(View view) {
        Toast.makeText(this, "Ini Toast", Toast.LENGTH_SHORT).show();
    }
}
