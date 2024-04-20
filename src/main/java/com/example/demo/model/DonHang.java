package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Don_Hang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ten_khach_hang")
    private String tenKhachHang;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "email")
    private String email;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "tong_tien_thanh_toan")
    private double tongTienThanhToan;

//    @OneToMany(mappedBy = "donHang", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<ChiTietDonHang> chiTietDonHangList;
}
