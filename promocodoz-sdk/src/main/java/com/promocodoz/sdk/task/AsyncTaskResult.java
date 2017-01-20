package com.promocodoz.sdk.task;

/**
 * @author achernoprudov
 * @since 18/01/2017
 */
public class AsyncTaskResult<T> {

    private T result;
    private Throwable error;

    public T getResult() {
        return result;
    }

    public Throwable getError() {
        return error;
    }

    public AsyncTaskResult(T result) {
        super();
        this.result = result;
    }

    public AsyncTaskResult(Throwable error) {
        super();
        this.error = error;
    }
}
