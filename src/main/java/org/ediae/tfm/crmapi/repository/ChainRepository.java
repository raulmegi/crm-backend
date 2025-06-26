package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.Chain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends JpaRepository<Chain, Long> {

}
