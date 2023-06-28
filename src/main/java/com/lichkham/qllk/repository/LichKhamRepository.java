package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.ChuyenKhoa;
import com.lichkham.qllk.entity.LichKham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LichKhamRepository extends JpaRepository<LichKham, Integer> {
    List<LichKham> findByBacSiId(Integer bacSiId);

}
