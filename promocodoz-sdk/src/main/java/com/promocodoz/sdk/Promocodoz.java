package com.promocodoz.sdk;

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
}
