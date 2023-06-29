package com.lichkham.qllk.controller;

import com.lichkham.qllk.entity.GioTruc;
import com.lichkham.qllk.entity.LichTruc;
import com.lichkham.qllk.payload.request.GioTrucRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.GioTrucRepository;
import com.lichkham.qllk.repository.LichTrucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/giotruc")
public class GioTrucController {
    private final GioTrucRepository gioTrucRepository;
    private final LichTrucRepository lichTrucRepository;

    @Autowired
    public GioTrucController(GioTrucRepository gioTrucRepository, LichTrucRepository lichTrucRepository) {
        this.gioTrucRepository = gioTrucRepository;
        this.lichTrucRepository = lichTrucRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllGioTruc() {
        List<GioTruc> gioTrucList = gioTrucRepository.findAll();
        if (!gioTrucList.isEmpty()) {
            return ResponseEntity.ok(gioTrucList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No GioTruc found.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createGioTruc(@RequestBody GioTrucRequest gioTrucRequest) {
        Optional<LichTruc> lichTrucOptional = lichTrucRepository.findById(gioTrucRequest.getLichTrucId());
        if (lichTrucOptional.isPresent()) {
            GioTruc gioTruc = new GioTruc();
            gioTruc.setLichTruc(lichTrucOptional.get());
            gioTruc.setGioTruc(gioTrucRequest.getGioTruc());
            gioTrucRepository.save(gioTruc);
            return ResponseEntity.ok(gioTruc);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LichTruc not found.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGioTrucById(@PathVariable("id") Integer id) {
        Optional<GioTruc> gioTrucOptional = gioTrucRepository.findById(id);
        if (gioTrucOptional.isPresent()) {
            return ResponseEntity.ok(gioTrucOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("GioTruc not found.");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGioTruc(@PathVariable("id") Integer id) {
        Optional<GioTruc> existingGioTrucOptional = gioTrucRepository.findById(id);
        if (existingGioTrucOptional.isPresent()) {
            GioTruc existingGioTruc = existingGioTrucOptional.get();
            gioTrucRepository.delete(existingGioTruc);

            return ResponseEntity.ok(new MessageResponse("GioTruc deleted successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("GioTruc not found.");
        }
    }
    @GetMapping("/lichtruc/{lichTrucId}")
    public ResponseEntity<?> getGioTrucByLichTrucId(@PathVariable("lichTrucId") Integer lichTrucId) {
        List<GioTruc> gioTrucList = gioTrucRepository.findByLichTrucId(lichTrucId);
        if (!gioTrucList.isEmpty()) {
            return ResponseEntity.ok(gioTrucList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}

