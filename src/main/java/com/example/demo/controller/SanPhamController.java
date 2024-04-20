package com.example.demo.controller;

import com.example.demo.dto.SanPhamDto;
import com.example.demo.model.SanPham;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping
    public ResponseEntity<List<SanPham>> getAll() {
        List<SanPham> result = sanPhamService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody SanPhamDto sanPhamDto) {
        return new ResponseEntity<>(sanPhamService.add(sanPhamDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SanPhamDto> getOne(@PathVariable Integer id){
        return new ResponseEntity<>(sanPhamService.getOne(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(sanPhamService.delete(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody SanPhamDto sanPhamDto) {
        return new ResponseEntity<>(sanPhamService.update(id,sanPhamDto), HttpStatus.OK);
    }
    @GetMapping("/searchByKeyword")
    public ResponseEntity<?> search(@RequestParam String keyword) {
        return new ResponseEntity<>(sanPhamService.finByNameOrDescribe(keyword), HttpStatus.OK);
    }
}
