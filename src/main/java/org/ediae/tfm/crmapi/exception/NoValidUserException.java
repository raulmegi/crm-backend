package org.ediae.tfm.crmapi.exception;

import org.ediae.tfm.crmapi.constant.GeneralConstant;

public class NoValidUserException extends GeneralException{
    public NoValidUserException() {
        super(GeneralConstant.NO_VALID_USER_ERROR_CODE, GeneralConstant.NO_VALID_USER_ERROR_MESSAGE);
    }
}
