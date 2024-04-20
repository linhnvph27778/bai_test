package com.example.demo.repository;

import com.example.demo.dto.DonHangDto;
import com.example.demo.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    @Query(value = "SELECT NEW com.example.demo.dto.DonHangDto(e) FROM DonHang e " +
            " WHERE (e.id = :id) " +
            " OR (e.tenKhachHang LIKE %:keyword%) ")
    List<DonHangDto> searchByKeyword(String keyword,Integer id);

    boolean existsBySdt(String sdt);
}
