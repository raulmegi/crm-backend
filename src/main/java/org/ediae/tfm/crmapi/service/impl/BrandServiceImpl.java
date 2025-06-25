package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.Brand;
import org.ediae.tfm.crmapi.entity.Task;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ediae.tfm.crmapi.repository.BrandRepository;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand createBrand(Brand brand) throws GeneralException {
        try {
            return brandRepository.save(brand);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.TASK_CREATION_ERROR_CODE,
                    GeneralConstants.TASK_CREATION_ERROR_MESSAGE);
        }
    }
    public List<Brand> findAllBrands() throws GeneralException {
        try {
            return brandRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    public Brand findByName(String name) throws GeneralException {
        try {
            Optional<Brand> optionalBrand= brandRepository.findByName(name);
            if(optionalBrand.isPresent()) {
                return optionalBrand.get();
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

    public Brand findBrandById(Long id) throws GeneralException{
        try {
            Optional<Brand> optionalBrand= brandRepository.findById(id);
            if(optionalBrand.isPresent()) {
                return optionalBrand.get();
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

    public Brand updateBrand(Brand brand) throws GeneralException {
        if (brand.getId() == null || !brandRepository.existsById(brand.getId())) {
            throw new GeneralException(
                    GeneralConstants.TASK_NOT_FOUND_CODE,
                    GeneralConstants.TASK_NOT_FOUND_MESSAGE
            );
        } try {
            return brandRepository.save(brand);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.TASK_UPDATE_ERROR_CODE,
                    GeneralConstants.TASK_UPDATE_ERROR_MESSAGE
            );
        }
    }

    public boolean deleteBrandById(Long id) throws GeneralException {
        if (id == null || !brandRepository.existsById(id)) {
            throw new GeneralException(
                    GeneralConstants.TASK_NOT_FOUND_CODE,
                    GeneralConstants.TASK_NOT_FOUND_MESSAGE
            );
        }

        try {
            brandRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.TASK_DELETE_ERROR_CODE,
                    GeneralConstants.TASK_DELETE_ERROR_MESSAGE
            );
        }
    }
}
