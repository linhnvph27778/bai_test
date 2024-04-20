package com.example.demo.dto;

import com.example.demo.model.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDto {
    private Integer id;

    private String tenSanPham;

    private Double giaBan;

    private Integer soLuongTon;

    private String moTa;

    public SanPhamDto(SanPham sanPham){
        this.id = sanPham.getId();
        this.tenSanPham = sanPham.getTenSanPham();
        this.giaBan = sanPham.getGiaBan();
        this.soLuongTon = sanPham.getSoLuongTon();
        this.moTa = sanPham.getMoTa();
    }
}
