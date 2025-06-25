package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.entity.Contact;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private IContactService contactService;


    @GetMapping ("/get")
    public ModelMap getContacts() throws GeneralException {
    try {
        return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.getContacts());
    } catch (Exception ex) {
        return GeneralControllerUtils.crearRespuestaModelMapError(ex);
    }
    }



    @PostMapping("/create")
    public ModelMap createContact(@RequestBody Contact contact) throws GeneralException{
        try {
            return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.createContact(contact));
        } catch (Exception ex) {
            return GeneralControllerUtils.crearRespuestaModelMapError(ex);
        }
    }


    @PutMapping("/edit")
    public ModelMap editContact( @RequestBody Contact contact) throws GeneralException{
        try {
            return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.editContact(contact));
        } catch (Exception ex) {
            return GeneralControllerUtils.crearRespuestaModelMapError(ex);
        }
    }



    @DeleteMapping("/delete/{id}")
    public ModelMap deleteContact(@PathVariable Long id) {
        try {
            return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.deleteContact(id));
        } catch (Exception ex) {
            return GeneralControllerUtils.crearRespuestaModelMapError(ex);
        }
    }

}
