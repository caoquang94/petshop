package com.codegym.service.impl;

import com.codegym.model.PetType;
import com.codegym.repository.PetTypeRepository;
import com.codegym.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PetTypeServiceImpl implements PetTypeService {
    @Autowired
    private PetTypeRepository petTypeRepository;

    @Override
    public Page<PetType> findAll(Pageable pageable) {
        return petTypeRepository.findAll(pageable);
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).get();
    }

    @Override
    public void save(PetType petType) {
        petTypeRepository.save(petType);
    }

    @Override
    public void remove(Long id) {
        petTypeRepository.softDelete(id);
    }

    @Override
    public Page<PetType> findAllByPetTypeName(String name, Pageable pageable) {
        return petTypeRepository.findAllByPetTypeName(name,pageable);
    }
}
