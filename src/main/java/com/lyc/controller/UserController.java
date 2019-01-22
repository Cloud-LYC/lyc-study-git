package com.lyc.controller;

import com.alibaba.fastjson.JSON;
import com.lyc.dto.UserDTO;
import com.lyc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class UserController {
	
    @Resource  
    private UserService userService;  
      
    @RequestMapping("/showUserInfo")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("userInfo");
        UserDTO userDTO = userService.selectUserById(1);
        mav.addObject("user", JSON.toJSON(userDTO));
        return mav;    
    } 
}
