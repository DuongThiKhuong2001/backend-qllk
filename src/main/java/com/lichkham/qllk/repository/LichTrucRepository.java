package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.LichTruc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LichTrucRepository extends JpaRepository<LichTruc, Integer> {
    List<LichTruc> findByBacSiId(Integer bacSiId);

}
