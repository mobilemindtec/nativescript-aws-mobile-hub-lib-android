package com.amazonaws.mobile.ns;

/**
 * Created by ricardo on 3/14/17.
 */

public interface NSForgetPasswordRequest {

    void request(String username, String newPassword, String verificationCode);

    void request(String username);
}
