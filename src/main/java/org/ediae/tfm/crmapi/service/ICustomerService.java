package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(int id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Boolean deleteCustomerById(int id);


}
