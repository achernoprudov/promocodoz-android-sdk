package com.promocodoz.sdk;

/**
 * @author achernoprudov
 * @since 18/01/2017
 */
public class Config {

    public static class Builder {

        private String mAccountSid = null;
        private String mSecretToken = null;

        public Builder() {
        }

        public Builder setAccountSid(String accountSid) {
            mAccountSid = accountSid;
            return this;
        }

        public Builder setSecretToken(String secretToken) {
            mSecretToken = secretToken;
            return this;
        }

        public Config build() {
            return new Config(mAccountSid, mSecretToken);
        }

        public String getAccountSid() {
            return mAccountSid;
        }

        public String getSecretToken() {
            return mSecretToken;
        }
    }

    private static final String DEFAULT_PLATFORM = "Android";

    private final String mAccountSid;
    private final String mSecretToken;
    private final String mPlatform = DEFAULT_PLATFORM;

    private Config(String accountSid, String secretToken) {
        mAccountSid = accountSid;
        mSecretToken = secretToken;
    }

    public String getAccountSid() {
        return mAccountSid;
    }

    public String getSecretToken() {
        return mSecretToken;
    }
}
