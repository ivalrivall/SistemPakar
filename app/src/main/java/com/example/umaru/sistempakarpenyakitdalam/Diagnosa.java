package com.example.umaru.sistempakarpenyakitdalam;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Diagnosa extends AppCompatActivity {
    private gejalapenyakit data;
    private Database datagejala;
    private SQLiteDatabase db;
    private TextView gejala;
    private Cursor gejalaCursor;
    private String kode_main;
    private String kode_tidak;
    private String kode_ya;
    private String mulai;
    private String selesai;
    private Button lanjut;
    private RadioButton radioButton_tidak;
    private RadioButton radioButton_ya;
    private RadioGroup radioGroup;
    private String result;
    private List<String> arrDiagnosa = new ArrayList<String>();
    String strDiagnosa = "";
    Double nilai = 0.0d;

    public Diagnosa() {
        db = null;
        gejalaCursor = null;
        datagejala = null;
        data = new gejalapenyakit();
        result = "";
        kode_ya = "";
        kode_tidak = "";
        kode_main = "";
        mulai = "";
        selesai = "";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteksi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        gejala = (TextView) findViewById(R.id.gejala1);
        lanjut = (Button) findViewById(R.id.lanjut);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        TextView pilihgejala = (TextView) findViewById(R.id.pilihgejala);
        datagejala = new Database(this);
        db = datagejala.getWritableDatabase();
        datagejala.createTable(db);
        datagejala.generateData(db);
        showText();
        radioButton_ya = (RadioButton) findViewById(R.id.ya);
        radioButton_tidak = (RadioButton) findViewById(R.id.tidak);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        lanjut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(myAnim);
                if (radioButton_ya.isChecked()) {

                    getYA();
                } else if (radioButton_tidak.isChecked()) {
                    getTIDAK();
                } else {
                    Toast.makeText(Diagnosa.this, "Pilih ya atau tidak", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void showText() {
        gejalaCursor = db.rawQuery("SELECT * FROM gejala where mulai = 'Y'", null);
        if (gejalaCursor.moveToFirst()) {
            result = gejalaCursor.getString(1);
            kode_ya = gejalaCursor.getString(2);
            kode_tidak = gejalaCursor.getString(3);
            mulai = gejalaCursor.getString(4);
            selesai = gejalaCursor.getString(5);
            kode_main = gejalaCursor.getString(0);
            while (!gejalaCursor.isAfterLast()) {
                result = gejalaCursor.getString(1);
                kode_ya = gejalaCursor.getString(2);
                kode_tidak = gejalaCursor.getString(3);
                mulai = gejalaCursor.getString(4);
                selesai = gejalaCursor.getString(5);
                kode_main = gejalaCursor.getString(0);
                gejalaCursor.moveToNext();
            }
        }
        data.setDiagnosa(result);
        data.setYa(kode_ya);
        data.setTidak(kode_tidak);
        gejala.setClickable(false);
        gejala.setText("Apakah anda mengalami\n" + data.getDiagnosa() + "?");
    }

    public void getYA() {
            arrDiagnosa.add(data.getYa());
            strDiagnosa += arrDiagnosa.size() + ". " + data.getDiagnosa() + "\n";

        gejalaCursor = db.rawQuery("SELECT * FROM gejala where id = '" + data.getYa() + "'", null);
        if (gejalaCursor.moveToFirst()) {
            result = gejalaCursor.getString(1);
            kode_ya = gejalaCursor.getString(2);
            kode_tidak = gejalaCursor.getString(3);
            mulai = gejalaCursor.getString(4);
            selesai = gejalaCursor.getString(5);
            kode_main = gejalaCursor.getString(0);
            while (!gejalaCursor.isAfterLast()) {
                result = gejalaCursor.getString(1);
                kode_ya = gejalaCursor.getString(2);
                kode_tidak = gejalaCursor.getString(3);
                mulai = gejalaCursor.getString(4);
                selesai = gejalaCursor.getString(5);
                kode_main = gejalaCursor.getString(0);
                gejalaCursor.moveToNext();
            }
        }

        if (kode_main.equals("P001")){

            nilai = arrDiagnosa.size() / 4.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }if (kode_main.equals("P002")){

            nilai = arrDiagnosa.size() / 7.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }if (kode_main.equals("P003")){

            nilai = arrDiagnosa.size() / 7.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P004")){

        nilai = arrDiagnosa.size() / 4.0d * 100.0d;
        System.out.println(String.valueOf(nilai));
        Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
        intent.putExtra("persen", String.format("%.2f", nilai)+"%");
        intent.putExtra("nama", kode_main);
        intent.putExtra("namagejala", strDiagnosa);
        startActivity(intent);
        return;
        }
        if (kode_main.equals("P005")){

            nilai = arrDiagnosa.size() / 5.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P006")){

            nilai = arrDiagnosa.size() / 6.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P007")){

            nilai = arrDiagnosa.size() / 5.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P008")){

            nilai = arrDiagnosa.size() / 4.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P009")){

            nilai = arrDiagnosa.size() / 5.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }

        if (selesai.equals("Y")){
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }

        data.setDiagnosa(result);
        data.setYa(kode_ya);
        data.setTidak(kode_tidak);
        gejala.setText("Apakah anda mengalami\n" + data.getDiagnosa() + "?");
        radioGroup.clearCheck();
        radioButton_ya.invalidate();
        radioButton_tidak.invalidate();
    }

    public void getTIDAK() {
        gejalaCursor = db.rawQuery("SELECT * FROM gejala where id = '" + data.getTidak() + "'", null);
        if (gejalaCursor.moveToFirst()) {
            result = gejalaCursor.getString(1);
            kode_ya = gejalaCursor.getString(2);
            kode_tidak = gejalaCursor.getString(3);
            mulai = gejalaCursor.getString(4);
            selesai = gejalaCursor.getString(5);
            kode_main = gejalaCursor.getString(0);
            while (!gejalaCursor.isAfterLast()) {
                result = gejalaCursor.getString(1);
                kode_ya = gejalaCursor.getString(2);
                kode_tidak = gejalaCursor.getString(3);
                mulai = gejalaCursor.getString(4);
                selesai = gejalaCursor.getString(5);
                kode_main = gejalaCursor.getString(0);
                gejalaCursor.moveToNext();
            }
        }
        if (kode_tidak.contentEquals("B")) {
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("namanol", "Anda mungkin tidak terkena penyakit dalam pencernaan atau mungkin anda terdeteksi penyakit lain yang belum ada di sistem kami");
            intent.putExtra("namagejala", " ");
            startActivity(intent);
            return;

        }
        if (kode_main.equals("P001")){

            nilai = arrDiagnosa.size() / 4.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }if (kode_main.equals("P002")){

            nilai = arrDiagnosa.size() / 7.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }if (kode_main.equals("P003")){

            nilai = arrDiagnosa.size() / 7.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P004")){

            nilai = arrDiagnosa.size() / 4.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P005")){

            nilai = arrDiagnosa.size() / 5.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P006")){

            nilai = arrDiagnosa.size() / 6.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P007")){

            nilai = arrDiagnosa.size() / 5.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P008")){

            nilai = arrDiagnosa.size() / 4.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P009")){

            nilai = arrDiagnosa.size() / 5.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (selesai.equals("Y")){
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        data.setDiagnosa(result);
        data.setYa(kode_ya);
        radioGroup.clearCheck();
        data.setTidak(kode_tidak);
        gejala.setText("Apakah anda mengalami\n" + data.getDiagnosa() + "?");
        radioButton_ya.invalidate();
        radioButton_tidak.invalidate();
    }
    public void onBackPressed() {

    }

    }
