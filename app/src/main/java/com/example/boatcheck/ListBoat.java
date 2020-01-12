package com.example.boatcheck;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListBoat extends AppCompatActivity {
    static String id="";
    AdapterBoat adapterBoat;
    public static ArrayList<Boat> boatArrayList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boatArrayList=new ArrayList<>();
        setContentView(R.layout.list_view_boat);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("IdUser");
            boatArrayList=bundle.getParcelableArrayList("listboat");
        }
        listView = (ListView) findViewById(R.id.listViewBoat);
        Toast.makeText(ListBoat.this, boatArrayList.size()+"", Toast.LENGTH_SHORT).show();
        adapterBoat = new AdapterBoat(this, R.layout.row_info_boat, boatArrayList);
        listView.setAdapter(adapterBoat);
    }
}