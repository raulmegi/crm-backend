package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Contact;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.exception.NoValidUserException;

import java.util.List;


public interface IContactService {
//    List<Contact> getContacts(String user, String password) throws GeneralException, NoValidUserException;
//    Contact createContact(String user, String password, Contact contact) throws GeneralException, NoValidUserException;
//    Contact editContact(String user, String password, Contact contact) throws GeneralException, NoValidUserException;
//    Boolean deleteContact(String user, String password, Long id) throws GeneralException, NoValidUserException;
List<Contact> getContacts() throws GeneralException;
    Contact createContact(Contact contact) throws GeneralException;
    Contact editContact(Contact contact) throws GeneralException;
    Boolean deleteContact(Long id) throws GeneralException, NoValidUserException;

}
