package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.ChuyenKhoa;
import com.lichkham.qllk.entity.LichKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LichKhamRepository extends JpaRepository<LichKham, Integer> {
    @Query("SELECT l FROM LichKham l WHERE l.hoSo.user.id = :userId")
    List<LichKham> findByUserId(Integer userId);
}
