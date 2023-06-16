package com.lichkham.qllk.payload.request;

import java.util.Date;

public class LichTrucRequest {

    private Integer bacSiId;
    private Date ngayTruc;
    private String gioTruc;

    public Integer getBacSiId() {
        return bacSiId;
    }

    public void setBacSiId(Integer bacSiId) {
        this.bacSiId = bacSiId;
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
}
