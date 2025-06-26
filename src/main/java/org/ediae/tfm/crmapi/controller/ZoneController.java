package org.ediae.tfm.crmapi.controller;


import org.ediae.tfm.crmapi.service.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    private IZoneService zoneService;

    @GetMapping("/listarZonas")
    public ModelMap findAllZones() {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(zoneService.findAllZones());
        } catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/encontrarZona/{id}")
    public ModelMap getZoneById(@PathVariable Long id) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(zoneService.findZoneById(id));
        }catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }
}
