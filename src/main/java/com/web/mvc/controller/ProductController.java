package com.web.mvc.controller;

import com.web.mvc.entity.Product;
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
@RequestMapping("/product")
public class ProductController {

   @Autowired
    @Qualifier("productDao")
    private ProductDao dao;

    @GetMapping("/input")
    public String query(Model model) {
        Product po = new Product();
        model.addAttribute("po", po);
        model.addAttribute("list", dao.queryProduct());
        model.addAttribute("list_mf", dao.queryManufacturer());
        model.addAttribute("list_pc", dao.queryProductCode());
        model.addAttribute("_method", "POST");
        return "product";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("po", dao.getProduct(id));
        model.addAttribute("list", dao.queryProduct());
        model.addAttribute("list_mf", dao.queryManufacturer());
        model.addAttribute("list_pc", dao.queryProductCode());
        model.addAttribute("page", "product");
        model.addAttribute("_method", "PUT");
        return "product";
    }

    @PostMapping("/")
    public String post(@ModelAttribute Product p) {
        dao.saveProduct(p);
        return "redirect:./input";
    }

    @PutMapping("/")
    public String put(@ModelAttribute Product p) {
        dao.updateProduct(p);
        return "redirect:./input";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        dao.deleteProduct(id);
        return "redirect:./input";
    }


}
