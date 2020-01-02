package com.web.mvc.controller;

import com.web.mvc.repository.spec.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discount_code")
public class DiscountCodeController {
    
    @Autowired
    @Qualifier("customerDao")
    private CustomerDao dao;
    
    @RequestMapping("/input")
    public String input(Model model){
        model.addAttribute("list", dao.queryDiscountCode());
        return "discount_code";
    }
}
