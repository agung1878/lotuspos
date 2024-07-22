package com.cashier.services;

import com.cashier.dao.ItemLibraryDao;
import com.cashier.dao.OutletDao;
import com.cashier.entity.ItemLibrary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LibraryServices {

    @Autowired
    private ItemLibraryDao itemLibraryDao;

    public void saveItemLibrary(ItemLibrary itemLibrary) {

        ItemLibrary itemLibrary1 = new ItemLibrary();
        itemLibrary1.setPrice(itemLibrary.getPrice());
        itemLibrary1.setName(itemLibrary.getName());
        itemLibrary1.setPrice(itemLibrary.getPrice());
        itemLibraryDao.save(itemLibrary1);


        itemLibraryDao.save(itemLibrary1);
    }

}
