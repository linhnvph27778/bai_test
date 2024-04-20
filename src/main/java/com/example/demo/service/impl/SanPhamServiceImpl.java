package com.example.demo.service.impl;

import com.example.demo.constant.ErrorMessage;
import com.example.demo.dto.SanPhamDto;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.InvalidException;
import com.example.demo.mapper.ModelMapper;
import com.example.demo.model.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import com.example.demo.validation.SanPhamValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    private final ModelMapper modelMapperUtil;
    private final SanPhamRepository sanPhamRepository;
    private final SanPhamValidation sanPhamValidation;

    public SanPhamServiceImpl(ModelMapper modelMapperUtil, SanPhamRepository sanPhamRepository, SanPhamValidation sanPhamValidation) {
        this.modelMapperUtil = modelMapperUtil;
        this.sanPhamRepository = sanPhamRepository;
        this.sanPhamValidation = sanPhamValidation;
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPhamDto add(SanPhamDto sanPhamDto) {
        sanPhamValidation.checkCreatValue(sanPhamDto);
        SanPham sanPham = modelMapperUtil.addSanPhamEntity(sanPhamDto);
        sanPham = sanPhamRepository.save(sanPham);
        return new SanPhamDto(sanPham);
    }

    @Override
    public SanPhamDto getOne(Integer id) {
        Optional<SanPham> optionalPhieuGiaoHang = sanPhamRepository.findById(id);
        if (!optionalPhieuGiaoHang.isPresent()) {
            throw new RuntimeException("Phieu giao hang khong ton tai");
        }
        return new SanPhamDto(optionalPhieuGiaoHang.get());
    }

    @Override
    public boolean delete(Integer id) {
        sanPhamValidation.idNotFound(id);
        Optional<SanPham> optionalPhieuGiaoHang = sanPhamRepository.findById(id);
        if (optionalPhieuGiaoHang.isPresent()) {
            sanPhamRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public SanPhamDto update(Integer id,SanPhamDto sanPhamDto) {
        sanPhamValidation.idNotFound(id);
        sanPhamValidation.checkCreatValue(sanPhamDto);
        SanPham sanPham = modelMapperUtil.addSanPhamEntity(sanPhamDto);
        sanPham = sanPhamRepository.save(sanPham);
        return new SanPhamDto(sanPham);
    }

    @Override
    public List<SanPhamDto> finByNameOrDescribe(String keyword) {
        List<SanPhamDto> list = sanPhamRepository.searchByKeyword(keyword);
        if (list.isEmpty()) {
            ErrorResponse error = ErrorResponse.builder()
                    .field(ErrorMessage.SAN_PHAM_ERRORS.KEYWORD)
                    .data(keyword)
                    .message(String.format(ErrorMessage.SAN_PHAM_ERRORS.NOT_POUND_KEYWORD)).build();
            throw new InvalidException(error);
        }
        return list;
    }
}
