package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.ChuyenKhoa;
import com.lichkham.qllk.entity.LichKham;
import com.lichkham.qllk.entity.LichKhamChuyenKhoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LichKhamChuyenKhoaRepository extends JpaRepository<LichKhamChuyenKhoa, Integer> {
    Optional<LichKhamChuyenKhoa> findByLichKhamAndChuyenKhoa(LichKham lichKham, ChuyenKhoa chuyenKhoa);
}
