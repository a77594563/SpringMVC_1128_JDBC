package com.web.mvc.controller;

import com.web.mvc.entity.PurchaseOrder;
import com.web.mvc.repository.spec.CustomerDao;
import com.web.mvc.repository.spec.ProductDao;
import com.web.mvc.repository.spec.PurchaseOrderDao;
import com.web.mvc.validator.PurchaseOrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase_order")
public class PurchaseOrderController extends BaseController{

    @Autowired
    @Qualifier("purchaseOrderDao")
    private PurchaseOrderDao dao;
    
    @Autowired
    @Qualifier("customerDao")
    private CustomerDao dao_c;
    
    @Autowired
    @Qualifier("productDao")
    private ProductDao dao_p;
    
    @Autowired
    private PurchaseOrderValidator validator;
    
    @RequestMapping("/input")
    public String input(Model model) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        model.addAttribute("purchaseOrder", purchaseOrder);
        model.addAttribute("list", dao.queryPurchaseOrder());
        model.addAttribute("list_c", dao_c.queryCustomer());
        model.addAttribute("list_p", dao_p.queryProduct());
        model.addAttribute("_method", "POST");
        return "purchase_order";
    }
    
    @RequestMapping("/{num}")
    public String get(@PathVariable("num") Integer num, Model model) {
        model.addAttribute("purchaseOrder", dao.getPurchaseOrder(num));
        model.addAttribute("list", dao.queryPurchaseOrder());
        model.addAttribute("list_c", dao_c.queryCustomer());
        model.addAttribute("list_p", dao_p.queryProduct());
        model.addAttribute("_method", "PUT");
        return "purchase_order";
    }

    @PostMapping("/")
    public String save(@ModelAttribute PurchaseOrder purchaseOrder, BindingResult result, Model model) {
        this.validator.validate(purchaseOrder, result); // 驗證
        if(result.hasErrors()) {
            model.addAttribute("list", dao.queryPurchaseOrder());
            model.addAttribute("list_c", dao_c.queryCustomer());
            model.addAttribute("list_p", dao_p.queryProduct());
            model.addAttribute("_method", "POST");
            return "purchase_order";
        }
        dao.savePurchaseOrder(purchaseOrder);
        return "redirect:./input";
    }

    @PutMapping("/")
    public String update(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
        dao.updatePurchaseOrder(purchaseOrder);
        return "redirect:./input";
    }

    @DeleteMapping("/{num}")
    public String delete(@PathVariable("num") Integer num) {
        dao.deletePurchaseOrder(num);
        return "redirect:./input";
    }


}
