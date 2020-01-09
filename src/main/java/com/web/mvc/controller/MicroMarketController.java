package com.web.mvc.controller;

import com.web.mvc.entity.DiscountCode;
import com.web.mvc.entity.MicroMarket;
import com.web.mvc.repository.spec.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/micro_market")
public class MicroMarketController extends BaseController{
    
    @Autowired
    @Qualifier("customerDao")
    CustomerDao dao;
    
    @GetMapping("/input")
    public String input(Model model) {
        model.addAttribute("po", new MicroMarket());
        model.addAttribute("list", dao.queryMicroMarket());
        model.addAttribute("_method", "POST");
        return "micro_market";
    }
    
    @GetMapping("/{code}")
    public String get(@PathVariable("code") String code, Model model) {
        MicroMarket mm = dao.getMicroMarket(code);
        model.addAttribute("po", mm);
        model.addAttribute("list", dao.queryMicroMarket());
        model.addAttribute("_method", "PUT");
        return "micro_market";
    }
    
    @PostMapping("/")
    public String save(@ModelAttribute MicroMarket mm) {
        dao.saveMicroMarket(mm);
        return "redirect:./input";
    }
    
    @PutMapping("/")
    public String update(@ModelAttribute MicroMarket mm) {
        dao.updateMicroMarket(mm);
        return "redirect:./input";
    }
    
    @DeleteMapping("/{code}")
    public String delete(@PathVariable("code") String code) {
        dao.deleteMicroMarket(code);
        return "redirect:./input";
    }
    
}
