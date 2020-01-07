package com.web.mvc.repository.spec;

import com.web.mvc.entity.Customer;
import java.util.List;

public interface CustomerDao extends DiscountCodeDao, MicroMarketDao {
    List<Customer> queryCustomer();
    Customer getCustomer(Integer id);
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer id);
}
