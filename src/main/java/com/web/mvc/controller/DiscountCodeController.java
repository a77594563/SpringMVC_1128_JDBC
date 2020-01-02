package com.web.mvc.controller;

import com.web.mvc.entity.DiscountCode;
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
@RequestMapping("/discount_code")
public class DiscountCodeController {
    
    @Autowired
    @Qualifier("customerDao")
    private CustomerDao dao;
    
    @GetMapping("/input")
    public String input(Model model){
        model.addAttribute("po", new DiscountCode());
        model.addAttribute("list", dao.queryDiscountCode());
        model.addAttribute("_method", "POST");
        return "discount_code";
    }
    
    @GetMapping("/{code}")
    public String input(@PathVariable("code") String code, Model model){
        DiscountCode dc = dao.getDiscountCode(code);
        model.addAttribute("po", dc);
        model.addAttribute("list", dao.queryDiscountCode());
        model.addAttribute("_method", "PUT");
        return "discount_code";
    }
    
    @PostMapping("/")
    public String save(@ModelAttribute DiscountCode dc) {
        dao.saveDiscountCode(dc);
        return "redirect: ./input";
    }
    
    @PutMapping("/")
    public String update(@ModelAttribute DiscountCode dc) {
        dao.updateDiscountCode(dc);
        return "redirect: ./input";
    }
    
    @DeleteMapping("/{code}")
    public String delete(@PathVariable("code") String code) {
        dao.deleteDiscountCode(code);
        return "redirect: ./input";
    }
    
}
