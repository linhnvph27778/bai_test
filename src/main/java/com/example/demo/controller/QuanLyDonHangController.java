package com.example.demo.controller;

import com.example.demo.dto.DonHangDto;
import com.example.demo.dto.SanPhamDto;
import com.example.demo.service.DonHangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/don-hang")
public class QuanLyDonHangController {
    private final DonHangService donHangService;

    public QuanLyDonHangController(DonHangService donHangService) {
        this.donHangService = donHangService;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody DonHangDto donHangDto) {
        return new ResponseEntity<>(donHangService.add(donHangDto), HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(donHangService.getAll());
    }
    @GetMapping("/phan-trang")
    public ResponseEntity<?> phanTrang(@RequestParam(defaultValue = "0",name = "page")Integer page){
        return ResponseEntity.ok(donHangService.phantrang(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonHangDto> getOne(@PathVariable Integer id){
        return new ResponseEntity<>(donHangService.getOne(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody DonHangDto donHangDto) {
        return new ResponseEntity<>(donHangService.update(id,donHangDto), HttpStatus.OK);
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<?> search(@RequestParam(required = false) String keyword,@RequestParam(required = false) Integer id) {
        return new ResponseEntity<>(donHangService.findByNameOrId(keyword,id), HttpStatus.OK);
    }
}
