package com.codegym.repository;

import com.codegym.model.PetKind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface PetKindRepository extends JpaRepository<PetKind, Long> {
    @Query(value = "select e from PetKind e where e.name = ?1")
    Page<PetKind> findAllByPetKindName(String name, Pageable pageable);

    @Query(value = "select e from PetKind e where e.status = ?1")
    Page<PetKind> findAllByPetKindStatus(String status, Pageable pageable);

    @Override
    @Query("select e from PetKind e where e.softDelete=false")
    Page<PetKind> findAll(Pageable pageable);

    //Soft delete.
    @Query("update PetKind e set e.softDelete=true where e.id=?1")
    @Modifying
    void softDelete(Long id);
}
