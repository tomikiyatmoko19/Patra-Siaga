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

public class Pmi extends Activity {
    Button clsbutn3;
    Spinner spinner;
    String nomor;
    Button callpmi;
    TextView show_kontak;
    ArrayList<String> list_kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pmipop);

        clsbutn3 = findViewById(R.id.buttonclose3);
        clsbutn3.setOnClickListener(view -> finish());
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

        spinner = findViewById(R.id.spinner5);
        show_kontak = findViewById(R.id.show_kontak5);
        callpmi= findViewById(R.id.callpmi);
        list_kontak = new ArrayList<String>();

        list_kontak.add("PMI Kota Palembang 0711363150 - SKB. Jl. Srijaya No.5.5. Srijaya. Kec. Alang-Alang Lebar. Kota Palembang. Sumatera Selatan 30128");
        list_kontak.add("PMI Prov. Sumatera Selatan 0711350289 - Jl. Kartini No.8. Talang Semut. Bukit Kecil. Palembang City. South Sumatra 30121");
        list_kontak.add("PMI Kecamatan Ilir Barat I Palembang 0711350572 - Jl. Padang Selasa No.01. Bukit Lama. Kec. Ilir Bar. I. Kota Palembang. Sumatera Selatan 30121");
        list_kontak.add("MARKAS PMI KOTA PALEMBANG/PUMA 0711351601 - Jl. Cemp. Dalam No.42A. 26 Ilir. Kec. Bukit Kecil. Kota Palembang. Sumatera Selatan 30129");

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

        callpmi.setOnClickListener(v -> {
            if(!nomor.equals("")){
                String nomor1= nomor.substring(0,49);
                final String nomorres = stripNonDigits(nomor1);
                dialContactPhone(nomorres);
            }
        });;
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    protected void onResume() {
        super.onResume();
        VideoView video = findViewById(R.id.videopmi);

        video.setOnPreparedListener(mp -> mp.setLooping(true));

        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vipmi);
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
