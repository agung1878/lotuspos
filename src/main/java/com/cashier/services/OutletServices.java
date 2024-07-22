package com.cashier.services;

import com.cashier.dao.ItemLibraryDao;
import com.cashier.dao.OutletDao;
import com.cashier.dao.UserDao;
import com.cashier.entity.ItemLibrary;
import com.cashier.entity.Outlet;
import com.cashier.entity.security.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OutletServices {

    @Autowired
    private OutletDao outletDao;

    @Autowired
    private UserDao userDao;

    public void save(Outlet outlet, String username) {


        Outlet newOutlet = new Outlet();
        newOutlet.setAddress(outlet.getAddress());
        newOutlet.setName(outlet.getName());
        newOutlet.setDescription(outlet.getDescription());

        User user = userDao.findByUsername("admin.app@yopmail.com");
        log.debug("user = {}", user);
        newOutlet.setUser(user);

        outletDao.save(newOutlet);
    }

}
