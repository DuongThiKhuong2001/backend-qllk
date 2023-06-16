package com.lichkham.qllk.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chuyenkhoa")
public class ChuyenKhoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "benhVienId", nullable = false)
    private BenhVien benhVien;

    @Column(name = "tenChuyenKhoa", nullable = false)
    private String tenChuyenKhoa;

    public ChuyenKhoa() {
    }

    public ChuyenKhoa(Integer id, BenhVien benhVien, String tenChuyenKhoa) {
        this.id = id;
        this.benhVien = benhVien;
        this.tenChuyenKhoa = tenChuyenKhoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BenhVien getBenhVien() {
        return benhVien;
    }

    public void setBenhVien(BenhVien benhVien) {
        this.benhVien = benhVien;
    }

    public String getTenChuyenKhoa() {
        return tenChuyenKhoa;
    }

    public void setTenChuyenKhoa(String tenChuyenKhoa) {
        this.tenChuyenKhoa = tenChuyenKhoa;
    }
    // getters and setters
}
