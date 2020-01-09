package com.web.mvc.repository.spec;

import com.web.mvc.entity.PUView;
import java.util.List;

public interface PUViewDao {
    List<PUView> queryPUView();
    List<PUView> queryPUViewByProductCodeName(String productCodeName);
}
