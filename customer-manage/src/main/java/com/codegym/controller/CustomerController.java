package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }
    @RequestMapping(value = "/customer/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @RequestMapping(value = "/customer/save",method = RequestMethod.POST)
    public String save(Customer customer, RedirectAttributes redirect){
        customer.setId((int) (Math.random()*1000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }
    @RequestMapping(value = "/customer/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable int id , Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "edit";
    }
    @RequestMapping(value = "/customer/update", method = RequestMethod.POST)
    public String update(Customer customer ,RedirectAttributes redirect){
        customerService.update(customer.getId(),customer);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/";
    }
    @RequestMapping(value = "/customer/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "delete";
    }
    @RequestMapping(value = "/customer/delete", method = RequestMethod.POST)
    public String delete(Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @RequestMapping(value = "/customer/{id}/view", method = RequestMethod.GET)
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }

}
