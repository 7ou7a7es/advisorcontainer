package org.hackathon.packapp.containerbank.service;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Advisor;
import org.springframework.dao.DataAccessException;

public interface AdvisorService {

	Collection<Advisor> findAdvisors() throws DataAccessException;
}
