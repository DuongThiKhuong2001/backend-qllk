package com.lichkham.qllk.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "thanhtoan")
public class ThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lichKhamId", nullable = false)
    private LichKhamChuyenKhoa lichKham;

    @Column(name = "tongTien", nullable = false)
    private BigDecimal tongTien;

    @Column(name = "ngayThanhToan", nullable = false)
    private Date ngayThanhToan;

    public ThanhToan() {
    }
// getters and setters

    public ThanhToan(Integer id, User user, LichKhamChuyenKhoa lichKham, BigDecimal tongTien, Date ngayThanhToan) {
        this.id = id;
        this.user = user;
        this.lichKham = lichKham;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LichKhamChuyenKhoa getLichKham() {
        return lichKham;
    }

    public void setLichKham(LichKhamChuyenKhoa lichKham) {
        this.lichKham = lichKham;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }
}
