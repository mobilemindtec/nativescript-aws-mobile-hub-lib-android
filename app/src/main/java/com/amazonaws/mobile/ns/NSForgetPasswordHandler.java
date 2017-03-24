package com.amazonaws.mobile.ns;

/**
 * Created by ricardo on 3/15/17.
 */

public interface NSForgetPasswordHandler {

    void onSuccess();

    void onActivity();

    void onFailure(Exception e);
}
