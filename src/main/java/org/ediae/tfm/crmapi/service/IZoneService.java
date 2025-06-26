package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Zone;
import org.ediae.tfm.crmapi.exception.GeneralException;
import java.util.List;

public interface IZoneService {

    List<Zone> findAllZones() throws GeneralException;;
    Zone findZoneById(Long id) throws GeneralException;

}
