package com.example.boatcheck.ConfigRetrofit;

import com.example.boatcheck.Boat;
import com.example.boatcheck.Emulator.Gialap;
import com.example.boatcheck.Makhachhang;
import com.example.boatcheck.ThongTinUser;
import com.example.boatcheck.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DataClient {

    @POST("Signin")
    Call<ThongTinUser> Signin(@Body User user);

    @POST("Signup")
    Call<String> SignUp(@Body User user);

    @FormUrlEncoded
    @POST("LayThongTinUser")
    Call<String> PostUser
            (@Field("IDUser") String idUser);


    @POST("AddBoat")
    Call<String> addBoat
      (@Body Boat boat);


    @POST("ListBoat")
    Call<List<Boat>> listboat
            (@Body Makhachhang makhachhang);

    @POST("ChiTieuTau")
    Call<String> trangThaiTau
            (@Field("IdTau") String idTau);

    @POST("updateCau")
    Call<String> gialapcau
      (@Body Gialap gialap);
}
