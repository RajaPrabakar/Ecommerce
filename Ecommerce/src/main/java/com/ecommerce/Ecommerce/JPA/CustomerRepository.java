package com.ecommerce.Ecommerce.JPA;

import com.ecommerce.Ecommerce.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
List<Customer> findByUserNameAndPassword(String userName, String password);
}
