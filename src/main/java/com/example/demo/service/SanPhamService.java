package com.example.demo.service;

import com.example.demo.dto.SanPhamDto;
import com.example.demo.model.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SanPhamService {
    List<SanPham> getAll();
    SanPhamDto add(SanPhamDto sanPhamDto);
    SanPhamDto getOne(Integer id);
    boolean delete(Integer id);
    SanPhamDto update(Integer id,SanPhamDto sanPhamDto);
    List<SanPhamDto> finByNameOrDescribe(String keyword);
}
