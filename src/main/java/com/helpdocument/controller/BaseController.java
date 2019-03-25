package com.helpdocument.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yanyan.wang
 * @date 2015-11-11 11:11
 */
@Controller
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler
    public ModelAndView exceptionHandle(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("/500");
        StringBuffer errorInfo = new StringBuffer();
        errorInfo.append("request path:").append(request.getContextPath())
                .append(request.getServletPath())
                .append(",pathInfo:")
                .append(request.getPathInfo())
                .append(",queryString:")
                .append(request.getQueryString());
        logger.error(errorInfo.toString(), ex);
        modelAndView.addObject("exception", ex.getMessage());
        modelAndView.addObject("errorInfo", errorInfo);
        modelAndView.addObject("cause", ex.getCause());
        modelAndView.addObject("requestUrl", request.getRequestURL());
        return modelAndView;
    }
}
