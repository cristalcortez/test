package hellocontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{

    @RequestMapping("/welcome")
    public ModelAndView helloWorld(){
      ModelAndView model = new ModelAndView("HelloPage");
      model.addObject("welcomeMessage","Hello World, I am using spring annotation");
      return model;
    }
}
