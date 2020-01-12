package com.example.boatcheck;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterBoat extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Boat> boatList;

    public AdapterBoat(Context context, int layout, List<Boat> boatList) {
        this.context = context;
        this.layout = layout;
        this.boatList = boatList;
    }

    @Override
    public int getCount() {
        return boatList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class HolderView{
        TextView txtNameTau, mapCurrent,detail;
        ImageView imageTrangThai, imageStart;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        if(convertView == null){
            holderView =new HolderView();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //mapping
            convertView=inflater.inflate(layout,null);
            holderView.txtNameTau=(TextView) convertView.findViewById(R.id.txtTenTau);
            convertView.setTag(holderView);
        }else{
            holderView=(HolderView) convertView.getTag();
        }
        // data transmission
        final Boat boat=boatList.get(position);
        holderView.txtNameTau.setText(boat.getTenTau());
        //mapping
        holderView.mapCurrent=(TextView) convertView.findViewById(R.id.txtMap);
        holderView.imageTrangThai=(ImageView) convertView.findViewById(R.id.imageStatus);
        holderView.detail=(TextView) convertView.findViewById(R.id.txtDetail);
        holderView.imageStart=(ImageView) convertView.findViewById(R.id.imageStart);

        // chuyen anh trang thai vao
        if(boat.getTrangThai().equals("1")){
            holderView.imageTrangThai.setImageResource(R.drawable.siren);
        }else{
            holderView.imageTrangThai.setImageResource(R.drawable.sirenred);
        }
        // start chuyen di
        holderView.imageStart.setImageResource(R.drawable.start);
        holderView.imageStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context,activity_ship_boat.class));
            }
        });


        holderView.mapCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent= new Intent(context, map_boat.class);
                String hoanhDo=null,tungDo=null;
                hoanhDo = boat.getViTriX();
                tungDo= boat.getViTriY();
                myIntent.putExtra("HoanhDo",hoanhDo);
                myIntent.putExtra("TungDo",tungDo);
                v.getContext().startActivity(myIntent);
            }
        });

        holderView.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context, detail_boat.class));
            }
        });
        return convertView;
    }
}
