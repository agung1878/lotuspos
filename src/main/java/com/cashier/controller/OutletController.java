package com.cashier.controller;

import com.cashier.dao.OutletDao;
import com.cashier.entity.Outlet;
import com.cashier.services.OutletServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller @RequestMapping("/outlet")
@Slf4j
public class OutletController {

    @Autowired
    private OutletServices outletServices;

    @Autowired
    OutletDao outletDao;

    @GetMapping("/list")
    public String outletList(ModelMap model) {

        model.addAttribute("outlets", outletDao.findAll());

        return "outlet/list";
    }

    @GetMapping("/form")
    public String outletForm(ModelMap model) {

        model.addAttribute("outlet", new Outlet());

        return "outlet/form";
    }

    @PostMapping("/form")
    public String outletSubmit(ModelMap modelMap, @Valid Outlet outlet, Principal principal) {

        log.debug("principal {}", principal.getName());
        modelMap.addAttribute("outlet", outlet);

        outletServices.save(outlet, principal.getName());

        return "redirect:/outlet/list";
    }

}
