package com.lichkham.qllk.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lichkham")
public class LichKham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bacSiId", nullable = false)
    private BacSi bacSi;

    @Column(name = "ngayKham", nullable = false)
    private Date ngayKham;

    @Column(name = "gioKham", nullable = false)
    private String gioKham;

    @ManyToOne
    @JoinColumn(name = "hosoId", nullable = false)
    private HoSo hoSo;

    public LichKham() {
    }
    @Column(name = "mota")
    private String moTa;

    public LichKham(Integer id, User user, BacSi bacSi, Date ngayKham, String gioKham, HoSo hoSo, String moTa) {
        this.id = id;
        this.user = user;
        this.bacSi = bacSi;
        this.ngayKham = ngayKham;
        this.gioKham = gioKham;
        this.hoSo = hoSo;
        this.moTa= moTa;
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

    public BacSi getBacSi() {
        return bacSi;
    }

    public void setBacSi(BacSi bacSi) {
        this.bacSi = bacSi;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getGioKham() {
        return gioKham;
    }

    public void setGioKham(String gioKham) {
        this.gioKham = gioKham;
    }

    public HoSo getHoSo() {
        return hoSo;
    }

    public void setHoSo(HoSo hoSo) {
        this.hoSo = hoSo;
    }
    // getters and setters

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LichKham(String moTa) {
        this.moTa = moTa;
    }
}
