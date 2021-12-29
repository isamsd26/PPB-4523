package com.example.mylbs;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mylbs.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    public static final  String nama_pulau[]={"Pilih Pulau","Sumatera","Jawa","Sulawesi", "Bali","NTB","NTT", "Maluku","Papua"};
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        spinner=findViewById(R.id.pilihpulau);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,nama_pulau);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        double lati,longi;

        switch (position)
        {
            case 0:
                mMap.clear();
            case 1:
                LatLng aceh = new LatLng(-5.548008, 95.322280);
                mMap.addMarker(new MarkerOptions().position(aceh).title("Aceh"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(aceh));

                LatLng medan = new LatLng(-3.588233, 98.670718);
                mMap.addMarker(new MarkerOptions().position(medan).title("Medan"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(medan));

                LatLng padang = new LatLng(-0.947077, 100.416958);
                mMap.addMarker(new MarkerOptions().position(padang).title("Padang"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(padang));

                LatLng palembang = new LatLng(-2.966363, 104.763835);
                mMap.addMarker(new MarkerOptions().position(palembang).title("Palembang"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palembang));
                break;
            case 2:
            case 3:
            case 4:
            default:
                Toast.makeText(this, "Pilihan Tidak ada...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}