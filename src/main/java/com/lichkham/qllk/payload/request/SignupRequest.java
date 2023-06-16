package com.lichkham.qllk.payload.request;

public class SignupRequest {
  private String email;
  private String taiKhoan;
  private String matKhau;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTaiKhoan() {
    return taiKhoan;
  }

  public void setTaiKhoan(String taiKhoan) {
    this.taiKhoan = taiKhoan;
  }

  public String getMatKhau() {
    return matKhau;
  }

  public void setMatKhau(String matKhau) {
    this.matKhau = matKhau;
  }
}
