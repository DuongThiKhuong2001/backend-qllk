package com.lichkham.qllk.repository;

import com.lichkham.qllk.entity.BacSi;
import com.lichkham.qllk.entity.ChuyenKhoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
    List<BacSi> findByChuyenKhoa(ChuyenKhoa chuyenKhoa);
}
