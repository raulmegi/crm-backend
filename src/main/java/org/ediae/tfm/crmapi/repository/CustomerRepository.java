package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {


}
