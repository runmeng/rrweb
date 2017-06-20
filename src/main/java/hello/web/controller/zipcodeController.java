package hello.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@Controller
@SessionAttributes("LocalZipcode")
public class zipcodeController {

    @SuppressWarnings("unchecked")
    @RequestMapping("/restaurant")
    public String listZipcode(Model model,HttpServletRequest request){
        Object z = request.getSession().getAttribute("LocalZipcode");
        model.addAttribute("zipcode", z);
        model.addAttribute("action","/restaurant");
//        model.addAttribute("submit","Add Zipcode");

        return "restaurant/index";
    }

    @RequestMapping(path = "/restaurant", method = RequestMethod.POST)
    public String addZipcode(@RequestParam("newZip") String zipco, Model model, HttpServletRequest request) {

        request.getSession().setAttribute("LocalZipcode",zipco);

        Object z = request.getSession().getAttribute("LocalZipcode");

        model.addAttribute("zipcode",z);
        model.addAttribute("action","/restaurant");
//        model.addAttribute("submit","Update Zipcode");

        return "restaurant/index";
    }

}
