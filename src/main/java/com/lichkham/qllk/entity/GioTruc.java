package com.lichkham.qllk.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "giotruc")
public class GioTruc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lichTrucId", nullable = false)
    private LichTruc lichTruc;

    @Column(name = "gioTruc", nullable = false)
    private String gioTruc;

    public GioTruc() {
    }

    public GioTruc(Integer id, LichTruc lichTruc, String gioTruc) {
        this.id = id;
        this.lichTruc = lichTruc;
        this.gioTruc = gioTruc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LichTruc getLichTruc() {
        return lichTruc;
    }

    public void setLichTruc(LichTruc lichTruc) {
        this.lichTruc = lichTruc;
    }

    public String getGioTruc() {
        return gioTruc;
    }

    public void setGioTruc(String gioTruc) {
        this.gioTruc = gioTruc;
    }
    // Các phương thức getter và setter
}
