package com.lichkham.qllk.payload.request;

import java.util.Date;

public class GioTrucRequest {
    private Integer lichTrucId;
    private String gioTruc;

    public Integer getLichTrucId() {
        return lichTrucId;
    }

    public void setLichTrucId(Integer lichTrucId) {
        this.lichTrucId = lichTrucId;
    }

    public String getGioTruc() {
        return gioTruc;
    }

    public void setGioTruc(String gioTruc) {
        this.gioTruc = gioTruc;
    }
}
