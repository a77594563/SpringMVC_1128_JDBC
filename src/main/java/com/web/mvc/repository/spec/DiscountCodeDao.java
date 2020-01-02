package com.web.mvc.repository.spec;

import com.web.mvc.entity.DiscountCode;
import java.util.List;

public interface DiscountCodeDao {
    List<DiscountCode> queryDiscountCode();
}
