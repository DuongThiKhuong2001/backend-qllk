package com.lichkham.qllk.payload.request;

public class BenhVienRequest {
    private String tenBenhVien;
    private String diaChi;
    private String tuyenBenhVien;
    private Integer soDienThoai;

    public BenhVienRequest() {
    }

    public BenhVienRequest(String tenBenhVien, String diaChi, String tuyenBenhVien, Integer soDienThoai) {
        this.tenBenhVien = tenBenhVien;
        this.diaChi = diaChi;
        this.tuyenBenhVien = tuyenBenhVien;
        this.soDienThoai = soDienThoai;
    }

    public String getTenBenhVien() {
        return tenBenhVien;
    }

    public void setTenBenhVien(String tenBenhVien) {
        this.tenBenhVien = tenBenhVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTuyenBenhVien() {
        return tuyenBenhVien;
    }

    public void setTuyenBenhVien(String tuyenBenhVien) {
        this.tuyenBenhVien = tuyenBenhVien;
    }

    public Integer getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(Integer soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    // getters and setters


}
