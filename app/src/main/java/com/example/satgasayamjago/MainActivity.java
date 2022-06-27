package com.example.satgasayamjago;


import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {
    SliderView sliderView;
    int[] images = {R.drawable.damkar_protoyp,
            R.drawable.sar,
            R.drawable.hospitel,
            R.drawable.polisi,
            R.drawable.pmi,
            R.drawable.bnpb};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Toast.makeText(this, "GPS sudah diaktifkan", Toast.LENGTH_SHORT).show();
        }else{
            showGPSDisabledAlertToUser();
        }

        Button b = findViewById(R.id.button2);
        b.setOnClickListener((view -> startActivity(new Intent(MainActivity.this, Pop.class))));
        Button c = findViewById(R.id.button3);
        c.setOnClickListener((view -> startActivity(new Intent(MainActivity.this, Igd.class))));
        Button i = findViewById(R.id.button9);
        i.setOnClickListener((view -> startActivity(new Intent(MainActivity.this, Basarnas.class))));
        Button d = findViewById(R.id.button4);
        d.setOnClickListener((view -> startActivity(new Intent(MainActivity.this, Pmi.class))));
        Button f = findViewById(R.id.button5);
        f.setOnClickListener((view -> startActivity(new Intent(MainActivity.this, Polisi.class))));
        Button j = findViewById(R.id.button);
        j.setOnClickListener((view -> startActivity(new Intent(MainActivity.this, Poskoba.class))));
        Button wakjago = findViewById(R.id.tombolwakjago);
        wakjago.setOnClickListener((view -> startActivity(new Intent(MainActivity.this, Wakjago.class))));

        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

    }

    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS tidak diaktifkan, mau aktifkan segera?")
                .setCancelable(false)
                .setPositiveButton("Pergi ke Settings untuk mengaktifkan",
                        (dialog, id) -> {
                            Intent callGPSSettingIntent = new Intent(
                                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(callGPSSettingIntent);
                        });
        alertDialogBuilder.setNegativeButton("Batal",
                (dialog, id) -> dialog.cancel());
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}