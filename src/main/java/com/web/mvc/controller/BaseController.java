package com.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {
    
    @ExceptionHandler
    public String exception(HttpServletRequest req, Exception ex) {
        req.setAttribute("ex", ex);
        return "/error/error_page";
    }
}
