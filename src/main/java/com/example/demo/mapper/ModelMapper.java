package com.example.demo.mapper;

import com.example.demo.dto.ChiTietDonHangDto;
import com.example.demo.dto.DonHangDto;
import com.example.demo.dto.SanPhamDto;
import com.example.demo.model.ChiTietDonHang;
import com.example.demo.model.DonHang;
import com.example.demo.model.SanPham;
import com.example.demo.repository.DonHangRepository;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelMapper {
    private final DonHangRepository donHangRepository;
    private final SanPhamRepository sanPhamRepository;

    public ModelMapper(DonHangRepository donHangRepository, SanPhamRepository sanPhamRepository) {
        this.donHangRepository = donHangRepository;
        this.sanPhamRepository = sanPhamRepository;
    }

    public SanPham addSanPhamEntity(SanPhamDto sanPhamDto) {
        SanPham sanPham = new SanPham();
        if (sanPhamDto.getId() != null) {
            sanPham.setId(sanPhamDto.getId());
        }
        if (sanPhamDto.getTenSanPham() != null) {
            sanPham.setTenSanPham(sanPhamDto.getTenSanPham());
        }
        if (sanPhamDto.getGiaBan() != null) {
            sanPham.setGiaBan(sanPhamDto.getGiaBan());
        }
        if (sanPhamDto.getSoLuongTon() != null) {
            sanPham.setSoLuongTon(sanPhamDto.getSoLuongTon());
        }
        if (sanPhamDto.getMoTa() != null) {
            sanPham.setMoTa(sanPhamDto.getMoTa());
        }
        return sanPham;
    }
    public ChiTietDonHang addChiTietDonHang(ChiTietDonHangDto chiTietDonHangDto) {
        DonHang donHang = donHangRepository.findById(chiTietDonHangDto.getIdDonHang()).get();
        SanPham sanPham = sanPhamRepository.findById(chiTietDonHangDto.getIdSanPham()).get();
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
        if (chiTietDonHangDto.getId() != null) {
            chiTietDonHang.setId(chiTietDonHangDto.getId());
        }
        if (chiTietDonHangDto.getSoLuong() != null) {
            chiTietDonHang.setSoLuong(chiTietDonHangDto.getSoLuong());
        }
        if (chiTietDonHangDto.getDonGia() != null) {
            chiTietDonHang.setDonGia(chiTietDonHangDto.getSoLuong() * sanPham.getGiaBan());
        }
        if (chiTietDonHangDto.getIdDonHang() != null) {
            chiTietDonHang.setDonHang(donHang);
        }
        if (chiTietDonHangDto.getIdSanPham() != null) {
            chiTietDonHang.setSanPham(sanPham);
        }
        return chiTietDonHang;
    }

    public DonHang saveDonHang(DonHangDto donHangDto){
        DonHang donHang = new DonHang();
        if (donHangDto.getId() != null) {
            donHang.setId(donHangDto.getId());
        }
        if (donHangDto.getNgayTao() != null) {
            donHang.setNgayTao(donHangDto.getNgayTao());
        }
        if (donHangDto.getTenKhachHang() != null) {
            donHang.setTenKhachHang(donHangDto.getTenKhachHang());
        }
        if (donHangDto.getDiaChi() != null) {
            donHang.setDiaChi(donHangDto.getDiaChi());
        }
        if (donHangDto.getEmail() != null) {
            donHang.setEmail(donHangDto.getEmail());
        }
        if (donHangDto.getSdt() != null) {
            donHang.setSdt(donHangDto.getSdt());
        }
        if (donHangDto.getTrangThai() != null) {
            donHang.setTrangThai(donHangDto.getTrangThai());
        }
//        if (donHangDto.getChiTietDonHangList() != null){
//            List<ChiTietDonHang> list = new ArrayList<>();
//            for (ChiTietDonHangDto chiTietDonHangDto : donHangDto.getChiTietDonHangList()){
//                chiTietDonHangDto.setIdDonHang(donHang.getId());
//                list.add(addChiTietDonHang(chiTietDonHangDto));
//            }
//            donHang.setChiTietDonHangList(list);
//        }
        return donHang;
    }
}
