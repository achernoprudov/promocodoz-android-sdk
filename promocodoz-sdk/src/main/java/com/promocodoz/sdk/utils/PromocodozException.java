package com.promocodoz.sdk.utils;

/**
 * @author achernoprudov
 * @since 20/01/2017
 */
public class PromocodozException extends Throwable {

    private String mErrorMessage;

    public PromocodozException(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return mErrorMessage;
    }
}
