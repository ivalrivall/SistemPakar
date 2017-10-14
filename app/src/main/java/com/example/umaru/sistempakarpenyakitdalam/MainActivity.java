package com.example.umaru.sistempakarpenyakitdalam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import static android.R.attr.x;
import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        ImageButton deteksi = (ImageButton) findViewById(R.id.deteksi);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        deteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(myAnim);
                Intent i = new Intent(getApplicationContext(), Diagnosa.class);
                startActivity(i);
            }
        });
        ImageButton infopenyakit = (ImageButton)findViewById(R.id.infopenyakit);
        infopenyakit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(myAnim);
                Intent i = new Intent(getApplicationContext(), InfopenyakitMainActivity.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "Ketuk Nama Penyakit untuk Menampilkan Detail Informasi Penyakit", Toast.LENGTH_LONG).show();
            }
        });
        ImageButton nearhospital = (ImageButton)findViewById(R.id.nearhospital);
        nearhospital.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(myAnim);
                String uri = "geo:" + x + "," + y + "?q=hospitals+near+my+location";
                startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
            }
        });

        ImageButton about = (ImageButton)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(myAnim);
                Intent i = new Intent(getApplicationContext(), About.class);
                startActivity(i);
            }
        });
    }
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Apa Anda yakin ingin keluar?").setCancelable(false).setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainActivity.this.finish();
            }
        }).setNegativeButton("Tidak", null).show();
    }

}
