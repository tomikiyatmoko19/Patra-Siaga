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

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Igd extends Activity {
    Button clsbutn1;
    Spinner spinner;
    String nomor;
    Button calligd;
    TextView show_kontak;
    ArrayList<String> list_kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.igdpop);

        clsbutn1 = (Button) findViewById(R.id.buttonclose1);
        clsbutn1.setOnClickListener(view -> finish());
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

        spinner = (Spinner) findViewById(R.id.spinner1);
        show_kontak = (TextView) findViewById(R.id.show_kontak1);
        calligd = (Button) findViewById(R.id.calligd);
        list_kontak = new ArrayList<String>();

        list_kontak.add("IGD RS Pertamina Plaju 0711597444 - Komplek Pertamina UP III, Jl. Pengantingan No.1, Komperta, Kec. Plaju, Kota Palembang, Sumatera Selatan 30967");
        list_kontak.add("IGD RS Pertamina Plaju 081279863368 -  Komplek Pertamina UP III, Jl. Pengantingan No.1, Komperta, Kec. Plaju, Kota Palembang, Sumatera Selatan 30967");
        list_kontak.add("RSUP Dr. Mohammad Hoesin 0711354088 - Jl. Jend. Sudirman No.Km. RW.5. Sekip Jaya. Kec. Kemuning. Kota Palembang. Sumatera Selatan 30126");
        list_kontak.add("RSUD Palembang BARI  0711519211 - Jl. Panca Usaha No.1. 5 Ulu. Kecamatan Seberang Ulu I. Kota Palembang. Sumatera Selatan 30254");
        list_kontak.add("RSU Sriwijaya 0711419680 - Jalan Jenderal Sudirman KM.4.5 No.502. 20 Ilir D. IV. Kec. Ilir Tim. I. Kota Palembang. Sumatera Selatan 30138");
        list_kontak.add("RS Muhammadiyah Palembang  0711511446 - Jl. Jenderal Ahmad Yani Jl. Silaberanti No.13. 13 Ulu. Kec. Seberang Ulu II. Kota Palembang. Sumatera Selatan 30263");
        list_kontak.add("Rumah Sakit Siloam Sriwijaya 07115229100 - Jl. POM IX. Lorok Pakjo. Kec. Ilir Bar. I. Kota Palembang. Sumatera Selatan 30137");
        list_kontak.add("Rumah Sakit Bhayangkara 0711410023 - Jl. Jend. Sudirman No.km 4. RW.5. Ario Kemuning. Kec. Kemuning. Kota Palembang. Sumatera Selatan");
        list_kontak.add("Rumah Sakit dr. AK Gani 0711354691 - Jl. Dr. Ak. Gani No.1. 16 Ilir. Kec. Bukit Kecil. Kota Palembang. Sumatera Selatan 30113");
        list_kontak.add("Rumah Sakit RK. Charitas 0711353375 - Jl. Jend. Sudirman No.1054. Sungai Pangeran. Kec. Ilir Tim. I. Kota Palembang. Sumatera Selatan 30114");
        list_kontak.add("Rumah Sakit Myria 0711411610 - Jl. Kol. H. Burlian No.228. Sukarami. Kec. Sukarami. Kota Palembang. Sumatera Selatan 30961");
        list_kontak.add("Rumah Sakit Islam Ar-Rasyid  07115610503 - Jl. HM. Saleh KM.7 No.2. Sukarami. Kec. Sukarami. Kota Palembang. Sumatera Selatan 30961");
        list_kontak.add("RS PUSRI 0711721313 - Komp. PT PUSRI. Jl. May Zen. Sei Selayur. Kec. Kalidoni. Kota Palembang. Sumatera Selatan 30118");
        list_kontak.add("RSUD Siti Fatimah 07115718883 - Jl. Kol. H. Burlian. Suka Bangun. Kec. Sukarami. Kota Palembang. Sumatera Selatan 30151");
        list_kontak.add("RS Umum YK Madira 0711356173 - Jl. Jend. Sudirman No.1051. 20 Ilir D. I. Kec. Ilir Tim. I. Kota Palembang. Sumatera Selatan 30114");
        list_kontak.add("RSI Siti Khadijah 0711356008 - Jl. Demang Lebar Daun. Lorok Pakjo. Kec. Ilir Bar. I. Kota Palembang. Sumatera Selatan 30137");
        list_kontak.add("Rumah Sakit Ibu dan Anak Az-Zahra  0711822723 - Jalan Brigadir jenderal Hasan Khasim Nomor 1-2 Kelurahan. Bukit Sangkal. Kec. Kalidoni. Kota Palembang. Sumatera Selatan 30114");

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

        calligd.setOnClickListener(v -> {
            if(!nomor.equals("")){
                String nomor1= nomor.substring(0,48);
                final String nomorres = stripNonDigits(nomor1);
                dialContactPhone(nomorres);
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner);

            // Set popupWindow height to 500px
            popupWindow.setHeight(500);
        }
        catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
            // silently fail...
        }
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    protected void onResume() {
        super.onResume();
        VideoView video = (VideoView) findViewById(R.id.videoigd);

        video.setOnPreparedListener(mp -> mp.setLooping(true));

        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vigd);
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
