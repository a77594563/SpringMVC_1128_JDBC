package com.web.mvc.controller;

import com.web.mvc.entity.Customer;
import com.web.mvc.repository.spec.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{
    
    @Autowired
    @Qualifier("customerDao")
    CustomerDao dao;
    
    @GetMapping("/input")
    public String input(Model model) {
        model.addAttribute("po", new Customer());
        model.addAttribute("list", dao.queryCustomer());
        model.addAttribute("list_dc", dao.queryDiscountCode());
        model.addAttribute("list_mm", dao.queryMicroMarket());
        model.addAttribute("_method", "POST");
        return "customer";
    }
    
    @GetMapping("/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        Customer customer = dao.getCustomer(id);
        model.addAttribute("po", customer);
        model.addAttribute("list", dao.queryCustomer());
        model.addAttribute("list_dc", dao.queryDiscountCode());
        model.addAttribute("list_mm", dao.queryMicroMarket());
        model.addAttribute("_method", "PUT");
        return "customer";
    }
    
    @PostMapping("/")
    public String save(@ModelAttribute Customer customer) {
        dao.saveCustomer(customer);
        return "redirect:./input";
    }
    
    @PutMapping("/")
    public String update(@ModelAttribute Customer customer) {
        dao.updateCustomer(customer);
        return "redirect:./input";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        dao.deleteCustomer(id);
        return "redirect:./input";
    }
    
    
}
