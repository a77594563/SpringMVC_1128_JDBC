package com.web.mvc.repository.spec;

import com.web.mvc.entity.MicroMarket;
import java.util.List;

public interface MicroMarketDao {
    List<MicroMarket> queryMicroMarket();
    MicroMarket getMicroMarket(String code);
    void saveMicroMarket(MicroMarket dc);
    void updateMicroMarket(MicroMarket dc);
    void deleteMicroMarket(String code);
}
