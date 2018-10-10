
package org.hackathon.packapp.containerbank.web;

import java.util.Map;

import org.hackathon.packapp.containerbank.model.Advisors;
import org.hackathon.packapp.containerbank.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Wavestone
 */
@Controller
public class AdvisorController {

    private final AdvisorService advisorService;


    @Autowired
    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @RequestMapping(value = { "/advisors.html"})
    public String showAdvisorList(Map<String, Object> model) {
        // Here we are returning an object of type 'Advisors' rather than a collection of Advisor objects
        // so it is simpler for Object-Xml mapping
        Advisors advisors = new Advisors();
        advisors.getAdvisorList().addAll(this.advisorService.findAdvisors());
        model.put("advisors", advisors);
        return "advisors/advisorList";
    }

    @RequestMapping(value = { "/advisors.json", "/advisors.xml"})
    public
    @ResponseBody
    Advisors showResourcesAdvisorList() {
        // Here we are returning an object of type 'Advisors' rather than a collection of Advisor objects
        // so it is simpler for JSon/Object mapping
        Advisors advisors = new Advisors();
        advisors.getAdvisorList().addAll(this.advisorService.findAdvisors());
        return advisors;
    }


}
