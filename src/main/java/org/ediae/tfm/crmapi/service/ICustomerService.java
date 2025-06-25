package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Customer;
import org.ediae.tfm.crmapi.exception.GeneralException;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAllCustomers() throws GeneralException;
    Customer findCustomerById(Long id) throws GeneralException;
    Customer createCustomer(Customer customer) throws GeneralException;
    Customer updateCustomer(Customer customer) throws GeneralException;
    Boolean deleteCustomerById(Long id) throws GeneralException;


}
