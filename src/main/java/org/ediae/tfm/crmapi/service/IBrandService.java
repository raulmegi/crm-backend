package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Brand;
import java.util.List;

public interface IBrandService {

    Brand createBrand(Brand brand);
    List<Brand> findAllBrands();
    Brand updateBrand(Brand brand);
    int deleteBrandById(Long id);

}
