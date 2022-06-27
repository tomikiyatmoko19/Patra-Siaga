package com.example.satgasayamjago;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Wakjago extends Activity {
    private FusedLocationProviderClient client;
    Button clsbutnwakjago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wakjagoo);

        clsbutnwakjago = (Button) findViewById(R.id.buttonwakjago);
        clsbutnwakjago.setOnClickListener(view -> finish());
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.3));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


        requestPermission();
        client = LocationServices.getFusedLocationProviderClient(this);
        Button buttonku = findViewById(R.id.tombolwakjago1);
        buttonku.setOnClickListener(view -> {
            if (ActivityCompat.checkSelfPermission(Wakjago.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            client.getLastLocation().addOnSuccessListener(Wakjago.this, location -> {
                if (location!=null){
                    try {
                        String text = "Hallo. Disini darurat, Mohon segera ke https://maps.google.com/maps?q="+location.getLatitude()+","+location.getLongitude();
                        String toNumber = "+6285162637335";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
                        startActivity(intent);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        });
        Button buttonku1 = findViewById(R.id.tombolwakjago2);
        buttonku1.setOnClickListener(view -> {
            if (ActivityCompat.checkSelfPermission(Wakjago.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            client.getLastLocation().addOnSuccessListener(Wakjago.this, location -> {
                if (location!=null){
                    try {
                        String text = "Hallo. Disini darurat, Mohon segera ke https://maps.google.com/maps?q="+location.getLatitude()+","+location.getLongitude();
                        String toNumber = "+6285162685657";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
                        startActivity(intent);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        });

    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION},1);
    }
}
