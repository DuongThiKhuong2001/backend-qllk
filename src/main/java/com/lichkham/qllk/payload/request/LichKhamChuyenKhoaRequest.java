package com.lichkham.qllk.payload.request;

public class LichKhamChuyenKhoaRequest {

    private Integer lichKhamId;
    private Integer chuyenKhoaId;

    public LichKhamChuyenKhoaRequest() {
    }

    public Integer getLichKhamId() {
        return lichKhamId;
    }

    public void setLichKhamId(Integer lichKhamId) {
        this.lichKhamId = lichKhamId;
    }

    public Integer getChuyenKhoaId() {
        return chuyenKhoaId;
    }

    public void setChuyenKhoaId(Integer chuyenKhoaId) {
        this.chuyenKhoaId = chuyenKhoaId;
    }

    public LichKhamChuyenKhoaRequest(Integer lichKhamId, Integer chuyenKhoaId) {
        this.lichKhamId = lichKhamId;
        this.chuyenKhoaId = chuyenKhoaId;
    }

}
