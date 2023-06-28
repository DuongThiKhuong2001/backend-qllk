package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.BenhVien;
import com.lichkham.qllk.entity.ChuyenKhoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ChuyenKhoaRepository extends JpaRepository<ChuyenKhoa, Integer> {
    List<ChuyenKhoa> findByBenhVien(BenhVien benhVien);
}
