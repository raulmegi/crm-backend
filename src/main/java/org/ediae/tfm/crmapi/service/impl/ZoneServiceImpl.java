package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.Brand;
import org.ediae.tfm.crmapi.entity.Zone;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.repository.ZoneRepository;
import org.ediae.tfm.crmapi.service.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneServiceImpl implements IZoneService {
    @Autowired
    private ZoneRepository zoneRepository;

    public List<Zone> findAllZones() throws GeneralException {
        try {
            return zoneRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    public Zone findZoneById(Long id) throws GeneralException{
        try {
            Optional<Zone> optionalZone= zoneRepository.findById(id);
            if(optionalZone.isPresent()) {
                return optionalZone.get();
            } else {
                throw new GeneralException(GeneralConstants.TASK_NOT_FOUND_CODE, GeneralConstants.TASK_NOT_FOUND_MESSAGE);
            }
        } catch (GeneralException genEx) {
            throw genEx;
        } catch (Exception ex) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }
}
