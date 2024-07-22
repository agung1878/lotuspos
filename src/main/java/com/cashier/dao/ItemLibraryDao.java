package com.cashier.dao;

import com.cashier.entity.ItemLibrary;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemLibraryDao extends CrudRepository<ItemLibrary, String>, PagingAndSortingRepository<ItemLibrary, String>, JpaSpecificationExecutor<ItemLibrary> {
}
