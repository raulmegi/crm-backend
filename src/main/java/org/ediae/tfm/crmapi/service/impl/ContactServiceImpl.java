package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.Contact;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.repository.ContactRepository;
import org.ediae.tfm.crmapi.service.IContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) throws GeneralException {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) throws GeneralException {
        try {
            return contactRepository.save(contact);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.CONTACT_CREATION_ERROR_CODE,
                    GeneralConstants.CONTACT_CREATION_ERROR_MESSAGE);
        }
    }

    @Override
    public List<Contact> getContacts() throws GeneralException{
        try {
            return contactRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE
            );
        }
    }

    public Contact findById(Long id) throws GeneralException{
        try {
            Optional<Contact> optionalContact= contactRepository.findById(id);
            if(optionalContact.isPresent()) {
                return optionalContact.get();
            } else {
                throw new GeneralException(GeneralConstants.CONTACT_NOT_FOUND_CODE, GeneralConstants.CONTACT_NOT_FOUND_MESSAGE);
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
    public Contact editContact(Contact contact) throws GeneralException {
        if (contact.getId() == null || !contactRepository.existsById(contact.getId())) {
            throw new GeneralException(
                    GeneralConstants.CONTACT_NOT_FOUND_CODE,
                    GeneralConstants.CONTACT_NOT_FOUND_MESSAGE
            );
        }

        try {
            return contactRepository.save(contact);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.CONTACT_EDIT_ERROR_CODE,
                    GeneralConstants.CONTACT_EDIT_ERROR_MESSAGE
            );
        }

    }

    @Override
    public Boolean deleteContact(Long id) throws GeneralException {
        if (!contactRepository.existsById(id)) {
            throw new GeneralException(
                    GeneralConstants.CONTACT_NOT_FOUND_CODE,
                    GeneralConstants.CONTACT_NOT_FOUND_MESSAGE
            );
        }

        try {
            contactRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.CONTACT_DELETE_ERROR_CODE,
                    GeneralConstants.CONTACT_DELETE_ERROR_MESSAGE
            );
        }
    }
    }


