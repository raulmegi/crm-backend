package org.ediae.tfm.crmapi.controller;
import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.springframework.ui.ModelMap;

import java.util.HashMap;

public class GeneralUtilsController {
    static ModelMap crearRespuestaModelMapOk(Object data) {
        ModelMap response = new ModelMap();
        response.put(GeneralConstants.TYPE, GeneralConstants.OK);
        response.put(GeneralConstants.EXCEPTION, null);
        response.put(GeneralConstants.DATA, data);
        return response;
    }

    static ModelMap crearRespuestaModelMapError(Exception ex) {
        ModelMap response = new ModelMap();
        response.put(GeneralConstants.TYPE, GeneralConstants.EXCEPTION);
        response.put(GeneralConstants.EXCEPTION, ex);
        response.put(GeneralConstants.DATA, null);
        return response;
    }
    public static ModelMap crearRespuestaModelMapError(GeneralException genEx) {
        ModelMap response = new ModelMap();
        response.put(GeneralConstants.TYPE, GeneralConstants.EXCEPTION);
        response.put(GeneralConstants.EXCEPTION, new HashMap<String, Object>() {{
            put("codigoDeError", genEx.getCodigoDeError());
            put("mensajeDeError", genEx.getMensajeDeError());
        }});
        response.put(GeneralConstants.DATA, null);
        return response;
    }

}
