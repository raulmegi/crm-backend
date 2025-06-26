package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.Chain;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.repository.ChainRepository;
import org.ediae.tfm.crmapi.service.IChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChainServiceImpl implements IChainService {

    @Autowired
    private ChainRepository chainRepository;

    public List<Chain> findAllChains() throws GeneralException {
        try {
            return chainRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    public Chain findChainById(Long id) throws GeneralException{
        try {
            Optional<Chain> optionalChain= chainRepository.findById(id);
            if(optionalChain.isPresent()) {
                return optionalChain.get();
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
