package com.example.demo.repository;

import com.example.demo.dto.SanPhamDto;
import com.example.demo.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    @Query(value = "SELECT NEW com.example.demo.dto.SanPhamDto(e) FROM SanPham e " +
            " WHERE e.tenSanPham LIKE %:keyword% OR e.moTa LIKE %:keyword%")
    List<SanPhamDto> searchByKeyword(String keyword);
}
