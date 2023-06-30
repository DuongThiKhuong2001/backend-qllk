package com.lichkham.qllk.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "lichkham_chuyenkhoa")
public class LichKhamChuyenKhoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lichKhamId", nullable = false)
    private LichKham lichKham;

    @ManyToOne
    @JoinColumn(name = "chuyenKhoaId", nullable = false)
    private ChuyenKhoa chuyenKhoa;
    private String trangThai;
    public LichKhamChuyenKhoa() {
    }

    public LichKhamChuyenKhoa(Integer id, LichKham lichKham, ChuyenKhoa chuyenKhoa, String trangThai) {
        this.id = id;
        this.lichKham = lichKham;
        this.chuyenKhoa = chuyenKhoa;
        this.trangThai = trangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LichKham getLichKham() {
        return lichKham;
    }

    public void setLichKham(LichKham lichKham) {
        this.lichKham = lichKham;
    }

    public ChuyenKhoa getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(ChuyenKhoa chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }
    // getters and setters
}
