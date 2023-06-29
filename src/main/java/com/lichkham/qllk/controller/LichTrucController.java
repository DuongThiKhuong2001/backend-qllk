package com.lichkham.qllk.controller;

import com.lichkham.qllk.entity.BacSi;
import com.lichkham.qllk.entity.LichTruc;
import com.lichkham.qllk.payload.request.LichTrucRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.BacSiRepository;
import com.lichkham.qllk.repository.LichTrucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/lichtruc")
public class LichTrucController {
    private final LichTrucRepository lichTrucRepository;
    private final BacSiRepository bacSiRepository;

    @Autowired
    public LichTrucController(LichTrucRepository lichTrucRepository, BacSiRepository bacSiRepository) {
        this.lichTrucRepository = lichTrucRepository;
        this.bacSiRepository = bacSiRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllLichTruc() {
        List<LichTruc> lichTrucList = lichTrucRepository.findAll();
        if (!lichTrucList.isEmpty()) {
            return ResponseEntity.ok(lichTrucList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No LichTruc found.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createLichTruc(@RequestBody LichTrucRequest lichTrucRequest) {
        Optional<BacSi> bacSiOptional = bacSiRepository.findById(lichTrucRequest.getBacSiId());
        if (bacSiOptional.isPresent()) {
            LichTruc lichTruc = new LichTruc();
            lichTruc.setNgayTruc(lichTrucRequest.getNgayTruc());
            lichTruc.setBacSi(bacSiOptional.get());

            lichTrucRepository.save(lichTruc);

            return ResponseEntity.ok(new MessageResponse("Lich truc added successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BacSi not found.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLichTrucById(@PathVariable("id") Integer id) {
        Optional<LichTruc> lichTrucOptional = lichTrucRepository.findById(id);
        if (lichTrucOptional.isPresent()) {
            return ResponseEntity.ok(lichTrucOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LichTruc not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLichTruc(@PathVariable("id") Integer id, @RequestBody LichTrucRequest lichTrucRequest) {
        Optional<LichTruc> existingLichTrucOptional = lichTrucRepository.findById(id);
        if (existingLichTrucOptional.isPresent()) {
            Optional<BacSi> bacSiOptional = bacSiRepository.findById(lichTrucRequest.getBacSiId());
            if (bacSiOptional.isPresent()) {
                LichTruc existingLichTruc = existingLichTrucOptional.get();
                existingLichTruc.setNgayTruc(lichTrucRequest.getNgayTruc());
                existingLichTruc.setBacSi(bacSiOptional.get());

                lichTrucRepository.save(existingLichTruc);

                return ResponseEntity.ok(new MessageResponse("LichTruc updated successfully."));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BacSi not found.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LichTruc not found.");
        }
    }

    @GetMapping("/bacsi/{bacSiId}")
    public ResponseEntity<?> getLichTrucByBacSiId(@PathVariable("bacSiId") Integer bacSiId) {
        Optional<BacSi> bacSiOptional = bacSiRepository.findById(bacSiId);
        if (bacSiOptional.isPresent()) {
            List<LichTruc> lichTrucList = lichTrucRepository.findByBacSiId(bacSiId);
            if (!lichTrucList.isEmpty()) {
                return ResponseEntity.ok(lichTrucList);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No LichTruc found for the given BacSi.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BacSi not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLichTruc(@PathVariable("id") Integer id) {
        Optional<LichTruc> existingLichTrucOptional = lichTrucRepository.findById(id);
        if (existingLichTrucOptional.isPresent()) {
            LichTruc existingLichTruc = existingLichTrucOptional.get();
            lichTrucRepository.delete(existingLichTruc);
            return ResponseEntity.ok(new MessageResponse("LichTruc deleted successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LichTruc not found.");
        }
    }
}
