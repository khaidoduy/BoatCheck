package com.example.boatcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map_boat extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    static String tenTau=null;
    static Double hoanhdo, tungdo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_boat);
        Bundle extras = getIntent().getExtras();
        String s1=extras.getString("HoanhDo");
        String s2=extras.getString("TungDo");
        hoanhdo=Double.parseDouble(s1);
        tungdo=Double.parseDouble(s2);
        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapBoat);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        CameraUpdate center=CameraUpdateFactory.newLatLng(new LatLng(hoanhdo,tungdo));
        CameraUpdate zoom =CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);
        addMarker(googleMap,hoanhdo,tungdo,R.string.un,R.string.united);
    }

    /**
     *
     */
    private void addMarker(GoogleMap map, double lat, double lon, int title, int snipper){

       int height=40;
       int width=40;
        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.marker);
        Bitmap smallMarker=Bitmap.createScaledBitmap(b,width,height,false);
        BitmapDescriptor smallMarkerIcon=BitmapDescriptorFactory.fromBitmap(smallMarker);
        map.addMarker(new MarkerOptions().position(new LatLng(lat,lon))
                                         .title(getString(title))
                                         .snippet(getString(snipper)).icon(smallMarkerIcon));
    }
}
