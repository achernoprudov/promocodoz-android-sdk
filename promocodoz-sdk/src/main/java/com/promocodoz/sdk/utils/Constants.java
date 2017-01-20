package com.promocodoz.sdk.utils;

/**
 * @author achernoprudov
 * @since 18/01/2017
 */
public interface Constants {

    String RESERVE_API_METHOD = "http://promocodoz.com/api/code";
    String POST_METHOD = "POST";

    interface Header {

        String CONTENT_TYPE_VALUE = "application/json; charset=UTF-8";
        String CONTENT_TYPE_KEY = "Content-Type";
    }

    interface Json {

        String SID_KEY = "sid";
        String SECRET_KEY = "secret";
        String CODE_KEY = "code";
        String PLATFORM_KEY = "platform";
    }
}
