package com.example.boatcheck;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("TenKH")
    @Expose
    private String TenKH;
    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("Gmail")
    @Expose
    private String gmail;
    /**
     * No args constructor for use in serialization
     */
    public User() {
    }

    public User(String tenKH, String password, String gmail) {
        TenKH = tenKH;
        this.password = password;
        this.gmail = gmail;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    /**
     * @param password
     * @param TenKH
     */

    public User(String TenKH, String password) {
        super();
        this.TenKH = TenKH;
        this.password = password;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        this.TenKH = tenKH;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}