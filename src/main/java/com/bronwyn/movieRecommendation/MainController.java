package com.bronwyn.movieRecommendation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/v1/main")
public class MainController {

	    
	    @GetMapping(path = "/home")
	    public String showHomeScreen() {
	    	
	    	return "homeScreen";
	    }
	    
	        
 
}


	
	

