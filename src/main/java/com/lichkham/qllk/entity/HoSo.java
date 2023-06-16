package com.lichkham.qllk.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hoso")
public class HoSo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "ten", nullable = false)
    private String ten;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "soDienThoai")
    private Long soDienThoai;

    @Column(name = "ngheNghiep")
    private String ngheNghiep;

    @Column(name = "cmnd")
    private Long cmnd;

    @Column(name = "danToc")
    private String danToc;

    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "email")
    private String email;

    public HoSo() {
    }

    public HoSo(Integer id, User user, String ten, Date ngaySinh, String gioiTinh, Long soDienThoai, String ngheNghiep, Long cmnd, String danToc, String diaChi,String email) {
        this.id = id;
        this.user = user;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.ngheNghiep = ngheNghiep;
        this.cmnd = cmnd;
        this.danToc = danToc;
        this.diaChi = diaChi;
        this.email = email;
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

    public HoSo(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // getters and setters
}
