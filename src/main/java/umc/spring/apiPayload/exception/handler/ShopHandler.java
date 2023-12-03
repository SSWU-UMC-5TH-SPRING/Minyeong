package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class ShopHandler extends GeneralException {

    public ShopHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
