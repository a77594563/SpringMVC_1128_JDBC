package com.web.listener;


import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationData implements ServletContextListener {
    private static final Map menus = new LinkedHashMap();
    static {
        menus.put("discount_code", new String[]{"mvc/discount_code/input", "折扣碼"});
        menus.put("micro_market", new String[]{"mvc/micro_market/input", "市場區域"});
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("menus", menus);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
    }
}
