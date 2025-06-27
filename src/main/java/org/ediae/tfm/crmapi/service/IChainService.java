package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Chain;
import org.ediae.tfm.crmapi.exception.GeneralException;
import java.util.List;

public interface IChainService {

    List<Chain> findAllChains() throws GeneralException;;
    Chain findChainById(Long id) throws GeneralException;
}
