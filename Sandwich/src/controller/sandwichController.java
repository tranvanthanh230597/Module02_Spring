package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class sandwichController{

    @RequestMapping(value = "/sandwichForm",method = RequestMethod.GET)
    public String sandwichForm(){
        return "sandwichForm";
    }

    @RequestMapping(value = "/addCondiment",method = RequestMethod.POST)
    public String addCondiment(ModelMap model, @RequestParam("condiments") String[] condiment){
        model.addAttribute("condiments",condiment);
        return "sandwichInfo";
    }

}
