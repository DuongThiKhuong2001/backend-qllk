package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.LichTruc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LichTrucRepository extends JpaRepository<LichTruc, Integer> {
    List<LichTruc> findByBacSiId(Integer bacSiId);
}
