package org.hackathon.packapp.containerbank.service.impl;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Advisor;
import org.hackathon.packapp.containerbank.repository.AdvisorRepository;
import org.hackathon.packapp.containerbank.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvisorServiceImpl implements AdvisorService {

    private AdvisorRepository advisorRepository;

    @Autowired
    public AdvisorServiceImpl(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "advisors")
    public Collection<Advisor> findAdvisors() throws DataAccessException {
        return advisorRepository.findAll();
    }
}
