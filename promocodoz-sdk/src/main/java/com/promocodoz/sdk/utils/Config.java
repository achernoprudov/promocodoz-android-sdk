package com.promocodoz.sdk.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author achernoprudov
 * @since 18/01/2017
 */
public class Config {

    public static class Builder {

        private String mAccountSid = "default";
        private String mSecretToken = "default";
        private long mTimeout = 30;
        private TimeUnit mTimeUnit = TimeUnit.SECONDS;

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

        public long getTimeout() {
            return mTimeout;
        }

        public void setTimeout(long timeout) {
            mTimeout = timeout;
        }

        public TimeUnit getTimeUnit() {
            return mTimeUnit;
        }

        public void setTimeUnit(TimeUnit timeUnit) {
            mTimeUnit = timeUnit;
        }

        public Config build() {
            return new Config(mAccountSid, mSecretToken, mTimeout, mTimeUnit);
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
    private final long mTimeout;
    private final TimeUnit mTimeUnit;

    private Config(String accountSid, String secretToken, long timeout, TimeUnit unit) {
        mAccountSid = accountSid;
        mSecretToken = secretToken;
        mTimeout = timeout;
        mTimeUnit = unit;
    }

    public String getAccountSid() {
        return mAccountSid;
    }

    public String getSecretToken() {
        return mSecretToken;
    }

    public String getPlatform() {
        return mPlatform;
    }

    public long getTimeout() {
        return mTimeout;
    }

    public TimeUnit getTimeUnit() {
        return mTimeUnit;
    }
}

