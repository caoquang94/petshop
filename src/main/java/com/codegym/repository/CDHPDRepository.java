package com.codegym.repository;

import com.codegym.model.CareDetailHasPetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CDHPDRepository extends JpaRepository<CareDetailHasPetDetail, Long> {
}
