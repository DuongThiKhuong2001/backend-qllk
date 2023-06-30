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
    @JoinColumn(name = "gioTrucId", nullable = false)
    private GioTruc gioTruc;

    @ManyToOne
    @JoinColumn(name = "hosoId", nullable = false)
    private HoSo hoSo;

    public LichKham() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public GioTruc getGioTruc() {
        return gioTruc;
    }

    public LichKham(Integer id,  GioTruc gioTruc, HoSo hoSo) {
        this.id = id;
        this.gioTruc = gioTruc;
        this.hoSo = hoSo;
    }

    public void setGioTruc(GioTruc gioTruc) {
        this.gioTruc = gioTruc;
    }

    public HoSo getHoSo() {
        return hoSo;
    }

    public void setHoSo(HoSo hoSo) {
        this.hoSo = hoSo;
    }
    // getters and setters

}
