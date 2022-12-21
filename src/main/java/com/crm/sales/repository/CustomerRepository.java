package com.crm.sales.repository;

import com.crm.sales.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c.* from Customer C" +
            " inner join Customer_Address ca on ca.customer_id = C.id" +
            " inner join Address a on a.id = ca.address_id" +
            " where zipcode = ?", nativeQuery = true)
    List<Customer> findCustomerByZipCode(String zipcode);

}
