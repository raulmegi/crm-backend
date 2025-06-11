package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.entity.Contact;
import org.ediae.tfm.crmapi.service.IContactService;
import org.hibernate.metamodel.mapping.ModelPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}, allowedHeaders = "*")
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private IContactService contactService;


    @GetMapping ("/get")
    public ModelMap getContacts(@RequestParam String userNick,@RequestParam String password) throws GeneralException, UsuarioNoValidoException {
    try {
        return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.getContacts(userNick, password));
    } catch (Exception ex) {
        return GeneralControllerUtils.crearRespuestaModelMapError(ex);
    }
    }

    @GetMapping("/create")
    public ModelMap createContact(@RequestParam String userNick,@RequestParam String password, Contact contact) throws GeneralException, UsuarioNoValidoException {
        try {
            return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.createContact(userNick, password, contact));
        } catch (Exception ex) {
            return GeneralControllerUtils.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/edit")
    public ModelMap editContact(@RequestParam String userNick, @RequestParam String password, Contact contact) throws GeneralException, UsuarioNoValidoException {
        try {
            return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.deleteContact(userNick, password, contact));
        } catch (Exception ex) {
            return GeneralControllerUtils.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/delete")
    public ModelMap deleteContact(@RequestParam String userNick, @RequestParam String password, @PathVariable Long id) {
        try {
            return GeneralControllerUtils.crearRespuestaModelMapOk(contactService.deleteContact(userNick, password, id));
        } catch (Exception ex) {
            return GeneralControllerUtils.crearRespuestaModelMapError(ex);
        }
    }
}
