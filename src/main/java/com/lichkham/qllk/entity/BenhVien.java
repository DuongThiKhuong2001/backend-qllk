package com.lichkham.qllk.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "benhvien")
public class BenhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenBenhVien", nullable = false)
    private String tenBenhVien;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "tuyenBenhVien")
    private String tuyenBenhVien;

    @Column(name = "soDienThoai")
    private Integer soDienThoai;

    public BenhVien() {
    }

    public BenhVien(Integer id, String tenBenhVien, String diaChi, String tuyenBenhVien, Integer soDienThoai) {
        this.id = id;
        this.tenBenhVien = tenBenhVien;
        this.diaChi = diaChi;
        this.tuyenBenhVien = tuyenBenhVien;
        this.soDienThoai = soDienThoai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
