package com.example.boatcheck;

import android.content.Intent;
import android.os.Bundle;
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

public class signup extends AppCompatActivity {
    EditText editGmail, editUserNew, editPassNew, editConPassNew;
    Button btnRegister, btnBackLogin;
    String newUser,newPassword,newPassCu,newGmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // mapping
        mapping();
        // set
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        btnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this, log_in.class));
            }
        });

    }
    // mapping
    private void mapping() {
        editGmail = (EditText) findViewById(R.id.editGmail);
        editUserNew = (EditText) findViewById(R.id.editUserNew);
        editPassNew = (EditText) findViewById(R.id.editPassNew);
        editConPassNew = (EditText) findViewById(R.id.editConPassNew);
        btnRegister = (Button) findViewById(R.id.btnResgister);
        btnBackLogin = (Button) findViewById(R.id.btnBackLogin);
    }

    // requset array to mysql
/*    private void sendData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String s = response.toString();
                        if (s.equals("SUCCESS")) {
                            Toast.makeText(signup.this, "CREATE SUCCESS.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(signup.this, log_in.class));
                        } else {
                            Toast.makeText(signup.this, "ERROR.", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("TenKH", editUserNew.getText().toString().trim());
                params.put("Pass", editConPassNew.getText().toString().trim());
                params.put("gmail", editGmail.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }*/

    /**
     * dang ky tai khoan va day len server
     */
    private void createUser() {
        newUser=editUserNew.getText().toString();
        newGmail=editGmail.getText().toString();
        newPassword=editPassNew.getText().toString();
        newPassCu=editConPassNew.getText().toString();


        if(newUser.length()>0
                && newPassword.length()>0
                && newGmail.length()>0
                && newPassCu.length()>0
                && newPassword.equals(newPassCu)){
            User user=new User(newUser,newPassword,newGmail);
            DataClient dataClient= APIUtils.getData();
            retrofit2.Call<String> callback = dataClient.SignUp(user);
            callback.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()){
                       if(response.body().equals("SUCCESS")) {
                           Toast.makeText(signup.this, "Đăng ký tài khoản thành công.", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(signup.this,signup.class));
                       }else{
                           Toast.makeText(signup.this, "Lỗi kết nối, Vui lòng đăng ký tài lại khoản.", Toast.LENGTH_SHORT).show();
                       } // server cua ong loi roi
                        // cho to xem code server cua ong
                    }else{
                        Toast.makeText(signup.this, "Lỗi kết nối, Vui lòng đăng ký tài lại khoản.", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(signup.this, "Lỗi kết nối, Vui lòng đăng ký tài lại khoản.", Toast.LENGTH_SHORT).show();
                    // ham login cua ong dau?
                }
            });
        } else {
            Toast.makeText(signup.this, "Lỗi kết nối, Vui lòng đăng ký tài khoản.", Toast.LENGTH_SHORT).show();
        }

    }
}
