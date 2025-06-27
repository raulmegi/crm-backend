package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Sector;
import org.ediae.tfm.crmapi.exception.GeneralException;
import java.util.List;

public interface ISectorService {

    List<Sector> findAllSectors() throws GeneralException;;
    Sector findSectorById(Long id) throws GeneralException;

}
