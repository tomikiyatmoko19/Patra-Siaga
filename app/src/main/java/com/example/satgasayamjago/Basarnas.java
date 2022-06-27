package com.example.satgasayamjago;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class Basarnas extends Activity {
    Button clsbutn2;
    Spinner spinner;
    String nomor;
    Button callbasarnas;
    TextView show_kontak;
    ArrayList<String> list_kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basarnaspop);

        clsbutn2 = findViewById(R.id.buttonclose2);
        clsbutn2.setOnClickListener(view -> finish());
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        spinner = findViewById(R.id.spinner2);
        show_kontak = findViewById(R.id.show_kontak2);
        callbasarnas= findViewById(R.id.callbasarnas);
        list_kontak = new ArrayList<String>();

        list_kontak.add("Kantor SAR Palembang 0711418372 - Jl. Akses Bandara SMB II. Sukarame. Kebun Bunga. Kec. Sukarami. Kota Palembang. Sumatera Selatan 30961");
        list_kontak.add("Kantor SAR Palembang 0711355111 - Jl. Akses Bandara SMB II. Sukarame. Kebun Bunga. Kec. Sukarami. Kota Palembang. Sumatera Selatan 30961");
        list_kontak.add("Kantor SAR Palembang 0711357494 - Jl. Akses Bandara SMB II. Sukarame. Kebun Bunga. Kec. Sukarami. Kota Palembang. Sumatera Selatan 30961");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list_kontak);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                nomor = spinner.getSelectedItem().toString();
                show_kontak.setText(nomor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        callbasarnas.setOnClickListener(v -> {
            if(!nomor.equals("")){
                final String result = stripNonDigits(nomor);
                String nomor1= result.substring(0,10);
                dialContactPhone(nomor1);
            }
        });
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    protected void onResume() {
        super.onResume();
        VideoView video = findViewById(R.id.videobasarnas);

        video.setOnPreparedListener(mp -> mp.setLooping(true));

        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.basarnas);
        video.setVideoURI(videoPath);
        video.start();
    }
    public static String stripNonDigits(
            final CharSequence input){
        final StringBuilder sb = new StringBuilder(
                input.length());
        for(int i = 0; i < input.length(); i++){
            final char c = input.charAt(i);
            if(c > 47 && c < 58){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
