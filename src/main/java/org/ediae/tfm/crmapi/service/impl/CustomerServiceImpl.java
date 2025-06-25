package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.Customer;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.repository.CustomerRepository;
import org.ediae.tfm.crmapi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ICustomerService customerService;


    @Override
    public List<Customer> findAllCustomers() throws GeneralException {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    @Override
    public Customer findCustomerById(Long id) throws GeneralException {
        try {
            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            if (optionalCustomer.isPresent()) {
                return optionalCustomer.get();
            } else {
                throw new GeneralException(
                        GeneralConstants.CUSTOMER_NOT_FOUND_CODE,
                        GeneralConstants.CUSTOMER_NOT_FOUND_MESSAGE);
            }
        } catch (GeneralException genEx) {
            throw genEx;
        } catch (Exception ex) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    @Override
    public Customer createCustomer(Customer customer) throws GeneralException {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.CUSTOMER_CREATION_ERROR_CODE,
                    GeneralConstants.CUSTOMER_CREATION_ERROR_MESSAGE
            );
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) throws GeneralException {
        if (customer.getId() == null || !customerRepository.existsById(customer.getId())) {
            throw new GeneralException(
                    GeneralConstants.CUSTOMER_NOT_FOUND_CODE,
                    GeneralConstants.CUSTOMER_NOT_FOUND_MESSAGE
            );
        }

        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.CUSTOMER_UPDATE_ERROR_CODE,
                    GeneralConstants.CUSTOMER_UPDATE_ERROR_MESSAGE
            );
        }
    }

    @Override
    public Boolean deleteCustomerById(Long id) throws GeneralException {
        if(!customerRepository.existsById(id)){
            throw new GeneralException(
                    GeneralConstants.CUSTOMER_NOT_FOUND_CODE,
                    GeneralConstants.CUSTOMER_NOT_FOUND_MESSAGE
            );
        }
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.CUSTOMER_DELETE_ERROR_CODE,
                    GeneralConstants.CUSTOMER_DELETE_ERROR_MESSAGE
            );
        }
    }
}
