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

public class Polisi extends Activity {
    Button clsbutn5;
    Spinner spinner;
    String nomor;
    Button callpolisi;
    TextView show_kontak;
    ArrayList<String> list_kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.polisipop);

        clsbutn5 = (Button) findViewById(R.id.buttonclose5);
        clsbutn5.setOnClickListener(view -> finish());
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

        spinner = (Spinner) findViewById(R.id.spinner6);
        show_kontak = (TextView) findViewById(R.id.show_kontak6);
        callpolisi= (Button) findViewById(R.id.callpolisi);
        list_kontak = new ArrayList<String>();

        list_kontak.add("Polda Sumatera Selatan 0711313769 - Jl. Jend. Sudirman No.KM.4.5. Pahlawan. Kec. Kemuning. Kota Palembang. Sumatera Selatan 30151");
        list_kontak.add("Poltabes 0711513334 - Jakabaring. Jl. Gub H Bastari. 8 Ulu. Kecamatan Jakabaring. Kota Palembang. Sumatera Selatan 30111");
        list_kontak.add("Poltabes 0711510455 - Jakabaring. Jl. Gub H Bastari. 8 Ulu. Kecamatan Jakabaring. Kota Palembang. Sumatera Selatan 30111");
        list_kontak.add("Polda Sumatera Selatan 0711320550 - Jl. Jend. Sudirman No.KM.4.5. Pahlawan. Kec. Kemuning. Kota Palembang. Sumatera Selatan 30151");
        list_kontak.add("Polsek Palembang 0711713344 - Jl. Ratu Sianum No.1. Lorok Pakjo. Kec. Ilir Bar. I. Kota Palembang. Sumatera Selatan 30111");
        list_kontak.add("Polsek Kemuning Palembang 0711813192 - Jl. Sirna Raga No.1912. Pipa Jaya. Kec. Kemuning. Kota Palembang. Sumatera Selatan");
        list_kontak.add("Polsekta Kalidoni 0711718101 - Jalan Dokter Sutami. Kalidoni. Sei Selayur. Palembang. Kota Palembang. Sumatera Selatan 30118");
        list_kontak.add("Polsekta Sako Kenten 0711820062 - Jl. Sematang-Sako Katen. Lebong Gajah. Sematang Borang. Kota Palembang. Sumatera Selatan 30163");
        list_kontak.add("Polsekta Lemabang 0711713344 - Jalan Ratu Sianum. 3 Ilir. Palembang. 3 Ilir. Palembang. Kota Palembang. Sumatera Selatan 30116");
        list_kontak.add("Polsekta Seberang Ulu I 0711510128 - Jl. KH Wahid Hasyim. 3-4 Ulu. Seberang Ulu I. 3-4 Ulu. Kecamatan Seberang Ulu I. Kota Palembang. Sumatera Selatan 30111");
        list_kontak.add("Polsek Sukarami 0711411585 - Jl. Kol. H. Burlian No.Km. 10. Karya Baru. Kec. Alang-Alang Lebar. Kota Palembang. Sumatera Selatan 30961");
        list_kontak.add("Polsek Talang Kelapa 07115720435 - Jl. Raya Palembang - Jambi Jl. Pangkalan Benteng No.25. Sukamoro. Kec. Talang Klp.. Kabupaten Banyu Asin. Sumatera Selatan 30961");
        list_kontak.add("Polsek Kertapati 082176342888 - Jalan Sriwijaya Raya. Kecamatan Kertapati Palembang");
        list_kontak.add("Polsek Seberang Ulu II 0711598133 - Jl. A Yani Plaju. 14 Ulu. Seberang Ulu II. Kota Palembang. Sumatera Selatan 30111. Indonesia");
        list_kontak.add("Polsek Ilir Timur I 07115734920 - Jalan Mayor Santoso. Kecamatan Ilir Timur I kota Palembang");
        list_kontak.add("Polsek Ilir Barat I 0711353014 - Jl. Putri Rambut Selako No. 1712. Bukit Lama. Ilir Barat I. Bukit Lama. Kec. Ilir Bar. I. Kota Palembang. Sumatera Selatan 30139");
        list_kontak.add("Polsek Ilir Barat II 0711352973 - Jalan Makrayu. Kelurahan 32 Ilir Kecamatan Ilir Barat II kota Palembang");
        list_kontak.add("SATBRIMOB POLDA 0711358970 - Bukit Besar. Jl. Srijaya Negara. Bukit Lama. Kec. Ilir Bar. I. Kota Palembang. Sumatera Selatan 30121");
        list_kontak.add("Dir.LaluLintas Polda 07113133043 - Jl. POM IX. Lorok Pakjo. Kec. Ilir Bar. I. Kota Palembang. Sumatera Selatan 30126");
        list_kontak.add("Kodim Tabes 0711351637 - Jl. Diponegoro No.15. Ilir Barat I Palembang. Sumatera Selatan");

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

        callpolisi.setOnClickListener(v -> {
            if(!nomor.equals("")){
                String nomor1= nomor.substring(0,41);
                final String nomorres = stripNonDigits(nomor1);
                dialContactPhone(nomorres);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner6);
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
        VideoView video = (VideoView) findViewById(R.id.videopolisi);

        video.setOnPreparedListener(mp -> mp.setLooping(true));

        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vipolisi);
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
