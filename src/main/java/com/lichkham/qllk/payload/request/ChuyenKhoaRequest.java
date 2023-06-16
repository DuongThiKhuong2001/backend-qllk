package com.lichkham.qllk.payload.request;
public class ChuyenKhoaRequest {
    private Integer id;
    private Integer benhVienId;
    private String tenChuyenKhoa;

    public ChuyenKhoaRequest() {
    }

    public ChuyenKhoaRequest(Integer id, Integer benhVienId, String tenChuyenKhoa) {
        this.id = id;
        this.benhVienId = benhVienId;
        this.tenChuyenKhoa = tenChuyenKhoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBenhVienId() {
        return benhVienId;
    }

    public void setBenhVienId(Integer benhVienId) {
        this.benhVienId = benhVienId;
    }

    public String getTenChuyenKhoa() {
        return tenChuyenKhoa;
    }

    public void setTenChuyenKhoa(String tenChuyenKhoa) {
        this.tenChuyenKhoa = tenChuyenKhoa;
    }

    // Optional: You can override the toString method to print the object's string representation

    @Override
    public String toString() {
        return "ChuyenKhoaRequest{" +
                "id=" + id +
                ", benhVienId=" + benhVienId +
                ", tenChuyenKhoa='" + tenChuyenKhoa + '\'' +
                '}';
    }
}
