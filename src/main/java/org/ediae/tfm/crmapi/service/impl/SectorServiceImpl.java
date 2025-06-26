package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.Sector;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.repository.SectorRepository;
import org.ediae.tfm.crmapi.service.ISectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SectorServiceImpl implements ISectorService {

    @Autowired
    private SectorRepository sectorRepository;

    public List<Sector> findAllSectors() throws GeneralException {
        try {
            return sectorRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    public Sector findSectorById(Long id) throws GeneralException{
        try {
            Optional<Sector> optionalSector= sectorRepository.findById(id);
            if(optionalSector.isPresent()) {
                return optionalSector.get();
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
