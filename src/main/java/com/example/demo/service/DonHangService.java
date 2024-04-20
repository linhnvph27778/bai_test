package com.example.demo.service;

import com.example.demo.dto.DonHangDto;
import com.example.demo.model.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonHangService {
    Page<DonHang> phantrang(Integer page);
    List<DonHang> getAll();
    DonHangDto add(DonHangDto donHangDto);
    DonHangDto getOne(Integer id);
    DonHangDto update(Integer id,DonHangDto donHangDto);
    List<DonHangDto> findByNameOrId(String keyword,Integer id);
}
