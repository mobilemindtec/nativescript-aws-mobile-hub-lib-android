package com.amazonaws.mobile.ns;

/**
 * Created by ricardo on 3/14/17.
 */

public interface NSSignUpRequest {

    void request(String username, String password, String givenName, String email, String phone);


}
