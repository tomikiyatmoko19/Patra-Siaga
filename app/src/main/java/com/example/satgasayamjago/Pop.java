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

public class Pop extends Activity {
    Button clsbutn;
    Spinner spinner;
    String nomor;
    Button calldamkar;
    TextView show_kontak;
    ArrayList<String> list_kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.damkarpop);

        clsbutn = (Button) findViewById(R.id.buttonclose);
        clsbutn.setOnClickListener(view -> finish());
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

        spinner = (Spinner) findViewById(R.id.spinner);
        show_kontak = (TextView) findViewById(R.id.show_kontak);
        calldamkar = (Button) findViewById(R.id.calldamkar);
        list_kontak = new ArrayList<String>();

        list_kontak.add("Dinas PMD 0711312011 - Jln. Merdeka No.VII. 19 Ilir. Kec. Bukit Kecil. Kota Palembang. Sumatera Selatan 30113");
        list_kontak.add("Pos seberang Ulu Satu 0711510743 - Jalan KH Asik. 3-4 Ulu. Kecamatan Seberang Ulu I. Kota Palembang. Sumatera Selatan 30254");
        list_kontak.add("Pos seberang Ulu Dua 0711519003 - Jl. KH. Azhari, 13 Ulu, Kec. Seberang Ulu II, Kota Palembang, Sumatera Selatan 30263");
        list_kontak.add("Puskodal Security RU III Plaju 0711596710");
        list_kontak.add("Pos Seberang Ulu Satu 0711510743 - Jl. H Faqih Usman No.1. 3-4 Ulu. Kecamatan Seberang Ulu I. Kota Palembang. Sumatera Selatan 30122");
        list_kontak.add("Pos Talang Keramat 07115712333 - Jl. Talang Keramat. Kebun Bunga. Kec. Sukarami. Kota Palembang. Sumatera Selatan 30961");
        list_kontak.add("Pos sako Sematang Borang 0711822532 - Sako. Kec. Sako. Kota Palembang. Sumatera Selatan 30961");
        list_kontak.add("Pos Pemadam Gandus 0711447113 - Jl. Syakyakirti. Karang Anyar. Kec. Gandus. Kota Palembang. Sumatera Selatan 30148");
        list_kontak.add("PBPK Alang-alang Lebar 07117423500 - Karya Baru. Kec. Alang-Alang Lebar. Kota Palembang. Sumatera Selatan 30961");
        list_kontak.add("Pos Kemuning 07115556246 - Jl. R. Sukamto Jl. Rawasari. 20 Ilir D II. Kec. Ilir Tim. II. Kota Palembang. Sumatera Selatan 30114");

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

        calldamkar.setOnClickListener(v -> {
            if(!nomor.equals("")){
                String nomor1= nomor.substring(0,41);
                final String nomorres = stripNonDigits(nomor1);
                dialContactPhone(nomorres);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
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
        VideoView video = (VideoView) findViewById(R.id.videopdamkar);

        video.setOnPreparedListener(mp -> mp.setLooping(true));

        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pdamkar);
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
