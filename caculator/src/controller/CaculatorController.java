package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @RequestMapping(value = "/calculatorForm", method = RequestMethod.GET)
    public String showFormCaculator() {
        return "calculatorForm";
    }
    @RequestMapping(value = "/caculate", method = RequestMethod.POST)
    public String caculate(@RequestParam("inputValue01") String inputValue01,
                           @RequestParam("inputValue02") String inputValue02,
                           @RequestParam("operations") String operations,
                           ModelMap model) {
        int outPutValue = 0;
        int input01 = Integer.parseInt(inputValue01);
        int input02 = Integer.parseInt(inputValue02);
        model.addAttribute("input01",input01);
        model.addAttribute("input02",input02);
        switch (operations){
            case "Addition":
                outPutValue = input01 +input02;
                model.addAttribute("outPutValue",outPutValue);
                break;
            case "Subtraction":
                outPutValue = input01 -input02;
                model.addAttribute("outPutValue",outPutValue);
                break;
            case "Multiplication":
                outPutValue = input01 *input02;
                model.addAttribute("outPutValue",outPutValue);
                break;
            case "Divition":
                if (input02 == 0){
                    model.addAttribute("outPutValue","can not Divition");
                    break;
                }
                else{
                    outPutValue = input01 /input02;
                    model.addAttribute("outPutValue",outPutValue);
                    break;
                }
            default:
                break;
        }
        return "calculatorForm";
    }
}
