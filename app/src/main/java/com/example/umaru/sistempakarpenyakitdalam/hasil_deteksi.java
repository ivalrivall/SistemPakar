package com.example.umaru.sistempakarpenyakitdalam;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.x;
import static android.R.attr.y;

public class hasil_deteksi extends AppCompatActivity {

    Toolbar toolbar;
    protected Cursor cursor;
    Database dbHelper;
    TextView final_result;
    TextView nama_penyakit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_deteksi);
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        dbHelper = new Database(this);
        final_result = (TextView) findViewById(R.id.final_result);
        TextView persen = (TextView)findViewById(R.id.persen);
        TextView judul_keterangan = (TextView)findViewById(R.id.textView5);
        nama_penyakit = (TextView) findViewById(R.id.namapenyakit);
        TextView penyakitnol = (TextView) findViewById(R.id.penyakitnol);
        Button nearhospital = (Button)findViewById(R.id.rsterdekat);
        cursor = this.dbHelper.getReadableDatabase().rawQuery("SELECT * FROM penyakit WHERE kode_penyakit = '" + getIntent().getStringExtra("nama")+"' ", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            judul_keterangan.setVisibility(View.VISIBLE);
            nearhospital.setVisibility(View.VISIBLE);
            nama_penyakit.setText(cursor.getString(1).toString());
            final_result.setText(getIntent().getStringExtra("namagejala"));
            persen.setText(getIntent().getStringExtra("persen"));

        }else{
            final_result.setText(getIntent().getStringExtra("namagejala"));
            final_result.setText("Tidak ada gejala yang dipilih");
            judul_keterangan.setVisibility(View.INVISIBLE);
            nearhospital.setVisibility(View.INVISIBLE);
        }
        penyakitnol.setText(getIntent().getStringExtra("namanol"));



        nearhospital.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(myAnim);
                String uri = "geo:" + x + "," + y + "?q=hospitals+near+my+location";
                startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
            }
        });


        Button Mulailagi = (Button)findViewById(R.id.mulailagi);
        Mulailagi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(myAnim);
                Intent i = new Intent(getApplicationContext(), Diagnosa.class);
                startActivity(i);
            }
        });
    }
    public void onBackPressed() {


    }
}
