package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {

}
