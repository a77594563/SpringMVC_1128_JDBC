package com.web.mvc.validator;

import com.web.mvc.entity.PurchaseOrder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PurchaseOrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> klass) {
        // 設定要驗證的 bean, 返回值若為 false 則不驗證
        return PurchaseOrder.class.isAssignableFrom(klass);
    } 
    @Override
    public void validate(Object object, Errors errors) {
        PurchaseOrder po = (PurchaseOrder)object; // 要驗證的對象
        // 採購編號不可空白或為0
        if(po.getOrderNum() == null || po.getOrderNum() <= 0) {
            errors.rejectValue("orderNum", "purchaseOrder.orderNum.invalid");
        }
        // 數量不可空白且需大於0 (數量 > 0)
        if(po.getQuantity() == null || po.getQuantity() <= 0) {
            errors.rejectValue("quantity", "purchaseOrder.quantity.invalid");
        }
        // 運費不可空白且不得低於10美金
        if(po.getShippingCost() == null || po.getShippingCost() < 10) {
            errors.rejectValue("shippingCost", "purchaseOrder.shippingCost.invalid");
        }
        
    }
}
