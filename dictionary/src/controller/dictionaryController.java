package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionaryController {
    @GetMapping("/inputDic")
    public String inputDic(){
        return "inputDic";
    }
    @GetMapping("/outputDic")
    public String outputDic(@RequestParam String inputValue , Model model){
        model.addAttribute("inputValue",inputValue);
        Map<String, String> dictionary =new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String result = dictionary.get(inputValue);
        if(result != null){
            model.addAttribute("outputValue",result);
        }
        else{
            model.addAttribute("outputValue", "can not found");
        }
        return "outputDic";
    }
}
