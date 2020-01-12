package com.example.boatcheck;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.boatcheck.ConfigRetrofit.APIUtils;
import com.example.boatcheck.ConfigRetrofit.DataClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class destop extends AppCompatActivity {
    TextView edViewtName,numBoat;

    EditText edTenTau,edHeight,edWidth,edUnladenWeight,edBottomHeight,edVolume;
    Button btnConfirm;
    static String userCurrent;
    static String idUser;
    static String soLuongKhachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destop);
        //mapping
        edViewtName=(TextView)findViewById(R.id.txtUser);
        numBoat=(TextView)findViewById(R.id.txtNumBoat);
        // give data from signin
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            userCurrent= extras.getString("username");
            idUser=extras.getString("idUser");
            soLuongKhachHang=extras.getString("soLuongTau");
            edViewtName.setText(userCurrent);
            numBoat.setText(soLuongKhachHang);
        }
    }

    // custom dialog layout
    private void openDialog(){
        Dialog dialog =new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialalog_add_ship);
        dialog.show();
        // mapping add boat.xml
        edTenTau=(EditText) dialog.findViewById(R.id.editTenTau);
        edHeight=(EditText)dialog.findViewById(R.id.editHeight);
        edWidth=(EditText)dialog.findViewById(R.id.editWidth);
        edUnladenWeight=(EditText)dialog.findViewById(R.id.editUnladenWeight);
        edBottomHeight=(EditText)dialog.findViewById(R.id.editBottomHeight);
        edVolume=(EditText)dialog.findViewById(R.id.editVolume);
        btnConfirm=(Button)dialog.findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addShip();
                Toast.makeText(destop.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*
    send data to server
     */

    private void addShip(){
        String tentau=edTenTau.getText().toString();
        String chieucao=edHeight.getText().toString();
        String chieurong=edWidth.getText().toString();
        String cannangkhongtai=edUnladenWeight.getText().toString();
        String chieucaoday=edBottomHeight.getText().toString();
        String thetich=edVolume.getText().toString();
        Boat boat=new Boat(idUser,tentau,chieucao,chieurong,cannangkhongtai,chieucaoday,thetich);
        DataClient dataClient = APIUtils.getData();
        retrofit2.Call<String> callback =dataClient.addBoat(boat);
        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().equals("SUCCESS"));
                    Toast.makeText(destop.this, response.body(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("CCCC",t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:
                Toast.makeText(this, "menu add", Toast.LENGTH_SHORT).show();
                openDialog();
                break;
            case R.id.menuList:
                getList();
                Toast.makeText(this, "menu list", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void getList(){
        final ArrayList<Boat> boats =new ArrayList<>();
        DataClient dataClient = APIUtils.getData();
        Makhachhang makhachhang = new Makhachhang(idUser);
        retrofit2.Call<List<Boat>> callback = dataClient.listboat(makhachhang);
        callback.enqueue(new Callback<List<Boat>>() {
            @Override
            public void onResponse(Call<List<Boat>> call, Response<List<Boat>> response) {
                if(response.isSuccessful()){
                    for(Boat b:(ArrayList<Boat>) response.body()){
                        boats.add(b);
                        // Toast.makeText(ListBoat.this, b.toString(), Toast.LENGTH_SHORT).show();
                    }
                    Intent intent =new Intent(destop.this,ListBoat.class);
                    intent.putExtra("IdUser",idUser);
                    intent.putExtra("listboat",boats);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<List<Boat>> call, Throwable t) {
                //  Toast.makeText(ListBoat.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
