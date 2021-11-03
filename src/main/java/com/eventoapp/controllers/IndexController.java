package com.eventoapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author robson-pc
 */
@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String index(){
      return "index";  
    };
}
