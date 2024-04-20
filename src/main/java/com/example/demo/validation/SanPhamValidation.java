package com.example.demo.validation;

import com.example.demo.constant.ErrorMessage;
import com.example.demo.dto.SanPhamDto;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.InvalidException;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class SanPhamValidation {
    private final SanPhamRepository sanPhamRepository;

    public SanPhamValidation(SanPhamRepository sanPhamRepository) {
        this.sanPhamRepository = sanPhamRepository;
    }

    public void idNotNull(Integer id) {
        if (ObjectUtils.isEmpty(id)) {
            ErrorResponse error = ErrorResponse.builder()
                    .field(ErrorMessage.SAN_PHAM_ERRORS.ID)
                    .data(id)
                    .message(ErrorMessage.SAN_PHAM_ERRORS.ID_NOT_NULL)
                    .build();
            throw new InvalidException(error);
        }
    }
    public void idNotFound(Integer id) {
        this.idNotNull(id);
        if (!sanPhamRepository.existsById(id)) {
            ErrorResponse error = ErrorResponse.builder()
                    .field(ErrorMessage.SAN_PHAM_ERRORS.ID)
                    .data(id)
                    .message(String.format(ErrorMessage.SAN_PHAM_ERRORS.ID_NOT_FOUND, id))
                    .build();
            throw new InvalidException(error);
        }
    }
    public void checkTenSanPham(String name) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.SAN_PHAM_ERRORS.NAME);
        error.setData(name);
        if (ObjectUtils.isEmpty(name)) {
            error.setMessage(ErrorMessage.SAN_PHAM_ERRORS.NAME_NOT_NULL);
            throw new InvalidException(error);
        }
    }
    public void checkMoTa(String name) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.SAN_PHAM_ERRORS.MOTA);
        error.setData(name);
        if (ObjectUtils.isEmpty(name)) {
            error.setMessage(ErrorMessage.SAN_PHAM_ERRORS.MOTA_NOT_NULL);
            throw new InvalidException(error);
        }
    }

    private void checkGiaBan(Double age) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.SAN_PHAM_ERRORS.GIABAN);
        error.setData(age);
        if (age == null) {
            error.setMessage(ErrorMessage.SAN_PHAM_ERRORS.GIA_BAN_NOT_NULL);
            throw new InvalidException(error);
        }
        if (age < ErrorMessage.SAN_PHAM_ERRORS.MIN_PRICE) {
            error.setMessage(ErrorMessage.SAN_PHAM_ERRORS.GIA_BAN_MIN);
            throw new InvalidException(error);
        }
    }
    private void checkSoLuong(Integer age) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.SAN_PHAM_ERRORS.SOLUONG);
        error.setData(age);
        if (age == null) {
            error.setMessage(ErrorMessage.SAN_PHAM_ERRORS.SO_LUONG_NOT_NULL);
            throw new InvalidException(error);
        }
        if (age < ErrorMessage.SAN_PHAM_ERRORS.SO_LUONG_TON) {
            error.setMessage(ErrorMessage.SAN_PHAM_ERRORS.SO_LUONG_MIN);
            throw new InvalidException(error);
        }
    }
    public void checkCreatValue(SanPhamDto sanPhamDto) {
        checkTenSanPham(sanPhamDto.getTenSanPham());
        checkGiaBan(sanPhamDto.getGiaBan());
        checkSoLuong(sanPhamDto.getSoLuongTon());
        checkMoTa(sanPhamDto.getMoTa());
    }

}
