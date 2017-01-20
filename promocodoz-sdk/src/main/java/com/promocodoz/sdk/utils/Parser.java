package com.promocodoz.sdk.utils;

import org.json.JSONException;
import org.json.JSONObject;

import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author achernoprudov
 * @since 18/01/2017
 */

public class Parser {

    /**
     * @param inputStream поток с сервера
     * @return raw json
     */
    @NonNull
    public static String readJsonFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        return buffer.toString();
    }

    public static String readErrorMessage(String errorJson) throws JSONException {
        JSONObject errorObject = new JSONObject(errorJson);
        return errorObject.getString(Constants.Json.MESSAGE);
    }
}
