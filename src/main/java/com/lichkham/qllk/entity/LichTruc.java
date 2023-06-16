package com.lichkham.qllk.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lichtruc")
public class LichTruc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bacSiId", nullable = false)
    private BacSi bacSi;

    @Column(name = "ngayTruc", nullable = false)
    private Date ngayTruc;

    @Column(name = "gioTruc", nullable = false)
    private String gioTruc;

    public LichTruc() {
    }

    public LichTruc(Integer id, BacSi bacSi, Date ngayTruc, String gioTruc) {
        this.id = id;
        this.bacSi = bacSi;
        this.ngayTruc = ngayTruc;
        this.gioTruc = gioTruc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BacSi getBacSi() {
        return bacSi;
    }

    public void setBacSi(BacSi bacSi) {
        this.bacSi = bacSi;
    }

    public Date getNgayTruc() {
        return ngayTruc;
    }

    public void setNgayTruc(Date ngayTruc) {
        this.ngayTruc = ngayTruc;
    }

    public String getGioTruc() {
        return gioTruc;
    }

    public void setGioTruc(String gioTruc) {
        this.gioTruc = gioTruc;
    }
    // getters and setters
}
