package com.promocodoz.sdk.task;

import com.promocodoz.sdk.utils.Config;
import com.promocodoz.sdk.utils.Parser;

import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author achernoprudov
 * @since 18/01/2017
 */
public class ReservePromocodeTask extends AsyncTask<Void, Void, AsyncTaskResult<String>> {

    private static final String TAG = "ReservePromocodeTask";
    private static final String RESERVE_API_METHOD = "http://promocodoz.com/api/code";

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
            URL url = new URL(RESERVE_API_METHOD);

            JSONObject bodyJson = new JSONObject();
            bodyJson.put("sid", mConfig.getAccountSid());
            bodyJson.put("secret", mConfig.getSecretToken());
            bodyJson.put("code", mPromocode);
            bodyJson.put("platform", mConfig.getPlatform());

            // создаем GET соединение
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();

            OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
            writer.write(bodyJson.toString());

            // преобразовывем поток в строку с помощью StringBuilder и BufferedReader
            InputStream inputStream = urlConnection.getInputStream();
            String resultString = Parser.readJsonFromInputStream(inputStream);
            Log.d(TAG, "Fetched json" + resultString);
            return new AsyncTaskResult<>(resultString);
        } catch (final Exception throwable) {
            Log.e(TAG, "Error while fetching data", throwable);
            return new AsyncTaskResult<>(throwable);
        }
    }
}
