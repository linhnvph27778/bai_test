package com.example.demo.validation;

import com.example.demo.constant.ErrorMessage;
import com.example.demo.dto.DonHangDto;
import com.example.demo.dto.SanPhamDto;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.InvalidException;
import com.example.demo.repository.DonHangRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Component
public class DonHangValidation {
    private final DonHangRepository donHangRepository;

    public DonHangValidation(DonHangRepository donHangRepository) {
        this.donHangRepository = donHangRepository;
    }

    public void idNotNull(Integer id) {
        if (ObjectUtils.isEmpty(id)) {
            ErrorResponse error = ErrorResponse.builder()
                    .field(ErrorMessage.DON_HANG_ERRORS.ID)
                    .data(id)
                    .message(ErrorMessage.DON_HANG_ERRORS.ID_NOT_NULL)
                    .build();
            throw new InvalidException(error);
        }
    }
    public void idNotFound(Integer id) {
        this.idNotNull(id);
        if (!donHangRepository.existsById(id)) {
            ErrorResponse error = ErrorResponse.builder()
                    .field(ErrorMessage.DON_HANG_ERRORS.ID)
                    .data(id)
                    .message(String.format(ErrorMessage.DON_HANG_ERRORS.ID_NOT_FOUND, id))
                    .build();
            throw new InvalidException(error);
        }
    }
    public void checkTenKhachHang(String name) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.DON_HANG_ERRORS.NAME);
        error.setData(name);
        if (ObjectUtils.isEmpty(name)) {
            error.setMessage(ErrorMessage.DON_HANG_ERRORS.NAME_NOT_NULL);
            throw new InvalidException(error);
        }
    }
    public void checkNgayTao(Date name) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.DON_HANG_ERRORS.NGAYTAO);
        error.setData(name);
        if (ObjectUtils.isEmpty(name)) {
            error.setMessage(ErrorMessage.DON_HANG_ERRORS.NGAY_TAO_NOT_NULL);
            throw new InvalidException(error);
        }
    }
    public void checkDiaChi(String name) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.DON_HANG_ERRORS.DIACHI);
        error.setData(name);
        if (ObjectUtils.isEmpty(name)) {
            error.setMessage(ErrorMessage.DON_HANG_ERRORS.DIACHI_NOT_NULL);
            throw new InvalidException(error);
        }
    }
    private void checkEmail(String email) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.DON_HANG_ERRORS.EMAIL);
        error.setData(email);
        if (ObjectUtils.isEmpty(email)) {
            error.setMessage(ErrorMessage.DON_HANG_ERRORS.EMAIL_NOT_NULL);
            throw new InvalidException(error);
        }
        if (!email.matches(ErrorMessage.DON_HANG_ERRORS.FORMAT_EMAIL)) {
            error.setMessage(ErrorMessage.DON_HANG_ERRORS.EMAIL_IS_INVALID);
            throw new InvalidException(error);
        }
    }

    private void checkPhone(String phone) {
        ErrorResponse error = new ErrorResponse();
        error.setField(ErrorMessage.DON_HANG_ERRORS.SDT);
        error.setData(phone);
        if (ObjectUtils.isEmpty(phone)) {
            error.setMessage(ErrorMessage.DON_HANG_ERRORS.PHONE_NOT_NULL);
            throw new InvalidException(error);
        }
        if (!phone.matches(ErrorMessage.DON_HANG_ERRORS.FORMAT_PHONE)) {
            error.setMessage(ErrorMessage.DON_HANG_ERRORS.PHONE_IS_INVALID);
            throw new InvalidException(error);
        }
        if (donHangRepository.existsBySdt(phone)){
            error.setMessage(String.format(ErrorMessage.DON_HANG_ERRORS.PHONE_IS_EXISTED,phone));
            throw new InvalidException(error);
        }
    }
    public void checkCreatValue(DonHangDto donHangDto) {
        checkTenKhachHang(donHangDto.getTenKhachHang());
        checkDiaChi(donHangDto.getDiaChi());
        checkEmail(donHangDto.getEmail());
        checkPhone(donHangDto.getSdt());
        checkNgayTao(donHangDto.getNgayTao());
    }
}
