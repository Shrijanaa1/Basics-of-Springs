package controller.springmvc;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping("/add")
    public String add(){

        System.out.println("This is our url");
        return "index";
        // (index) this is our view name
        // spring-servlet.xml ma suffix and prefix ma milako kura
    }
}

//@Component
//@RequestMapping(path="/home")
//public class HomeController {
//
//    @RequestMapping(method=RequestMethod.GET)
//    public void add() {
//        System.out.println("I'm here");
//    }
//}

//@Controller
//public class HomeController {
//    @GetMapping("/MVCProject/")
//    public String handleMVCProjectRequest() {
//        // Add your logic to handle the request
//        return "viewName"; // Return the name of the view to render
//    }
//}