package com.lichkham.qllk.controller;

import com.lichkham.qllk.entity.*;
import com.lichkham.qllk.payload.request.LichKhamRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/lichkham")
public class LichKhamController {
    @Autowired
    private  LichKhamRepository lichKhamRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  BacSiRepository bacSiRepository;
    @Autowired
    private  HoSoRepository hoSoRepository;
    @Autowired
    private GioTrucRepository gioTrucRepository;


    @GetMapping
    public ResponseEntity<List<LichKham>> getAllLichKham() {
        List<LichKham> lichKhamList = lichKhamRepository.findAll();
        if (!lichKhamList.isEmpty()) {
            return ResponseEntity.ok(lichKhamList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
//    @GetMapping("/bacsi/{id}")
//    public ResponseEntity<List<LichKham>> getLichKhamByBacSiId(@PathVariable("id") Integer id) {
//        List<LichKham> lichKhamList = lichKhamRepository.findByBacSiId(id);
//        if (!lichKhamList.isEmpty()) {
//            return ResponseEntity.ok(lichKhamList);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }


    @PostMapping
    public ResponseEntity<MessageResponse> createLichKham(@RequestBody LichKhamRequest lichKhamRequest) {
        HoSo hoSo = hoSoRepository.findById(lichKhamRequest.getHoSoId()).orElse(null);
        GioTruc gioTruc = gioTrucRepository.findById(lichKhamRequest.getGioTrucId()).orElse(null);
        LichKham lichKham = new LichKham();
        lichKham.setGioTruc(gioTruc);
        lichKham.setHoSo(hoSo);

        lichKhamRepository.save(lichKham);

        return ResponseEntity.ok(new MessageResponse("LichKham created successfully."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LichKham> getLichKhamById(@PathVariable("id") Integer id) {
        Optional<LichKham> lichKhamOptional = lichKhamRepository.findById(id);
        return lichKhamOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateLichKham(@PathVariable("id") Integer id,
                                                          @RequestBody LichKhamRequest lichKhamRequest) {
        Optional<LichKham> lichKhamOptional = lichKhamRepository.findById(id);
        if (lichKhamOptional.isPresent()) {
            HoSo hoSo = hoSoRepository.findById(lichKhamRequest.getHoSoId()).orElse(null);
            GioTruc gioTruc = gioTrucRepository.findById(lichKhamRequest.getGioTrucId()).orElse(null);
            LichKham lichKham = lichKhamOptional.get();
            lichKham.setGioTruc(gioTruc);
            lichKham.setHoSo(hoSo);
            lichKhamRepository.save(lichKham);

            return ResponseEntity.ok(new MessageResponse("LichKham updated successfully."));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteLichKham(@PathVariable("id") Integer id) {
        Optional<LichKham> lichKhamOptional = lichKhamRepository.findById(id);
        if (lichKhamOptional.isPresent()) {
            lichKhamRepository.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("LichKham deleted successfully."));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/danhsach")
    public ResponseEntity<MessageResponse> createBatchLichKham(@RequestBody List<LichKhamRequest> lichKhamRequests) {
        List<LichKham> lichKhamList = new ArrayList<>();

        for (LichKhamRequest lichKhamRequest : lichKhamRequests) {
            HoSo hoSo = hoSoRepository.findById(lichKhamRequest.getHoSoId()).orElse(null);
            GioTruc gioTruc = gioTrucRepository.findById(lichKhamRequest.getGioTrucId()).orElse(null);

            if (hoSo != null && gioTruc != null) {
                LichKham lichKham = new LichKham();
                lichKham.setGioTruc(gioTruc);
                lichKham.setHoSo(hoSo);
                lichKhamList.add(lichKham);
            }
        }

        if (!lichKhamList.isEmpty()) {
            lichKhamRepository.saveAll(lichKhamList);
            return ResponseEntity.ok(new MessageResponse("Batch LichKham created successfully."));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Invalid HoSoId or GioTrucId provided."));
        }
    }

}
