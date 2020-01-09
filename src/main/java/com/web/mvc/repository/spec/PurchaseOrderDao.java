package com.web.mvc.repository.spec;

import com.web.mvc.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderDao{
    List<PurchaseOrder> queryPurchaseOrder();
    PurchaseOrder getPurchaseOrder(Integer num);
    void savePurchaseOrder(PurchaseOrder purchaseOrder);
    void updatePurchaseOrder(PurchaseOrder purchaseOrder);
    void deletePurchaseOrder(Integer num);
}
