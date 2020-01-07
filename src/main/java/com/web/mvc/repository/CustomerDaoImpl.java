package com.web.mvc.repository;

import com.web.mvc.entity.Customer;
import com.web.mvc.entity.DiscountCode;
import com.web.mvc.entity.MicroMarket;
import com.web.mvc.repository.spec.CustomerDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository(value = "customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DiscountCode> queryDiscountCode() {
        String sql = "SELECT * FROM DISCOUNT_CODE";
        return jdbcTemplate.query(sql, RM.discountCode);
    }

    @Override
    public DiscountCode getDiscountCode(String code) {
        String sql = "SELECT * FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
        DiscountCode dc = jdbcTemplate.queryForObject(sql, new Object[]{code}, RM.discountCode);
        return dc;
    }
    
    @Override
    public void saveDiscountCode(DiscountCode dc) {
        String sql = "INSERT INTO DISCOUNT_CODE(DISCOUNT_CODE, RATE) VALUES(?, ?)";
        jdbcTemplate.update(sql, dc.getDiscountCode(), dc.getRate());
    }

    @Override
    public void updateDiscountCode(DiscountCode dc) {
        String sql = "UPDATE DISCOUNT_CODE SET RATE = ? WHERE DISCOUNT_CODE = ?";
        jdbcTemplate.update(sql, dc.getRate(), dc.getDiscountCode());
    }

    @Override
    public void deleteDiscountCode(String code) {
        String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
        jdbcTemplate.update(sql, code);
    }

    @Override
    public List<MicroMarket> queryMicroMarket() {
        String sql = "SELECT * FROM MICRO_MARKET";
        List<MicroMarket> list = jdbcTemplate.query(sql, RM.microMarketMapper);
        return list;
    }

    @Override
    public MicroMarket getMicroMarket(String code) {
        String sql = "SELECT * FROM MICRO_MARKET WHERE ZIP_CODE = ?";
        MicroMarket dc = jdbcTemplate.queryForObject(sql, new Object[]{code}, RM.microMarketMapper);
        return dc;
    }

    @Override
    public void saveMicroMarket(MicroMarket mm) {
        String sql = "INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, mm.getZipCode(), mm.getRadius(), mm.getAreaLength(), mm.getAreaWidth());
    }

    @Override
    public void updateMicroMarket(MicroMarket mm) {
        String sql = "UPDATE MICRO_MARKET SET RADIUS = ?, AREA_LENGTH = ?, AREA_WIDTH = ? WHERE ZIP_CODE = ?";
        jdbcTemplate.update(sql, mm.getRadius(), mm.getAreaLength(), mm.getAreaWidth(), mm.getZipCode());
    }

    @Override
    public void deleteMicroMarket(String code) {
        String sql = "DELETE FROM MICRO_MARKET WHERE ZIP_CODE = ?";
        jdbcTemplate.update(sql, code);
    }
    
    @Override
    public List<Customer> queryCustomer() {
        String sql = "SELECT * FROM CUSTOMER";
        List<Customer> list = jdbcTemplate.query(sql, RM.customerMapper);
        return list;
    }

    @Override
    public Customer getCustomer(Integer id) {
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{id}, RM.customerMapper);
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        String sql = "INSERT INTO CUSTOMER("
                + "CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, "
                + "ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, "
                + "PHONE, FAX, EMAIL, CREDIT_LIMIT) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                customer.getCustomerId(),
                customer.getDiscountCode(),
                customer.getZip(),
                customer.getName(),
                customer.getAddressline1(),
                customer.getAddressline2(),
                customer.getCity(),
                customer.getState(),
                customer.getPhone(),
                customer.getFax(),
                customer.getEmail(),
                customer.getCreditLimit());
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE CUSTOMER SET "
                + "DISCOUNT_CODE = ?, ZIP = ?, NAME = ?, "
                + "ADDRESSLINE1 = ?, ADDRESSLINE2 = ?, CITY = ?, STATE = ?, "
                + "PHONE = ?, FAX = ?, EMAIL = ?, CREDIT_LIMIT = ? "
                + "WHERE CUSTOMER_ID = ?";
        jdbcTemplate.update(sql,
                customer.getDiscountCode(),
                customer.getZip(),
                customer.getName(),
                customer.getAddressline1(),
                customer.getAddressline2(),
                customer.getCity(),
                customer.getState(),
                customer.getPhone(),
                customer.getFax(),
                customer.getEmail(),
                customer.getCreditLimit(),
                customer.getCustomerId());
    }

    @Override
    public void deleteCustomer(Integer id) {
        String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        jdbcTemplate.update(sql, id);
    }
    
    

}
