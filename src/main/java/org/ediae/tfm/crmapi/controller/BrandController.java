package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.entity.Brand;
import org.ediae.tfm.crmapi.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @PostMapping("/crearMarca")
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }

    @GetMapping("/ListarMarcas")
    public List<Brand> findAllBrands() {
        return brandService.findAllBrands();
    }

    @PutMapping("/actualizarMarca")
    public Brand updateBrand(@RequestBody Brand brand) {
        return brandService.updateBrand(brand);
    }

    @DeleteMapping("/eliminarMarca/{id}")
    public int deleteBrandById(@PathVariable Long id) {
        return brandService.deleteBrandById(id);
    }
}
