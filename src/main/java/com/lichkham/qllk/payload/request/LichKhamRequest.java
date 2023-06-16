package com.lichkham.qllk.payload.request;

import java.util.Date;

public class LichKhamRequest {
    private Integer userId;
    private Integer bacSiId;
    private Integer hoSoId;
    private Date ngayKham;
    private String gioKham;
    private String moTa;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBacSiId() {
        return bacSiId;
    }

    public void setBacSiId(Integer bacSiId) {
        this.bacSiId = bacSiId;
    }

    public Integer getHoSoId() {
        return hoSoId;
    }

    public void setHoSoId(Integer hoSoId) {
        this.hoSoId = hoSoId;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LichKhamRequest(String moTa) {
        this.moTa = moTa;
    }

    public LichKhamRequest() {
    }
}
