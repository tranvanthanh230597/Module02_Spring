package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView listCustomer(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Customer> customers;
        if (s.isPresent()){
            customers = customerService.findAllByFirstNameContaining(s.get(), pageable);
        }
        else{
            customers= customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerList", customers);
        return modelAndView;

    }
    @RequestMapping(value = "/create-customer" , method = RequestMethod.GET)
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());

        return modelAndView;
    }
    @RequestMapping(value = "/create-customer" , method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);

        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @RequestMapping(value = "/edit-customer/{id}",method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable long id){
        Customer customer = customerService.findById(id);
        if (customer != null){
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        else{
            return new ModelAndView("/error.404");
        }
    }
    @RequestMapping(value = "/edit-customer", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);

        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @RequestMapping(value = "/delete-customer/{id}", method = RequestMethod.GET)
    public ModelAndView showDeleteForm(@PathVariable long id){
        Customer customer = customerService.findById(id);
        if (customer != null){
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        else{
            return new ModelAndView("/error.404");
        }
    }
    @RequestMapping(value = "/delete-customer",method = RequestMethod.POST)
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/customers";
    }
}
