package com.example.boatcheck;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Boat implements Parcelable {

    @SerializedName("IDTau")
    @Expose
    private String iDTau;
    @SerializedName("TenTau")
    @Expose
    private String tenTau;
    @SerializedName("ChieuCao")
    @Expose
    private String chieuCao;
    @SerializedName("ChieuRong")
    @Expose
    private String chieuRong;
    @SerializedName("CanNangKhongTai")
    @Expose
    private String canNangKhongTai;
    @SerializedName("ChieuCaoDay")
    @Expose
    private String chieuCaoDay;
    @SerializedName("TheTichTau")
    @Expose
    private String theTichTau;
    @SerializedName("ViTriX")
    @Expose
    private String viTriX;
    @SerializedName("ViTriY")
    @Expose
    private String viTriY;
    @SerializedName("TrangThai")
    @Expose
    private String trangThai;
    @SerializedName("IdUser")
    @Expose
    private String idUser;
    @SerializedName("IdGPS")
    @Expose
    private String idGPS;

    /**
     * No args constructor for use in serialization
     *
     */
    public Boat() {
    }

    /**
     *
     * @param idUser
     * @param chieuCao
     * @param canNangKhongTai
     * @param trangThai
     * @param chieuCaoDay
     * @param idGPS
     * @param iDTau
     * @param chieuRong
     * @param viTriY
     * @param theTichTau
     * @param viTriX
     * @param tenTau
     */
    public Boat(String iDTau, String tenTau, String chieuCao, String chieuRong, String canNangKhongTai, String chieuCaoDay, String theTichTau, String viTriX, String viTriY, String trangThai, String idUser, String idGPS) {
        super();
        this.iDTau = iDTau;
        this.tenTau = tenTau;
        this.chieuCao = chieuCao;
        this.chieuRong = chieuRong;
        this.canNangKhongTai = canNangKhongTai;
        this.chieuCaoDay = chieuCaoDay;
        this.theTichTau = theTichTau;
        this.viTriX = viTriX;
        this.viTriY = viTriY;
        this.trangThai = trangThai;
        this.idUser = idUser;
        this.idGPS = idGPS;
    }

    public Boat(String iDTau, String chieuCao, String chieuRong, String canNangKhongTai, String chieuCaoDay, String theTichTau, String idUser) {
        this.iDTau = iDTau;
        this.chieuCao = chieuCao;
        this.chieuRong = chieuRong;
        this.canNangKhongTai = canNangKhongTai;
        this.chieuCaoDay = chieuCaoDay;
        this.theTichTau = theTichTau;
        this.idUser = idUser;
    }

    protected Boat(Parcel in) {
        iDTau = in.readString();
        tenTau = in.readString();
        chieuCao = in.readString();
        chieuRong = in.readString();
        canNangKhongTai = in.readString();
        chieuCaoDay = in.readString();
        theTichTau = in.readString();
        viTriX = in.readString();
        viTriY = in.readString();
        trangThai = in.readString();
        idUser = in.readString();
        idGPS = in.readString();
    }

    public static final Creator<Boat> CREATOR = new Creator<Boat>() {
        @Override
        public Boat createFromParcel(Parcel in) {
            return new Boat(in);
        }

        @Override
        public Boat[] newArray(int size) {
            return new Boat[size];
        }
    };

    public String getIDTau() {
        return iDTau;
    }

    public void setIDTau(String iDTau) {
        this.iDTau = iDTau;
    }

    public String getTenTau() {
        return tenTau;
    }

    public void setTenTau(String tenTau) {
        this.tenTau = tenTau;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(String chieuRong) {
        this.chieuRong = chieuRong;
    }

    public String getCanNangKhongTai() {
        return canNangKhongTai;
    }

    public void setCanNangKhongTai(String canNangKhongTai) {
        this.canNangKhongTai = canNangKhongTai;
    }

    public String getChieuCaoDay() {
        return chieuCaoDay;
    }

    public void setChieuCaoDay(String chieuCaoDay) {
        this.chieuCaoDay = chieuCaoDay;
    }

    public String getTheTichTau() {
        return theTichTau;
    }

    public void setTheTichTau(String theTichTau) {
        this.theTichTau = theTichTau;
    }

    public String getViTriX() {
        return viTriX;
    }

    public void setViTriX(String viTriX) {
        this.viTriX = viTriX;
    }

    public String getViTriY() {
        return viTriY;
    }

    public void setViTriY(String viTriY) {
        this.viTriY = viTriY;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdGPS() {
        return idGPS;
    }

    public void setIdGPS(String idGPS) {
        this.idGPS = idGPS;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Boat{" +
          "tenTau='" + tenTau + '\'' +
          '}';
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iDTau);
        dest.writeString(tenTau);
        dest.writeString(chieuCao);
        dest.writeString(chieuRong);
        dest.writeString(canNangKhongTai);
        dest.writeString(chieuCaoDay);
        dest.writeString(theTichTau);
        dest.writeString(viTriX);
        dest.writeString(viTriY);
        dest.writeString(trangThai);
        dest.writeString(idUser);
        dest.writeString(idGPS);
    }
}