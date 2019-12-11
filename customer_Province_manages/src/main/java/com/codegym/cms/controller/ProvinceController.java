package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/provinces", method = RequestMethod.GET)
    public ModelAndView listProvinces(){
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinceList", provinces);
        return modelAndView;
    }
    @RequestMapping(value = "/create-province",method = RequestMethod.GET)
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province",new Province());
        return modelAndView;
    }
    @RequestMapping(value = "/create-province",method = RequestMethod.POST)
    public ModelAndView saveProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province",new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }
    @RequestMapping(value = "/edit-province/{id}",method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable long id){
        Province province = provinceService.findById(id);
        if (province != null){
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province);
            return modelAndView;
        }else{
            return new ModelAndView("/error.404");
        }
    }
    @RequestMapping(value = "edit-province",method = RequestMethod.POST)
    public ModelAndView editProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }
    @RequestMapping(value = "delete-province/{id}", method = RequestMethod.GET)
    public ModelAndView ShowDeleteForm(@PathVariable long id){
        Province province = provinceService.findById(id);
        if(province != null){
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province);
            return modelAndView;
        }
        else{
            return new ModelAndView("/error.404");
        }
    }
    @RequestMapping(value = "delete-province", method = RequestMethod.POST)
    public String  deleteProvince(@ModelAttribute("province") Province province){
        provinceService.remove(province.getId());
        return "redirect:provinces";
    }
    @RequestMapping(value ="/view-province/{id}",method = RequestMethod.GET)
    public ModelAndView viewProvince(@PathVariable long id){
        Province province = provinceService.findById(id);
        if (province != null){
            Iterable<Customer> customers = customerService.findAllByProvince(province);
            ModelAndView modelAndView = new ModelAndView("/province/view");
            modelAndView.addObject("province", province);
            modelAndView.addObject("customers", customers);
            return modelAndView;
        }
        else{
            return new ModelAndView("/error.404");
        }
    }

}
