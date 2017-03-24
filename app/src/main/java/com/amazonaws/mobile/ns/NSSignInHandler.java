package com.amazonaws.mobile.ns;

import com.amazonaws.mobile.user.IdentityProvider;

/**
 * Created by ricardo on 3/15/17.
 */

public interface NSSignInHandler {

    void onSuccess(IdentityProvider provider);

    void onCancel();

    void onGetAuthenticationDetails();

    void onFailure(Exception e);
}
