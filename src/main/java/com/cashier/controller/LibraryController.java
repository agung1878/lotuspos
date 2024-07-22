package com.cashier.controller;

import com.cashier.entity.ItemLibrary;
import com.cashier.services.LibraryServices;
import jakarta.validation.Valid;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryServices libraryServices;

    @GetMapping("/item/list")
    public String getItemLibrary(){
        return "item_library/list";
    }

    @GetMapping("/item/form")
    public String getFormItemLibrary(ModelMap model){
        model.addAttribute("item", new ItemLibrary());
        return "item_library/form";
    }

    @PostMapping("/item/form")
    public String postFormItemLibrary(@Valid ItemLibrary item, BindingResult result, ModelMap model){
        model.addAttribute("item", item);

        libraryServices.saveItemLibrary(item);
        return "redirect:/library/item";
    }
}
