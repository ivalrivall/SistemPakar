package com.example.umaru.sistempakarpenyakitdalam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by VisH on 18-10-2016.
 */
public class InfopenyakitMainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    public static ArrayList<InfopenyakitModel> data;
    ArrayList<String> namapenyakitlist;
    ArrayList<String> deskripsilist;
    ArrayList<String> solutioncombinelist;
    SearchView searchView;
    LinkedHashMap namelist;
    LinkedHashMap title;
    
    private SQLiteDatabase db2;
    private Database datapenyakit;
    private Cursor penyakitCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_infopenyakit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setQueryHint("Pencarian");
        searchView.setQueryRefinementEnabled(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<InfopenyakitModel>();
        datapenyakit = new Database(this);
        db2 = datapenyakit.getWritableDatabase();
        datapenyakit.createTable2(db2);
        datapenyakit.generateData2(db2);

        fetchData();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return  false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                final ArrayList<InfopenyakitModel> filteredList = new ArrayList<InfopenyakitModel>();
                for (int i = 0; i < namapenyakitlist.size(); i++) {
                    final String text = namapenyakitlist.get(i).toLowerCase();
                    if (text.contains(newText)) {
                        filteredList.add(new InfopenyakitModel(namapenyakitlist.get(i),deskripsilist.get(i),solutioncombinelist.get(i)));
                    }
                }
                adapter = new CustomAdapterInfopenyakit(filteredList);
                recyclerView.setAdapter(adapter);
                return true;
            }
        });
    }

    public void fetchData() {

        namelist=new LinkedHashMap<>();
        title=new LinkedHashMap<>();

        int a,b,c;
        penyakitCursor = db2.query("penyakit" ,null, null, null, null, null, null);
        a=penyakitCursor.getColumnIndex("nama_penyakit");
        b=penyakitCursor.getColumnIndex("deskripsi");
        c=penyakitCursor.getColumnIndex("penanganan");

        namapenyakitlist=new ArrayList<String>();
        deskripsilist= new ArrayList<String>();
        solutioncombinelist= new ArrayList<String>();

        while (penyakitCursor.moveToNext()){
            title.put(penyakitCursor.getString(a),"");
            namelist.put(penyakitCursor.getString(b), penyakitCursor.getString(c));
        }
        Iterator entry = title.entrySet().iterator();
        Iterator entries = namelist.entrySet().iterator();

        while (entries.hasNext()&& entry.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            Map.Entry thatEntry = (Map.Entry) entry.next();
            namapenyakitlist.add(String.valueOf(thatEntry.getKey()));
            deskripsilist.add(String.valueOf(thisEntry.getKey()));
            solutioncombinelist.add(String.valueOf(thisEntry.getValue()));
        }

        for (int i = 0; i < namapenyakitlist.size(); i++) {
          data.add(new InfopenyakitModel(namapenyakitlist.get(i), deskripsilist.get(i), solutioncombinelist.get(i)));
          }
        adapter = new CustomAdapterInfopenyakit(data);
        recyclerView.setAdapter(adapter);
    }
    public void onBackPressed() {

    }
}
