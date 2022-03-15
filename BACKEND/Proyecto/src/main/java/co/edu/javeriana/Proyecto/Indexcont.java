package co.edu.javeriana.Proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class Indexcont {
    Logger log = LoggerFactory.getLogger(getClass());

    

    
    @GetMapping("")
    public String inicio(){
        return "Index";
    }   
    
    
    
}
