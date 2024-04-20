package com.example.demo.dto;

import com.example.demo.model.ChiTietDonHang;
import com.example.demo.model.DonHang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonHangDto {
    private Integer id;
    private Date ngayTao;
    private String tenKhachHang;
    private String diaChi;
    private String email;
    private String sdt;
    private Integer trangThai;
    public DonHangDto (DonHang donHang){
        this.id = donHang.getId();
        this.ngayTao = donHang.getNgayTao();
        this.tenKhachHang = donHang.getTenKhachHang();
        this.diaChi = donHang.getDiaChi();
        this.email = donHang.getEmail();
        this.sdt = donHang.getSdt();
        this.trangThai = donHang.getTrangThai();
    }
}
