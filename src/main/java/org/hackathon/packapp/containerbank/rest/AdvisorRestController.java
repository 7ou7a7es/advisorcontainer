package org.hackathon.packapp.containerbank.rest;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Advisor;
import org.hackathon.packapp.containerbank.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advisorRest")
public class AdvisorRestController {

    private final AdvisorService advisorService;


    @Autowired
    public AdvisorRestController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }
    
    @RequestMapping("/findAdvisors")
    public Collection<Advisor> findAdvisors() throws DataAccessException {
        return advisorService.findAdvisors();
    }
    
}
