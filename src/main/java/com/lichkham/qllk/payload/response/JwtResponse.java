package com.lichkham.qllk.payload.response;

import com.lichkham.qllk.entity.QuyenEnum;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Integer id;
  private String taikhoan;
  private String email;
  private String quyen;

  public JwtResponse(String accessToken, Integer id, String username, String email, String roles) {
    this.token = accessToken;
    this.id = id;
    this.taikhoan = username;
    this.email = email;
    this.quyen = roles;
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTaikhoan() {
    return taikhoan;
  }

  public void setTaikhoan(String taikhoan) {
    this.taikhoan = taikhoan;
  }

  public String getQuyen() {
    return quyen;
  }

  public void setQuyen(String quyen) {
    this.quyen = quyen;
  }
}
