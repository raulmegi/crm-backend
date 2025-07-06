package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Contact;
import org.ediae.tfm.crmapi.exception.GeneralException;

import java.util.List;


public interface IContactService {

    List<Contact> getContacts() throws GeneralException;
    Contact createContact(Contact contact) throws GeneralException;
    Contact editContact(Contact contact) throws GeneralException;
    Boolean deleteContact(Long id) throws GeneralException;
    List<Contact> getContactsByName(String name) throws GeneralException;
}
