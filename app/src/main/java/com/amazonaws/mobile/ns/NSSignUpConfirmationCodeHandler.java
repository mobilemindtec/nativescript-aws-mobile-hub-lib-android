package com.amazonaws.mobile.ns;

/**
 * Created by ricardo on 3/14/17.
 */

public interface NSSignUpConfirmationCodeHandler {

    void onActivity();

    void onSuccess();

    void onFailure(Exception exception);

}
