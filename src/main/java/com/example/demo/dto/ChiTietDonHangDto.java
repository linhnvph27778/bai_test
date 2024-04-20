package com.example.demo.dto;

import com.example.demo.model.ChiTietDonHang;
import com.example.demo.model.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietDonHangDto {
    private Integer id;

    private Double donGia;

    private Integer soLuong;

    private Integer idSanPham;

    private Integer idDonHang;
    public ChiTietDonHangDto(ChiTietDonHang chiTietDonHang){
        this.id = chiTietDonHang.getId();
        this.donGia = chiTietDonHang.getDonGia();
        this.soLuong = chiTietDonHang.getSoLuong();
//        this.idSanPham = chiTietDonHang.getSanPham().getId();
//        this.idDonHang = chiTietDonHang.getDonHang().getId();
        if(chiTietDonHang.getDonHang()!= null){
            this.setIdDonHang(chiTietDonHang.getDonHang().getId());
            this.setIdSanPham(chiTietDonHang.getSanPham().getId());
        }
    }
}
