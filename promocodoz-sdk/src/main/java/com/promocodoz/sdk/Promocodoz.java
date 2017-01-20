package com.promocodoz.sdk;

import com.promocodoz.sdk.task.AsyncTaskResult;
import com.promocodoz.sdk.task.ReservePromocodeTask;
import com.promocodoz.sdk.utils.Config;

/**
 * @author achernoprudov
 * @since 18/01/2017.
 */
public final class Promocodoz {

    private static final Promocodoz instance = new Promocodoz();

    public static Promocodoz getInstance() {
        return instance;
    }

    private Config mConfig;

    private Promocodoz() {
        Config.Builder builder = new Config.Builder();
        mConfig = builder.build();
    }

    public void setConfig(Config config) {
        mConfig = config;
    }

    public Config getConfig() {
        return mConfig;
    }


    public String reservePromocode(String promocode) throws Throwable {
        ReservePromocodeTask task = new ReservePromocodeTask(mConfig, promocode);
        task.execute();
        AsyncTaskResult<String> result = task.get(mConfig.getTimeout(), mConfig.getTimeUnit());
        if (result.getError() != null) {
            throw result.getError();
        }
        return result.getResult();
    }
}
