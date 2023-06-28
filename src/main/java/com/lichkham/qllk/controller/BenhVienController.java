package com.lichkham.qllk.controller;
import java.util.List;
import java.util.Optional;

import com.lichkham.qllk.entity.BenhVien;
import com.lichkham.qllk.payload.request.BenhVienRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.BenhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/benhvien")
public class BenhVienController {
    @Autowired
    private BenhVienRepository benhVienRepository;

    @GetMapping
    public ResponseEntity<?> getAllBenhVien() {
        List<BenhVien> benhVienList = benhVienRepository.findAll();
        if (!benhVienList.isEmpty()) {
            return ResponseEntity.ok(benhVienList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No BenhVien found.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createBenhVien(@RequestBody BenhVienRequest benhVienRequest) {
        BenhVien benhVien = new BenhVien();
        benhVien.setTenBenhVien(benhVienRequest.getTenBenhVien());
        benhVien.setDiaChi(benhVienRequest.getDiaChi());
        benhVien.setTuyenBenhVien(benhVienRequest.getTuyenBenhVien());
        benhVien.setSoDienThoai(benhVienRequest.getSoDienThoai());

        benhVienRepository.save(benhVien);

        return ResponseEntity.ok(new MessageResponse("BenhVien created successfully."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBenhVienById(@PathVariable("id") Integer id) {
        Optional<BenhVien> benhVien = benhVienRepository.findById(id);
        if (benhVien.isPresent()) {
            return ResponseEntity.ok(benhVien);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BenhVien not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBenhVien(@PathVariable("id") Integer id, @RequestBody BenhVienRequest benhVienRequest) {
        Optional<BenhVien> existingBenhVienOptional = benhVienRepository.findById(id);
        if (existingBenhVienOptional.isPresent()) {
            BenhVien existingBenhVien = existingBenhVienOptional.get();
            existingBenhVien.setTenBenhVien(benhVienRequest.getTenBenhVien());
            existingBenhVien.setDiaChi(benhVienRequest.getDiaChi());
            existingBenhVien.setTuyenBenhVien(benhVienRequest.getTuyenBenhVien());
            existingBenhVien.setSoDienThoai(benhVienRequest.getSoDienThoai());

            benhVienRepository.save(existingBenhVien);

            return ResponseEntity.ok(new MessageResponse("BenhVien updated successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BenhVien not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBenhVien(@PathVariable("id") Integer id) {
        Optional<BenhVien> existingBenhVienOptional = benhVienRepository.findById(id);
        if (existingBenhVienOptional.isPresent()) {
            BenhVien existingBenhVien = existingBenhVienOptional.get();
            benhVienRepository.delete(existingBenhVien);
            return ResponseEntity.ok(new MessageResponse("BenhVien deleted successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BenhVien not found.");
        }
    }
}
