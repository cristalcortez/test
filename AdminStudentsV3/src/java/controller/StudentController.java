package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import model.Student;
import service.StudentService; 


@Controller
public class StudentController {
    
    private Logger logger = Logger.getLogger(StudentController.class);
    private StudentService studentService;

    @Autowired(required=true)
    @Qualifier(value="studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student_form", method = RequestMethod.GET)
    public String studentForm(Model model) {
        

	Map<String,String> gender = new LinkedHashMap<String,String>();
	gender.put("Male", "Male");
	gender.put("Female", "Female");
        
        model.addAttribute("genderList", gender);
        model.addAttribute("student", new Student());
        return "student_form";
    }
    
    @RequestMapping(value = "/student_list", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("listStudents", studentService.listStudents());
        return "student_list";
    }
	
    @RequestMapping(value= "/student/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student s){
        studentService.addStudent(s);
        return "redirect:/student_list";	
    }
	
    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id) {	
        studentService.removeStudent(id);
        return "redirect:/student_list";
    }
    
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public ModelAndView getAdmissionForm(){
        ModelAndView model = new ModelAndView("index");
        logger.info("This Is An Info Log Entry ......!");
        return model;
    }
        
}