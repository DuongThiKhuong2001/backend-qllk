package com.lichkham.qllk.controller;

import com.lichkham.qllk.entity.HoSo;
import com.lichkham.qllk.entity.User;
import com.lichkham.qllk.payload.request.HoSoRequest;
import com.lichkham.qllk.payload.response.MessageResponse;
import com.lichkham.qllk.repository.HoSoRepository;
import com.lichkham.qllk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/hoso")
public class HoSoController {
    @Autowired
    private HoSoRepository hoSoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllHoSo() {
        List<HoSo> hoSoList = hoSoRepository.findAll();
        if (!hoSoList.isEmpty()) {
            return ResponseEntity.ok(hoSoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No HoSo found.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createHoSo(@RequestBody HoSoRequest hoSoRequest) {
        User user = userRepository.findById(hoSoRequest.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        HoSo hoSo = new HoSo();
        hoSo.setTen(hoSoRequest.getTen());
        hoSo.setNgaySinh(hoSoRequest.getNgaySinh());
        hoSo.setGioiTinh(hoSoRequest.getGioiTinh());
        hoSo.setSoDienThoai(hoSoRequest.getSoDienThoai());
        hoSo.setNgheNghiep(hoSoRequest.getNgheNghiep());
        hoSo.setCmnd(hoSoRequest.getCmnd());
        hoSo.setDanToc(hoSoRequest.getDanToc());
        hoSo.setDiaChi(hoSoRequest.getDiaChi());
        user.setId(hoSoRequest.getUserId());
        hoSo.setUser(user);
        hoSo.setEmail(hoSoRequest.getEmail());
        hoSoRepository.save(hoSo);

        return ResponseEntity.ok(new MessageResponse("HoSo created successfully."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHoSoById(@PathVariable("id") Integer id) {
        Optional<HoSo> hoSo = hoSoRepository.findById(id);
        if (hoSo.isPresent()) {
            return ResponseEntity.ok(hoSo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HoSo not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateHoSo(@PathVariable("id") Integer id, @RequestBody HoSoRequest hoSoRequest) {
        Optional<HoSo> existingHoSoOptional = hoSoRepository.findById(id);
        if (existingHoSoOptional.isPresent()) {
            HoSo existingHoSo = existingHoSoOptional.get();
            existingHoSo.setTen(hoSoRequest.getTen());
            existingHoSo.setNgaySinh(hoSoRequest.getNgaySinh());
            existingHoSo.setGioiTinh(hoSoRequest.getGioiTinh());
            existingHoSo.setSoDienThoai(hoSoRequest.getSoDienThoai());
            existingHoSo.setNgheNghiep(hoSoRequest.getNgheNghiep());
            existingHoSo.setCmnd(hoSoRequest.getCmnd());
            existingHoSo.setDanToc(hoSoRequest.getDanToc());
            existingHoSo.setDiaChi(hoSoRequest.getDiaChi());

            hoSoRepository.save(existingHoSo);

            return ResponseEntity.ok(new MessageResponse("HoSo updated successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HoSo not found.");
        }
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getHoSoByUserId(@PathVariable("userId") Integer userId) {
        List<HoSo> hoSoList = hoSoRepository.findHoSoByUserId(userId);
        if (!hoSoList.isEmpty()) {
            return ResponseEntity.ok(hoSoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No HoSo found for the given userId.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHoSo(@PathVariable("id") Integer id) {
        Optional<HoSo> existingHoSoOptional = hoSoRepository.findById(id);
        if (existingHoSoOptional.isPresent()) {
            HoSo existingHoSo = existingHoSoOptional.get();
            hoSoRepository.delete(existingHoSo);
            return ResponseEntity.ok(new MessageResponse("HoSo deleted successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HoSo not found.");
        }
    }
}
