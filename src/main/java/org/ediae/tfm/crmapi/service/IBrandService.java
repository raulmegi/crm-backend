package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Brand;
import org.ediae.tfm.crmapi.exception.GeneralException;
import java.util.List;

public interface IBrandService {

    Brand createBrand(Brand brand) throws GeneralException;;
    List<Brand> findAllBrands() throws GeneralException;;
    Brand findByName(String name) throws GeneralException;;
    Brand findBrandById(Long id) throws GeneralException;
    Brand updateBrand(Brand brand) throws GeneralException;;
    boolean deleteBrandById(Long id) throws GeneralException;;

}
