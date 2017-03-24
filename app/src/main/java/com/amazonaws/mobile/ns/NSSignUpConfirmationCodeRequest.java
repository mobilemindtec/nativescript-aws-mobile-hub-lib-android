package com.amazonaws.mobile.ns;

/**
 * Created by ricardo on 3/14/17.
 */

public interface NSSignUpConfirmationCodeRequest {

    void request(String username, String verificationCode);
}
