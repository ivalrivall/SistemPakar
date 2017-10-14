package com.example.umaru.sistempakarpenyakitdalam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sistempakar";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    public void createTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS gejala");
        db.execSQL("CREATE TABLE if not exists gejala (id TEXT PRIMARY KEY, nama TEXT, " +
                "ya VARCHAR(5), tidak VARCHAR(5), mulai VARCHAR(5), selesai VARCHAR(5));");
    }

    public void createTable2(SQLiteDatabase db2) {
        db2.execSQL("DROP TABLE IF EXISTS penyakit");
        db2.execSQL("CREATE TABLE if not exists penyakit (kode_penyakit TEXT PRIMARY KEY , " +
                "nama_penyakit TEXT, deskripsi TEXT, penanganan TEXT);");
    }

    public void generateData(SQLiteDatabase db) {
    ContentValues cv = new ContentValues();
        db.execSQL("INSERT INTO gejala VALUES ('G001','Nyeri pada perut', 'G002', 'B', 'Y', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G002','Mual dan muntah', 'G003', 'G024', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G003','Nyeri ulu hati', 'G004', 'G013', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G004','Nafsu makan menurun', 'P001', 'G005', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G005','Nyeri ulu hati sedikit ke samping kanan dan bisa ditunjuk cermat', 'G006', 'G009', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G006','Sakit timbul setelah makan', 'G007', 'G007', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G007','Sakit bisa menjalar ke punggung', 'G008', 'G008', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G008','Penurunan berat badan', 'P002', 'P002', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G009','Nyeri timbul saat dini hari', 'G010', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G010','Nyeri timbul bila lambung kosong ( makanan sudah sampai usus sekitar 3 jam setelah makan)', 'G011', 'G011', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G011','Nyeri bisa menjalar ke punggung', 'G012', 'G012', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G012','Tinja berwarna kehitaman', 'P003', 'P003', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G013','Kram perut', 'G014', 'G017', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G014','Tinja cair', 'P004', 'G015', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G015','Tinja keras dan sakit saat buang air besar ', 'G016', 'G016', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G016','Perut kembung', 'P005', 'P005', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G017','Lidah terlihat putih kotor', 'G018', 'G021', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G018','Demam tiba-tiba', 'G019', 'G019', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G019','Tinja cair', 'G020', 'G020', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G020','Tubuh lemah', 'P006', 'P006', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G021','Tinja berwarna kemerahan', 'G022', 'G004', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G022','Demam tinggi', 'G023', 'G023', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G023','Wajah kebiruan', 'P007', 'P007', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G024','Sering buang air besar', 'G025', 'G027', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G025','Mules dan kembung', 'G026', 'G026', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G026','Tinja cair', 'P008', 'P008', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G027','Nyeri perut bagian kanan bawah', 'G028', 'G003', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G028','Demam', 'G029', 'G029', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G029','Muntah', 'G030', 'G030', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G030','Nafsu makan menurun', 'P009', 'P009', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('P001','Gastritis Kronik', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P002','Tukak Gaster', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P003','Tukak Duodenum', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P004','Gastroenteritis', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P005','Ileus', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P006','Demam Tifoid', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P007','Disentri Basilar', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P008','Diare Akut', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P009','Apendisitis Akut', '0', '0', 'T', 'Y');");

        }

    public void generateData2(SQLiteDatabase db2) {
        db2.execSQL("INSERT INTO penyakit VALUES ('P001', 'Gastritis kronik', 'Gastritis kronik adalah suatu peradangan bagian mukosa lambung yang menahun. Gastritis kronik baru merupakan diagnosa setelah didasarkan pada hasil pemeriksaan hispatologi.', " +
                "'-Makan tepat waktu\n" +
                "-Makan sering dengan porsi kecil\n" +
                "-Makanlah makanan yang cair dan lembek\n" +
                "-Hindari makanan yang meningkatkan asam lambung atau perut kembung seperti kopi, teh, makanan pedas dan kol\n' );");
        db2.execSQL("INSERT INTO penyakit VALUES ('P002', 'Tukak Gaster', 'Tukak gaster merupakan luka terbuka dengan pinggir edema disertai indurasi dengan dasar tukak ditutupi debris.', " +
                "'-Istirahat dan hindari stress\n" +
                "-Berhenti merokok\n" +
                "-Hindari alkohol terutama dalam lambung kosong\n" +
                "-Diet ketat tidak dianjurkan lagi\n" +
                "-Hindari makanan asam, pedas, panas, banyak lemak\n" +
                "-Makan teratur sebaiknya yang lunak\n' );");
        db2.execSQL("INSERT INTO penyakit VALUES ('P003', 'Tukak Duodenum', 'Tukak duodenum merupakan suatu defek mukosa/submukosa yang terbatas tegas dapat menembus muskularis mukosa sampai lapisan serosa sehingga dapat terjadi perforasi.', " +
                "'-Makan dalam jumlah sedikit tapi sering\n" +
                "-Hindari makanan asam, pedas, panas, berlemak\n' );");
        db2.execSQL("INSERT INTO penyakit VALUES ('P004', 'Gastroenteritis', 'Gastroenteritis merupakan infeksi pada saluran pencernaan yang biasanya disebabkan oleh infeksi yang menyebar melalui air dan makanan yang sudah tercemar oleh tinja yang terinfeksi.', " +
                "'-Biasakan mencuci tangan sebelum makan dan masaklah makanan dengan baik dan benar.\n" +
                "-Makanlah makanan yang lunak dan mudah dicerna\n" +
                "-Hindari makanan pedas dan berlemak\n" +
                "-Segera berobat ke dokter untuk pengobatan lebih lanjut\n' );");
        db2.execSQL("INSERT INTO penyakit VALUES ('P005', 'Ileus', 'Ileus merupakan suatu keadaan dimana pergerakan kontraksi normal dinding usus untuk sementara waktu berhenti. Ileus dapat disebabkan oleh suatu infeksi atau bekuan darah di alam perut. Untuk menetapkan diagnosa perlu dilakukan pemeriksaan foto rontgen perut.', " +
                "'-Segera berobat ke dokter untuk mendapatkan infus dan pengobatan medis lainnya\n' );");
        db2.execSQL("INSERT INTO penyakit VALUES ('P006', 'Demam tifoid', 'Demam tifoid merupakan salah satu gangguan pencernaan yang cukup bayak diderita di Indonesia. Tipus disebabkan oleh kuman atau bakteri yang disebut Salmonella Typi. Penyakit ini menular melalui makanan atau minuman yang terkontaminasi kuman tipus.', " +
                "'-Makanlah yang lunak dan mudah dicerna secara teratur\n" +
                "-Jagalah kebersihan diri dan lingkungan\n" +
                "-Hindari makanan pedas dan berlemak\n" +
                "-Segera hubungi dokter untuk pengobatan lebih lanjut\n' );");
        db2.execSQL("INSERT INTO penyakit VALUES ('P007', 'Disentri Basilar', 'Disentri basilar adalah suatu infeksi akut radang kolon yang disebabkan kuman genus shigella yang terdapat di lingkungan yang buruk.', " +
                "'-Istirahat yang cukup\n" +
                "-Makanlah makanan yang lunak\n" +
                "-Segera berobat ke dokter jika kondisi belum membaik\n' );");
        db2.execSQL("INSERT INTO penyakit VALUES ('P008', 'Diare Akut', 'Diare akut adalah pengeluaran kotoran (tinja) yang lebih sering dari biasanya dan perut terasa sakit dan kembung.', " +
                "'-Makan dalam jumlah sedikit tapi sering\n" +
                "-Hindari makanan asam, pedas, panas, berlemak\n' );");
        db2.execSQL("INSERT INTO penyakit VALUES ('P009', 'Apendisitis Akut', 'Apendisitis akut adalah radang yang timbul secara mendadak pada apendik, merupakan salah satu kasus akut abdomen yang paling sering ditemui dan jika tidak ditangani dapat menyebabkan perforasi.', " +
                "'-Bed rest total posisi fowler (setengah duduk)\n" +
                "-Sebaiknya langsung dirujuk ke rumah sakit terdekat untuk dilakukan operasi cito\n' );");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void onCreate(SQLiteDatabase db) {
    }
}
