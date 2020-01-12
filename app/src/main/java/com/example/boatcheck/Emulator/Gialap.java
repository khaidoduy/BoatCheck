package com.example.boatcheck.Emulator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gialap {

  @SerializedName("IDCau")
  @Expose
  private String iDCau;
  @SerializedName("MucNuocHienTai")
  @Expose
  private String mucNuocHienTai;

  /**
   * No args constructor for use in serialization
   *
   */
  public Gialap() {
  }

  /**
   *
   * @param iDCau
   * @param mucNuocHienTai
   */
  public Gialap(String iDCau, String mucNuocHienTai) {
    super();
    this.iDCau = iDCau;
    this.mucNuocHienTai = mucNuocHienTai;
  }

  public String getIDCau() {
    return iDCau;
  }

  public void setIDCau(String iDCau) {
    this.iDCau = iDCau;
  }

  public String getMucNuocHienTai() {
    return mucNuocHienTai;
  }

  public void setMucNuocHienTai(String mucNuocHienTai) {
    this.mucNuocHienTai = mucNuocHienTai;
  }

}