package com.cashier.config;

import com.cashier.dao.UserDao;
import com.cashier.entity.security.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice(basePackages = {"com.cashier.controller"})
@Slf4j
public class GlobalControllerConfig {

    @Autowired
    private UserDao userDao;

    @ModelAttribute
    public void globalAttribute(ModelMap modelMap, Principal principal){

        if(principal != null){

            User user = userDao.findByUsername(principal.getName());
            if(user != null){
                modelMap.addAttribute("loggedUserRole",user.getRole().getName());
                modelMap.addAttribute("loggedUsername",user.getUsername());
            }

        }

    }

}

