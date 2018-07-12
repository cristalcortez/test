/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daoInterfaceImplementation.PersonDAOImplementation;
import model.Person;

/**
 *
 * @author user
 */
@Controller
public class CountryController {
    @RequestMapping("/welcomeMap/{countryName}/{userName}")
    public ModelAndView helloMap(@PathVariable Map<String, String> pathVars){
        String country = pathVars.get("countryName");
        String name = pathVars.get("userName");
        
        ModelAndView model = new ModelAndView("page");
        model.addObject("msg","Country :" + country + "<=======> Name : " + name);
        
        return model;
    }
    
    @RequestMapping("/welcomeString/{countryName}/{userName}")
    public ModelAndView helloString(@PathVariable("countryName") String cn, @PathVariable("userName") String un){
        
        ModelAndView model = new ModelAndView("page");
        model.addObject("msg","Country :" + cn + "<=======> Name : " + un);
        
        return model;
    }
    
    @RequestMapping("/getPersonInfo/{ipersonId}")
    public ModelAndView getPerson(@PathVariable("ipersonId") int id){
        
        PersonDAOImplementation dao = new PersonDAOImplementation();
        Person person = dao.findById(id);
        ModelAndView model = new ModelAndView("page");
        model.addObject("msg","Person :" + id + "<=======> Name : " + person.getName());
        
        return model;
    }
}
