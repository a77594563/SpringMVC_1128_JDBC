package com.web.mvc.repository;

import com.web.mvc.entity.Customer;
import com.web.mvc.entity.DiscountCode;
import com.web.mvc.entity.MicroMarket;
import com.web.mvc.repository.spec.CustomerDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Customer> queryCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DiscountCode> queryDiscountCode() {
        String sql = "SELECT * FROM DISCOUNT_CODE";
        return jdbcTemplate.query(sql, RM.discountCode);
    }

    @Override
    public List<MicroMarket> queryMicroMarket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
