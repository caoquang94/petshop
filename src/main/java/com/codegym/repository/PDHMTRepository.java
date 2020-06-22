package com.codegym.repository;

import com.codegym.model.PetDetailHasMyTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PDHMTRepository extends JpaRepository<PetDetailHasMyTeam, Long> {
}
