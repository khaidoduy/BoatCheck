package com.example.boatcheck;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boatcheck.ConfigRetrofit.APIUtils;
import com.example.boatcheck.ConfigRetrofit.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class log_in extends AppCompatActivity {
    EditText editUsername, editPassword;
    Button btnLogin, btnSignUp;
    static String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        // mapping
        editUsername = (EditText) findViewById(R.id.editUserName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);


        //set click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // post check ID User and pass
                Toast.makeText(log_in.this, "Done Click.", Toast.LENGTH_SHORT).show();
                checkUser();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(log_in.this, signup.class));
            }
        });

    }
  /*  private void CheckDataBase() {
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s=response.toString();
                if(s.equals("SUCCESS")){
                    startActivity(new Intent(log_in.this, destop.class));
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("BBBBB",error.toString());
                //Toast.makeText(log_in.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("Username",editUsername.getText().toString());
                params.put("Password",editPassword.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }*/
    /**
     * kiem tra tai khoan co ton tai trong database
     */
    private void checkUser(){
        user=editUsername.getText().toString();
        pass=editPassword.getText().toString();
        User kh=new User(user,pass);
        if(user.length()>0 && pass.length()>0){
            DataClient dataClient = APIUtils.getData();
            retrofit2.Call<ThongTinUser> callback =dataClient.Signin(kh);
            callback.enqueue(new Callback<ThongTinUser>() {
                @Override
                public void onResponse(Call<ThongTinUser> call, Response<ThongTinUser> response) {
                    if(response.isSuccessful()){
                        // move data to destop
                        ThongTinUser thongTinUser=(ThongTinUser) response.body();
                        Intent myIntent = new Intent(log_in.this, destop.class);
                        myIntent.putExtra("username",user);
                        myIntent.putExtra("idUser",thongTinUser.getIdUser());
                        myIntent.putExtra("soLuongTau",thongTinUser.getSLtau());
                        startActivity(myIntent);
                    }
                }
                @Override
                public void onFailure(Call<ThongTinUser> call, Throwable t) {
                    //  Toast.makeText(log_in.this, "Lỗi kết nối.", Toast.LENGTH_SHORT).show();
                    Log.d("BBBB",t.toString()) ;
                }
            });
        }else
            Toast.makeText(this, "Sai tài khoản hoặc mật khẩu.", Toast.LENGTH_SHORT).show();
    }
}
