package com.cashier.dao;

import com.cashier.entity.Outlet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OutletDao extends CrudRepository<Outlet, String>, PagingAndSortingRepository<Outlet, String>, JpaSpecificationExecutor<Outlet> {
}
