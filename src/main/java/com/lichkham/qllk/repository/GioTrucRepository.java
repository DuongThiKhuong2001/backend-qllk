package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.GioTruc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioTrucRepository extends JpaRepository<GioTruc, Integer> {
    List<GioTruc> findByLichTrucId(Integer lichTrucId);
    List<GioTruc> findByTrangThai(String trangThai);
}