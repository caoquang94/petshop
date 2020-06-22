package com.codegym.repository;

import com.codegym.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query(value = "select e from Pet e where e.name = ?1")
    Page<Pet> findAllByPetName(String name, Pageable pageable);

    @Query(value = "select e from Pet e where e.age = ?1")
    Page<Pet> findAllByPetAge(String age, Pageable pageable);

    @Query(value = "select e from Pet e where e.weight = ?1")
    Page<Pet> findAllByPetWeight(String weight, Pageable pageable);

    @Query(value = "select e from Pet e where e.color = ?1")
    Page<Pet> findAllByPetColor(String color, Pageable pageable);

    @Override
    @Query("select e from Pet e where e.softDelete=false")
    Page<Pet> findAll(Pageable pageable);

    //Soft delete.
    @Query("update Pet e set e.softDelete=true where e.id=?1")
    @Modifying
    void softDelete(Long id);
}
