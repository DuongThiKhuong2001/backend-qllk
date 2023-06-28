package com.lichkham.qllk.controller;

import com.lichkham.qllk.entity.ChuyenKhoa;
import com.lichkham.qllk.entity.LichKham;
import com.lichkham.qllk.entity.LichKhamChuyenKhoa;
import com.lichkham.qllk.payload.request.LichKhamChuyenKhoaRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.ChuyenKhoaRepository;
import com.lichkham.qllk.repository.LichKhamChuyenKhoaRepository;
import com.lichkham.qllk.repository.LichKhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/lichkhamchuyenkhoa")
public class LichKhamChuyenKhoaController {

    @Autowired
    private LichKhamChuyenKhoaRepository lichKhamChuyenKhoaRepository;

    @Autowired
    private LichKhamRepository lichKhamRepository;

    @Autowired
    private ChuyenKhoaRepository chuyenKhoaRepository;

    @GetMapping
    public ResponseEntity<?> getAllLichKhamChuyenKhoa() {
        List<LichKhamChuyenKhoa> lichKhamChuyenKhoaList = lichKhamChuyenKhoaRepository.findAll();
        if (!lichKhamChuyenKhoaList.isEmpty()) {
            return ResponseEntity.ok(lichKhamChuyenKhoaList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No LichKhamChuyenKhoa found.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createLichKhamChuyenKhoa(@RequestBody LichKhamChuyenKhoaRequest lichKhamChuyenKhoaRequest) {
        Optional<LichKham> lichKhamOptional = lichKhamRepository.findById(lichKhamChuyenKhoaRequest.getLichKhamId());
        Optional<ChuyenKhoa> chuyenKhoaOptional = chuyenKhoaRepository.findById(lichKhamChuyenKhoaRequest.getChuyenKhoaId());

        if (lichKhamOptional.isPresent() && chuyenKhoaOptional.isPresent()) {
            LichKham lichKham = lichKhamOptional.get();
            ChuyenKhoa chuyenKhoa = chuyenKhoaOptional.get();

            LichKhamChuyenKhoa lichKhamChuyenKhoa = new LichKhamChuyenKhoa();
            lichKhamChuyenKhoa.setLichKham(lichKham);
            lichKhamChuyenKhoa.setChuyenKhoa(chuyenKhoa);

            lichKhamChuyenKhoaRepository.save(lichKhamChuyenKhoa);

            return ResponseEntity.ok(new MessageResponse("LichKhamChuyenKhoa created successfully."));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLichKhamChuyenKhoaById(@PathVariable("id") Integer id) {
        Optional<LichKhamChuyenKhoa> lichKhamChuyenKhoa = lichKhamChuyenKhoaRepository.findById(id);
        if (lichKhamChuyenKhoa.isPresent()) {
            return ResponseEntity.ok(lichKhamChuyenKhoa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LichKhamChuyenKhoa not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLichKhamChuyenKhoa(@PathVariable("id") Integer id, @RequestBody LichKhamChuyenKhoaRequest lichKhamChuyenKhoaRequest) {
        Optional<LichKhamChuyenKhoa> existingLichKhamChuyenKhoaOptional = lichKhamChuyenKhoaRepository.findById(id);
        Optional<LichKham> lichKhamOptional = lichKhamRepository.findById(lichKhamChuyenKhoaRequest.getLichKhamId());
        Optional<ChuyenKhoa> chuyenKhoaOptional = chuyenKhoaRepository.findById(lichKhamChuyenKhoaRequest.getChuyenKhoaId());

        if (existingLichKhamChuyenKhoaOptional.isPresent() && lichKhamOptional.isPresent() && chuyenKhoaOptional.isPresent()) {
            LichKhamChuyenKhoa existingLichKhamChuyenKhoa = existingLichKhamChuyenKhoaOptional.get();
            LichKham lichKham = lichKhamOptional.get();
            ChuyenKhoa chuyenKhoa = chuyenKhoaOptional.get();

            existingLichKhamChuyenKhoa.setLichKham(lichKham);
            existingLichKhamChuyenKhoa.setChuyenKhoa(chuyenKhoa);

            lichKhamChuyenKhoaRepository.save(existingLichKhamChuyenKhoa);

            return ResponseEntity.ok(new MessageResponse("LichKhamChuyenKhoa updated successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LichKhamChuyenKhoa not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLichKhamChuyenKhoa(@PathVariable("id") Integer id) {
        Optional<LichKhamChuyenKhoa> existingLichKhamChuyenKhoaOptional = lichKhamChuyenKhoaRepository.findById(id);
        if (existingLichKhamChuyenKhoaOptional.isPresent()) {
            LichKhamChuyenKhoa existingLichKhamChuyenKhoa = existingLichKhamChuyenKhoaOptional.get();
            lichKhamChuyenKhoaRepository.delete(existingLichKhamChuyenKhoa);
            return ResponseEntity.ok(new MessageResponse("LichKhamChuyenKhoa deleted successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LichKhamChuyenKhoa not found.");
        }
    }
    @GetMapping("/lichkham/{lichKhamId}/chuyenkhoa/{chuyenKhoaId}")
    public ResponseEntity<?> getLichKhamChuyenKhoaByLichKhamAndChuyenKhoa(
            @PathVariable("lichKhamId") Integer lichKhamId,
            @PathVariable("chuyenKhoaId") Integer chuyenKhoaId
    ) {
        Optional<LichKham> lichKhamOptional = lichKhamRepository.findById(lichKhamId);
        Optional<ChuyenKhoa> chuyenKhoaOptional = chuyenKhoaRepository.findById(chuyenKhoaId);

        if (lichKhamOptional.isPresent() && chuyenKhoaOptional.isPresent()) {
            LichKham lichKham = lichKhamOptional.get();
            ChuyenKhoa chuyenKhoa = chuyenKhoaOptional.get();

            Optional<LichKhamChuyenKhoa> lichKhamChuyenKhoa = lichKhamChuyenKhoaRepository
                    .findByLichKhamAndChuyenKhoa(lichKham, chuyenKhoa);

            if (lichKhamChuyenKhoa.isPresent()) {
                return ResponseEntity.ok(lichKhamChuyenKhoa);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("LichKhamChuyenKhoa not found for the given LichKham and ChuyenKhoa.");
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
