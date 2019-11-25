package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class greetingController {
    @GetMapping("/greeting01")
    public String greeting01(){
        return "greeting01";
    }
    @GetMapping("/greeting02")
    public String greeting02(){
        return "greeting02";
    }
    @GetMapping("/greetingInput")
    public String greetingInput(){
        return "greetingInput";
    }
    @GetMapping("/greetingOutput")
    public String greetingOutput(@RequestParam String inputValue , Model model){
        model.addAttribute("outputValue",inputValue);
        return "greetingOutput";
    }
}
