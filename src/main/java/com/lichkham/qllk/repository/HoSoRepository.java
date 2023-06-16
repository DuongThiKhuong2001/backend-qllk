package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.HoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoSoRepository extends JpaRepository<HoSo, Integer> {
    List<HoSo> findHoSoByUserId(Integer userId);
}
