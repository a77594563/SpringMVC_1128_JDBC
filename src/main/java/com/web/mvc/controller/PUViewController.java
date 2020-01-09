package com.web.mvc.controller;

import com.web.mvc.repository.spec.PUViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("puView")
public class PUViewController extends BaseController{
    
    @Autowired
    @Qualifier("puViewDao")
    private PUViewDao dao;
    
        @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("list", dao.queryPUView());
        return "pu_view";
    }
    
    @GetMapping("/query/{codeName}")
    public String query(@PathVariable("codeName") String codeName, Model model) {
        model.addAttribute("list", dao.queryPUViewByProductCodeName(codeName));
        return "pu_view";
    }
    
}
