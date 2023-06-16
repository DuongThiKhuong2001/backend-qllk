package com.lichkham.qllk.payload.request;

public class BacSiRequest {
    private Integer chuyenKhoaId;
    private String tenBacSi;
    private String diaChi;
    private Boolean gioiTinh;
    private Integer giaKham;
    private Integer soDienThoai;

    public BacSiRequest() {
    }

    public BacSiRequest(Integer chuyenKhoaId, String tenBacSi, String diaChi, Boolean gioiTinh, Integer giaKham, Integer soDienThoai) {
        this.chuyenKhoaId = chuyenKhoaId;
        this.tenBacSi = tenBacSi;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.giaKham = giaKham;
        this.soDienThoai = soDienThoai;
    }

    public Integer getChuyenKhoaId() {
        return chuyenKhoaId;
    }

    public void setChuyenKhoaId(Integer chuyenKhoaId) {
        this.chuyenKhoaId = chuyenKhoaId;
    }

    public String getTenBacSi() {
        return tenBacSi;
    }

    public void setTenBacSi(String tenBacSi) {
        this.tenBacSi = tenBacSi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getGiaKham() {
        return giaKham;
    }

    public void setGiaKham(Integer giaKham) {
        this.giaKham = giaKham;
    }

    public Integer getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(Integer soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    // getters and setters
}
