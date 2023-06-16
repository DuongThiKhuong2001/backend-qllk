package com.lichkham.qllk.controller;

import com.lichkham.qllk.entity.BacSi;
import com.lichkham.qllk.entity.HoSo;
import com.lichkham.qllk.entity.LichKham;
import com.lichkham.qllk.entity.User;
import com.lichkham.qllk.payload.request.LichKhamRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.BacSiRepository;
import com.lichkham.qllk.repository.HoSoRepository;
import com.lichkham.qllk.repository.LichKhamRepository;
import com.lichkham.qllk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/lichkham")
public class LichKhamController {
    private final LichKhamRepository lichKhamRepository;
    private final UserRepository userRepository;
    private final BacSiRepository bacSiRepository;
    private final HoSoRepository hoSoRepository;

    @Autowired
    public LichKhamController(LichKhamRepository lichKhamRepository, UserRepository userRepository,
                              BacSiRepository bacSiRepository, HoSoRepository hoSoRepository) {
        this.lichKhamRepository = lichKhamRepository;
        this.userRepository = userRepository;
        this.bacSiRepository = bacSiRepository;
        this.hoSoRepository = hoSoRepository;
    }

    @GetMapping
    public ResponseEntity<List<LichKham>> getAllLichKham() {
        List<LichKham> lichKhamList = lichKhamRepository.findAll();
        if (!lichKhamList.isEmpty()) {
            return ResponseEntity.ok(lichKhamList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createLichKham(@RequestBody LichKhamRequest lichKhamRequest) {
        User user = userRepository.findById(lichKhamRequest.getUserId()).orElse(null);
        BacSi bacSi = bacSiRepository.findById(lichKhamRequest.getBacSiId()).orElse(null);
        HoSo hoSo = hoSoRepository.findById(lichKhamRequest.getHoSoId()).orElse(null);

        if (user == null || bacSi == null || hoSo == null) {
            return ResponseEntity.badRequest().build();
        }

        LichKham lichKham = new LichKham();
        lichKham.setUser(user);
        lichKham.setBacSi(bacSi);
        lichKham.setNgayKham(lichKhamRequest.getNgayKham());
        lichKham.setGioKham(lichKhamRequest.getGioKham());
        lichKham.setHoSo(hoSo);
        lichKham.setMoTa(lichKhamRequest.getMoTa());

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
            User user = userRepository.findById(lichKhamRequest.getUserId()).orElse(null);
            BacSi bacSi = bacSiRepository.findById(lichKhamRequest.getBacSiId()).orElse(null);
            HoSo hoSo = hoSoRepository.findById(lichKhamRequest.getHoSoId()).orElse(null);

            if (user == null || bacSi == null || hoSo == null) {
                return ResponseEntity.badRequest().build();
            }

            LichKham lichKham = lichKhamOptional.get();
            lichKham.setUser(user);
            lichKham.setBacSi(bacSi);
            lichKham.setNgayKham(lichKhamRequest.getNgayKham());
            lichKham.setGioKham(lichKhamRequest.getGioKham());
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
}
