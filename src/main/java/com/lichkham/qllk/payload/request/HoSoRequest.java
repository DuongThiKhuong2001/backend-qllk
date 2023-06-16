package com.lichkham.qllk.payload.request;

import java.util.Date;

public class HoSoRequest {
    private String ten;
    private Date ngaySinh;
    private String gioiTinh;
    private Integer userId;
    private Long soDienThoai;
    private String ngheNghiep;
    private Long cmnd;
    private String danToc;
    private String diaChi;
    private String email;
    // Constructors, getters, and setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Long getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(Long soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public Long getCmnd() {
        return cmnd;
    }

    public void setCmnd(Long cmnd) {
        this.cmnd = cmnd;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public HoSoRequest() {
    }

    public HoSoRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
