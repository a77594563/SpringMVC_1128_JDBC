package com.web.mvc.repository;

import com.web.mvc.entity.Customer;
import com.web.mvc.entity.DiscountCode;
import com.web.mvc.entity.MicroMarket;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class RM {
    static RowMapper<DiscountCode> discountCode = (rs, i) -> {
        DiscountCode dc = new DiscountCode();
        dc.setDiscountCode(rs.getString("DISCOUNT_CODE"));
        dc.setRate(rs.getDouble("RATE"));
        return dc;
    };
    
    static RowMapper<MicroMarket> microMarketMapper = (ResultSet rs, int rowNum) -> {
        MicroMarket mm = new MicroMarket();
        mm.setZipCode(rs.getString("ZIP_CODE"));
        mm.setRadius(rs.getDouble("RADIUS"));
        mm.setAreaLength(rs.getDouble("AREA_LENGTH"));
        mm.setAreaWidth(rs.getDouble("AREA_WIDTH"));
        return mm;
    };
    
    static RowMapper<Customer> customerMapper = (ResultSet rs, int rowNum) -> {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
        customer.setDiscountCode(rs.getString("DISCOUNT_CODE"));
        customer.setZip(rs.getString("ZIP"));
        customer.setName(rs.getString("NAME"));
        customer.setAddressline1(rs.getString("ADDRESSLINE1"));
        customer.setAddressline2(rs.getString("ADDRESSLINE2"));
        customer.setCity(rs.getString("CITY"));
        customer.setState(rs.getString("STATE"));
        customer.setPhone(rs.getString("PHONE"));
        customer.setFax(rs.getString("FAX"));
        customer.setEmail(rs.getString("EMAIL"));
        customer.setCreditLimit(rs.getInt("CREDIT_LIMIT"));
        return customer;
    };
    
}
