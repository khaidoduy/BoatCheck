package com.example.boatcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Makhachhang {

  @SerializedName("IDUser")
  @Expose
  private String iDUser;

  /**
   * No args constructor for use in serialization
   *
   */
  public Makhachhang() {
  }

  /**
   *
   * @param iDUser
   */
  public Makhachhang(String iDUser) {
    super();
    this.iDUser = iDUser;
  }

  public String getIDUser() {
    return iDUser;
  }

  public void setIDUser(String iDUser) {
    this.iDUser = iDUser;
  }

}