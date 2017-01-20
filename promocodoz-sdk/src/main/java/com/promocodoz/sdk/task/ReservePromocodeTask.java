package com.promocodoz.sdk.task;

import com.promocodoz.sdk.utils.Constants;
import com.promocodoz.sdk.utils.Config;
import com.promocodoz.sdk.utils.Parser;

import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author achernoprudov
 * @since 18/01/2017
 */
public class ReservePromocodeTask extends AsyncTask<Void, Void, AsyncTaskResult<String>> {

    private static final String TAG = "ReservePromocodeTask";

    private final String mPromocode;
    private final Config mConfig;

    public ReservePromocodeTask(Config config, String promocode) {
        mConfig = config;
        mPromocode = promocode;
    }

    @Override
    protected AsyncTaskResult<String> doInBackground(Void... params) {
        try {

            // формируем адрес до REST API метода
            URL url = new URL(Constants.RESERVE_API_METHOD);

            JSONObject bodyJson = new JSONObject();
            bodyJson.put(Constants.Json.SID_KEY, mConfig.getAccountSid());
            bodyJson.put(Constants.Json.SECRET_KEY, mConfig.getSecretToken());
            bodyJson.put(Constants.Json.CODE_KEY, mPromocode);
            bodyJson.put(Constants.Json.PLATFORM_KEY, mConfig.getPlatform());

            // создаем GET соединение
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty(Constants.Header.CONTENT_TYPE_KEY, Constants.Header.CONTENT_TYPE_VALUE);
            urlConnection.setRequestMethod(Constants.POST_METHOD);
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            OutputStream outputStream = urlConnection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(bodyJson.toString());
            writer.flush();
            writer.close();
            outputStream.close();

//            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // преобразовывем поток в строку с помощью StringBuilder и BufferedReader
                InputStream inputStream = urlConnection.getInputStream();
                String resultString = Parser.readJsonFromInputStream(inputStream);
                Log.d(TAG, "Fetched json" + resultString);
                return new AsyncTaskResult<>(resultString);
            } else {
                Log.d(TAG, "Status is not OK: " + urlConnection.getResponseCode());
                return new AsyncTaskResult<>("");
            }
        } catch (final Exception throwable) {
            Log.e(TAG, "Error while fetching data", throwable);
            return new AsyncTaskResult<>(throwable);
        }
    }
}
