package com.example.demo.service.impl;

import com.example.demo.dto.DonHangDto;
import com.example.demo.mapper.ModelMapper;
import com.example.demo.model.DonHang;
import com.example.demo.repository.DonHangRepository;
import com.example.demo.service.DonHangService;
import com.example.demo.validation.DonHangValidation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonHangServiceImpl implements DonHangService {
    private final DonHangRepository donHangRepository;
    private final DonHangValidation donHangValidation;
    private final ModelMapper mapper;
    public DonHangServiceImpl(DonHangRepository donHangRepository, DonHangValidation donHangValidation, ModelMapper mapper) {
        this.donHangRepository = donHangRepository;
        this.donHangValidation = donHangValidation;
        this.mapper = mapper;
    }

    @Override
    public Page<DonHang> phantrang(Integer page) {
        Pageable pageable = PageRequest.of(page,2);
        return donHangRepository.findAll(pageable);
    }

    @Override
    public List<DonHang> getAll() {
        return donHangRepository.findAll();
    }

    @Override
    public DonHangDto add(DonHangDto donHangDto) {
        donHangValidation.checkCreatValue(donHangDto);
        DonHang donHang = mapper.saveDonHang(donHangDto);
        donHang = donHangRepository.save(donHang);
        return new DonHangDto(donHang);
    }

    @Override
    public DonHangDto getOne(Integer id) {
        donHangValidation.idNotFound(id);
        Optional<DonHang> optionalDonHang = donHangRepository.findById(id);
        return new DonHangDto(optionalDonHang.get());
    }

    @Override
    public DonHangDto update(Integer id, DonHangDto donHangDto) {
        donHangValidation.idNotFound(id);
        donHangValidation.checkCreatValue(donHangDto);
        DonHang donHang = mapper.saveDonHang(donHangDto);
        donHang = donHangRepository.save(donHang);
        return new DonHangDto(donHang);
    }

    @Override
    public List<DonHangDto> findByNameOrId(String keyword,Integer id) {
        List<DonHangDto> list = donHangRepository.searchByKeyword(keyword,id);
        return list;
    }
}
