package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class changeMoneyController {
    @GetMapping("/inputChangeMoney")
    public String inputChangeMoney(){
        return "changeMoney/inputChangeMoney";
    }

    @GetMapping("/outputChangeMoney")
    public String outputChangeMoney(@RequestParam String inputValue , Model model){
        model.addAttribute("usd",inputValue);
        int vnd = Integer.parseInt(inputValue) * 23000;
        model.addAttribute("vnd",vnd);
        return "changeMoney/outputChangeMoney";
    }
}
