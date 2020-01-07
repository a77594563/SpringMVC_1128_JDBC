package com.web.mvc.repository;

import com.web.mvc.entity.Manufacturer;
import com.web.mvc.entity.Product;
import com.web.mvc.entity.ProductCode;
import com.web.mvc.repository.spec.ProductDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "productDao")
public class ProductDaoImpl implements ProductDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<ProductCode> queryProductCode() {
        String sql = "SELECT * FROM PRODUCT_CODE";
        List<ProductCode> list = jdbcTemplate.query(sql, RM.productCodeMapper);
        return list;
    }

    @Override
    public ProductCode getProductCode(String code) {
        String sql = "SELECT * FROM PRODUCT_CODE WHERE PROD_CODE = ?";
        ProductCode pc = jdbcTemplate.queryForObject(sql, new Object[]{code}, RM.productCodeMapper);
        return pc;
    }

    @Override
    public void saveProductCode(ProductCode pc) {
        String sql = "INSERT INTO PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, pc.getProdCode(), pc.getDiscountCode(), pc.getDescription());
    }

    @Override
    public void updateProductCode(ProductCode pc) {
        String sql = "UPDATE PRODUCT_CODE SET DISCOUNT_CODE = ?, DESCRIPTION = ? WHERE PROD_CODE = ?";
        jdbcTemplate.update(sql, pc.getDiscountCode(), pc.getDescription(), pc.getProdCode());
    }

    @Override
    public void deleteProductCode(String code) {
        String sql = "DELETE FROM PRODUCT_CODE WHERE PROD_CODE = ?";
        jdbcTemplate.update(sql, code);
    }

    @Override
    public List<Manufacturer> queryManufacturer() {
        String sql = "SELECT * FROM MANUFACTURER";
        List<Manufacturer> list = jdbcTemplate.query(sql, RM.manufacturerMapper);
        return list;
    }

    @Override
    public Manufacturer getManufacturer(Integer id) {
        String sql = "SELECT * FROM MANUFACTURER WHERE MANUFACTURER_ID = ?";
        Manufacturer mf = jdbcTemplate.queryForObject(sql, new Object[]{id}, RM.manufacturerMapper);
        return mf;
    }

    @Override
    public void saveManufacturer(Manufacturer mf) {
        String sql = "INSERT INTO MANUFACTURER(MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2,"
                + "CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                mf.getManufacturerId(), mf.getName(), mf.getAddressline1(), mf.getAddressline2(),
                mf.getCity(), mf.getState(), mf.getZip(), mf.getPhone(), mf.getFax(), mf.getEmail(), mf.getRep()
        );
    }

    @Override
    public void updateManufacturer(Manufacturer mf) {
        String sql = "UPDATE MANUFACTURER SET NAME = ?, ADDRESSLINE1 = ?, ADDRESSLINE2 = ?,"
                + "CITY = ?, STATE = ?, ZIP = ?, PHONE = ?, FAX = ?, EMAIL = ?, REP = ? "
                + "WHERE MANUFACTURER_ID = ?";
        jdbcTemplate.update(sql,
                mf.getName(), mf.getAddressline1(), mf.getAddressline2(),
                mf.getCity(), mf.getState(), mf.getZip(), mf.getPhone(), mf.getFax(), mf.getEmail(), mf.getRep(),
                mf.getManufacturerId()
        );
    }

    @Override
    public void deleteManufacturer(Integer id) {
        String sql = "DELETE FROM MANUFACTURER WHERE MANUFACTURER_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Product> queryProduct() {
        String sql = "SELECT * FROM PRODUCT";
        List<Product> list = jdbcTemplate.query(sql, RM.productMapper);
        return list;
    }

    @Override
    public Product getProduct(Integer id) {
        String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
        Product p = jdbcTemplate.queryForObject(sql, new Object[]{id}, RM.productMapper);
        return p;
    }

    @Override
    public void saveProduct(Product p) {
        String sql = "INSERT INTO PRODUCT"
                + "(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, "
                + "QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                p.getProductId(), p.getManufacturerId(), p.getProductCode(), p.getPurchaseCost(),
                p.getQuantityOnHand(), p.getMarkup(), p.getAvailable(), p.getDescription()
        );
    }

    @Override
    public void updateProduct(Product p) {
        String sql = "UPDATE PRODUCT SET "
                + "MANUFACTURER_ID = ?, PRODUCT_CODE = ?, PURCHASE_COST = ?, QUANTITY_ON_HAND = ?, "
                + "MARKUP = ?, AVAILABLE = ?, DESCRIPTION = ? "
                + "WHERE PRODUCT_ID = ?";
        jdbcTemplate.update(sql,
                p.getManufacturerId(), p.getProductCode(), p.getPurchaseCost(), p.getQuantityOnHand(), 
                p.getMarkup(), p.getAvailable(), p.getDescription(),
                p.getProductId()
        );    
    }

    @Override
    public void deleteProduct(Integer id) {
        String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
