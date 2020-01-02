package com.web.mvc.repository.spec;

import com.web.mvc.entity.Customer;
import java.util.List;

public interface CustomerDao extends DiscountCodeDao, MicroMarketDao{
    List<Customer> queryCustomer();
}
