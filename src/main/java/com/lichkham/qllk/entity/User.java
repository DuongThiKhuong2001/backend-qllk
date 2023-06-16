package com.lichkham.qllk.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "taiKhoan", nullable = false)
    private String taiKhoan;

    @Column(name = "matKhau", nullable = false)
    private String matKhau;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING) // Thêm annotation để xác định kiểu ENUM
    @Column(name = "quyen", nullable = false)
    private QuyenEnum quyen;

    public User() {
    }

    public User(Integer id, String taiKhoan, String matKhau, String email, QuyenEnum quyen) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.quyen = quyen;
    }

    public User(String taiKhoan, String email, String matKhau, QuyenEnum quyen) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.quyen = quyen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public QuyenEnum getQuyen() {
        return quyen;
    }

    public void setQuyen(QuyenEnum quyen) {
        this.quyen = quyen;
    }
    // getters and setters
}