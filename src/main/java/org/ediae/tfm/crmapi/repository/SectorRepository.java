package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

}
