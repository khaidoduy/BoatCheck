package com.example.boatcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThongTinUser {

  @SerializedName("IdUser")
  @Expose
  private String idUser;
  @SerializedName("SLtau")
  @Expose
  private String sLtau;

  /**
   * No args constructor for use in serialization
   *
   */
  public ThongTinUser() {
  }

  /**
   *
   * @param idUser
   * @param sLtau
   */
  public ThongTinUser(String idUser, String sLtau) {
    super();
    this.idUser = idUser;
    this.sLtau = sLtau;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public String getSLtau() {
    return sLtau;
  }

  public void setSLtau(String sLtau) {
    this.sLtau = sLtau;
  }

}