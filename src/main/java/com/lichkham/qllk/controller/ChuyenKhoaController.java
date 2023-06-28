package com.lichkham.qllk.controller;

import com.lichkham.qllk.entity.BenhVien;
import com.lichkham.qllk.entity.ChuyenKhoa;
import com.lichkham.qllk.payload.request.ChuyenKhoaRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.BenhVienRepository;
import com.lichkham.qllk.repository.ChuyenKhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/chuyenkhoa")
public class ChuyenKhoaController {
    @Autowired
    private ChuyenKhoaRepository chuyenKhoaRepository;

    @Autowired
    private BenhVienRepository benhVienRepository;

    @GetMapping
    public ResponseEntity<?> getAllChuyenKhoa() {
        List<ChuyenKhoa> chuyenKhoaList = chuyenKhoaRepository.findAll();
        if (!chuyenKhoaList.isEmpty()) {
            return ResponseEntity.ok(chuyenKhoaList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No ChuyenKhoa found.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createChuyenKhoa(@RequestBody ChuyenKhoaRequest chuyenKhoaRequest) {
        Optional<BenhVien> benhVienOptional = benhVienRepository.findById(chuyenKhoaRequest.getBenhVienId());
        if (benhVienOptional.isPresent()) {
            BenhVien benhVien = benhVienOptional.get();
            ChuyenKhoa chuyenKhoa = new ChuyenKhoa();
            chuyenKhoa.setBenhVien(benhVien);
            chuyenKhoa.setTenChuyenKhoa(chuyenKhoaRequest.getTenChuyenKhoa());

            chuyenKhoaRepository.save(chuyenKhoa);

            return ResponseEntity.ok(new MessageResponse("ChuyenKhoa created successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BenhVien not found.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getChuyenKhoaById(@PathVariable("id") Integer id) {
        Optional<ChuyenKhoa> chuyenKhoaOptional = chuyenKhoaRepository.findById(id);
        if (chuyenKhoaOptional.isPresent()) {
            return ResponseEntity.ok(chuyenKhoaOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ChuyenKhoa not found.");
        }
    }
    @GetMapping("/benhvien/{benhVienId}")
    public ResponseEntity<?> getChuyenKhoaByBenhVienId(@PathVariable("benhVienId") Integer benhVienId) {
        Optional<BenhVien> benhVienOptional = benhVienRepository.findById(benhVienId);
        if (benhVienOptional.isPresent()) {
            BenhVien benhVien = benhVienOptional.get();
            List<ChuyenKhoa> chuyenKhoaList = chuyenKhoaRepository.findByBenhVien(benhVien);
            if (!chuyenKhoaList.isEmpty()) {
                return ResponseEntity.ok(chuyenKhoaList);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No ChuyenKhoa found for the specified BenhVien.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BenhVien not found.");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateChuyenKhoa(@PathVariable("id") Integer id, @RequestBody ChuyenKhoaRequest chuyenKhoaRequest) {
        Optional<ChuyenKhoa> existingChuyenKhoaOptional = chuyenKhoaRepository.findById(id);
        if (existingChuyenKhoaOptional.isPresent()) {
            Optional<BenhVien> benhVienOptional = benhVienRepository.findById(chuyenKhoaRequest.getBenhVienId());
            if (benhVienOptional.isPresent()) {
                BenhVien benhVien = benhVienOptional.get();
                ChuyenKhoa existingChuyenKhoa = existingChuyenKhoaOptional.get();
                existingChuyenKhoa.setBenhVien(benhVien);
                existingChuyenKhoa.setTenChuyenKhoa(chuyenKhoaRequest.getTenChuyenKhoa());

                chuyenKhoaRepository.save(existingChuyenKhoa);

                return ResponseEntity.ok(new MessageResponse("ChuyenKhoa updated successfully."));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BenhVien not found.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ChuyenKhoa not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChuyenKhoa(@PathVariable("id") Integer id) {
        Optional<ChuyenKhoa> existingChuyenKhoaOptional = chuyenKhoaRepository.findById(id);
        if (existingChuyenKhoaOptional.isPresent()) {
            ChuyenKhoa existingChuyenKhoa = existingChuyenKhoaOptional.get();
            chuyenKhoaRepository.delete(existingChuyenKhoa);
            return ResponseEntity.ok(new MessageResponse("ChuyenKhoa deleted successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ChuyenKhoa not found.");
        }
    }
}
