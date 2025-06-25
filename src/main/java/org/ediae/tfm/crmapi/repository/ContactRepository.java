package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    // Custom query methods can be added here if needed

}
