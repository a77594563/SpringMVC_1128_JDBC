package com.web.mvc.repository;

import com.web.mvc.entity.PUView;
import com.web.mvc.repository.spec.PUViewDao;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("puViewDao")
public class PUViewDaoImpl implements PUViewDao{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<PUView> queryPUView() {
        String sql = "SELECT * FROM PU_VIEW";
        return jdbcTemplate.query(sql, RM.puViewMapper);
    }

    @Override
    public List<PUView> queryPUViewByProductCodeName(String productCodeName) {
        String sql = "SELECT * FROM PU_VIEW WHERE PORDUCT_CODE_NAME = ?";
        List<PUView> list = jdbcTemplate.query(sql, new Object[]{productCodeName}, RM.puViewMapper);
        return list;
    }
    
}
