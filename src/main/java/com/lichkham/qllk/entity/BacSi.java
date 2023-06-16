package com.lichkham.qllk.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bacsi")
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "chuyenKhoaId", nullable = false)
    private ChuyenKhoa chuyenKhoa;

    @Column(name = "tenBacSi", nullable = false)
    private String tenBacSi;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "giaKham")
    private Integer giaKham;

    @Column(name = "soDienThoai")
    private Integer soDienThoai;

    public BacSi() {
    }

    public BacSi(Integer id, ChuyenKhoa chuyenKhoa, String tenBacSi, String diaChi, Boolean gioiTinh, Integer giaKham, Integer soDienThoai) {
        this.id = id;
        this.chuyenKhoa = chuyenKhoa;
        this.tenBacSi = tenBacSi;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.giaKham = giaKham;
        this.soDienThoai = soDienThoai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChuyenKhoa getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(ChuyenKhoa chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
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
