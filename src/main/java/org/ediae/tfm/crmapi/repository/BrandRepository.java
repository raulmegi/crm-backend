package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
