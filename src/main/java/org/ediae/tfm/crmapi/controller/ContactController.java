package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.entity.Contact;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private IContactService contactService;


    @GetMapping ("/get")
    public ModelMap getContacts() {
    try {
        return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.getContacts());
    } catch (Exception ex) {
        return GeneralControllerUtils.crearRespuestaModelMapError(ex);
    }
    }

    @GetMapping("/findByName")
    public ModelMap getContactsByName(@RequestParam String name) {
        try {
            return GeneralControllerUtils.crearRespuestaModelMapOk((contactService.getContactsByName(name)));
        } catch (Exception ex) {
            return GeneralControllerUtils.crearRespuestaModelMapError(ex);
        }
    }

    @PostMapping("/create")
    public ModelMap createContact(@RequestBody Contact contact) {
        try {
            return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.createContact(contact));
        } catch (Exception ex) {
            return GeneralControllerUtils.crearRespuestaModelMapError(ex);
        }
    }


    @PutMapping("/edit")
    public ModelMap editContact( @RequestBody Contact contact){
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
