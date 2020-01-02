
package com.web.mvc.repository;

import com.web.mvc.entity.DiscountCode;
import org.springframework.jdbc.core.RowMapper;

public class RM {
    static RowMapper<DiscountCode> discountCode = (rs, i) ->{
                DiscountCode dc = new DiscountCode();
                dc.setDiscountCode(rs.getString("DISCOUNT_CODE"));
                dc.setRate(rs.getDouble("RATE"));
                return dc;
           };
}
