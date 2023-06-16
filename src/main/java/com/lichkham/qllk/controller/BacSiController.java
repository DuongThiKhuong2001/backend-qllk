package com.lichkham.qllk.controller;

import com.lichkham.qllk.entity.BacSi;
import com.lichkham.qllk.entity.ChuyenKhoa;
import com.lichkham.qllk.payload.request.BacSiRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.BacSiRepository;
import com.lichkham.qllk.repository.ChuyenKhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/bacsi")
public class BacSiController {
    private final BacSiRepository bacSiRepository;
    private final ChuyenKhoaRepository chuyenKhoaRepository;

    @Autowired
    public BacSiController(BacSiRepository bacSiRepository, ChuyenKhoaRepository chuyenKhoaRepository) {
        this.bacSiRepository = bacSiRepository;
        this.chuyenKhoaRepository = chuyenKhoaRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllBacSi() {
        List<BacSi> bacSiList = bacSiRepository.findAll();
        if (!bacSiList.isEmpty()) {
            return ResponseEntity.ok(bacSiList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No BacSi found.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createBacSi(@RequestBody BacSiRequest bacSiRequest) {
        Optional<ChuyenKhoa> chuyenKhoaOptional = chuyenKhoaRepository.findById(bacSiRequest.getChuyenKhoaId());
        if (chuyenKhoaOptional.isPresent()) {
            BacSi bacSi = new BacSi();
            bacSi.setChuyenKhoa(chuyenKhoaOptional.get());
            bacSi.setTenBacSi(bacSiRequest.getTenBacSi());
            bacSi.setDiaChi(bacSiRequest.getDiaChi());
            bacSi.setGioiTinh(bacSiRequest.getGioiTinh());
            bacSi.setGiaKham(bacSiRequest.getGiaKham());
            bacSi.setSoDienThoai(bacSiRequest.getSoDienThoai());

            bacSiRepository.save(bacSi);

            return ResponseEntity.ok(new MessageResponse("BacSi created successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ChuyenKhoa not found.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBacSiById(@PathVariable("id") Integer id) {
        Optional<BacSi> bacSi = bacSiRepository.findById(id);
        if (bacSi.isPresent()) {
            return ResponseEntity.ok(bacSi);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BacSi not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBacSi(@PathVariable("id") Integer id, @RequestBody BacSiRequest bacSiRequest) {
        Optional<BacSi> existingBacSiOptional = bacSiRepository.findById(id);
        if (existingBacSiOptional.isPresent()) {
            Optional<ChuyenKhoa> chuyenKhoaOptional = chuyenKhoaRepository.findById(bacSiRequest.getChuyenKhoaId());
            if (chuyenKhoaOptional.isPresent()) {
                BacSi existingBacSi = existingBacSiOptional.get();
                existingBacSi.setChuyenKhoa(chuyenKhoaOptional.get());
                existingBacSi.setTenBacSi(bacSiRequest.getTenBacSi());
                existingBacSi.setDiaChi(bacSiRequest.getDiaChi());
                existingBacSi.setGioiTinh(bacSiRequest.getGioiTinh());
                existingBacSi.setGiaKham(bacSiRequest.getGiaKham());
                existingBacSi.setSoDienThoai(bacSiRequest.getSoDienThoai());

                bacSiRepository.save(existingBacSi);

                return ResponseEntity.ok(new MessageResponse("BacSi updated successfully."));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ChuyenKhoa not found.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BacSi not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBacSi(@PathVariable("id") Integer id) {
        Optional<BacSi> existingBacSiOptional = bacSiRepository.findById(id);
        if (existingBacSiOptional.isPresent()) {
            BacSi existingBacSi = existingBacSiOptional.get();
            bacSiRepository.delete(existingBacSi);
            return ResponseEntity.ok(new MessageResponse("BacSi deleted successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BacSi not found.");
        }
    }
}
