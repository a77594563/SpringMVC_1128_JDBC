package com.web.mvc.controller;

import com.web.mvc.entity.ProductCode;
import com.web.mvc.repository.spec.CustomerDao;
import com.web.mvc.repository.spec.ProductDao;
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
@RequestMapping("/product_code")
public class ProductCodeController {

    @Autowired
    @Qualifier("productDao")
    private ProductDao dao;
    
    @Autowired
    @Qualifier("customerDao")
    private CustomerDao customerDao;
    
    @GetMapping("/input")
    public String query(Model model) {
        ProductCode po = new ProductCode();
        model.addAttribute("po", po);
        model.addAttribute("list", dao.queryProductCode());
        model.addAttribute("list_dc", customerDao.queryDiscountCode());
        model.addAttribute("_method", "POST");
        return "product_code";
    }

    @GetMapping("/{code}")
    public String get(@PathVariable("code") String code, Model model) {
        model.addAttribute("po", dao.getProductCode(code));
        model.addAttribute("list", dao.queryProductCode());
        model.addAttribute("list_dc", customerDao.queryDiscountCode());
        model.addAttribute("_method", "PUT");
        return "product_code";
    }

    @PostMapping("/")
    public String post(@ModelAttribute ProductCode pc) {
        dao.saveProductCode(pc);
        return "redirect:./input";
    }

    @PutMapping("/")
    public String put(@ModelAttribute ProductCode pc) {
        dao.updateProductCode(pc);
        return "redirect:./input";
    }

    @DeleteMapping("/{code}")
    public String delete(@PathVariable("code") String code) {
        dao.deleteProductCode(code);
        return "redirect:./input";
    }

}
