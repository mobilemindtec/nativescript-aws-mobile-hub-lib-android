package com.amazonaws.mobile.ns;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;

/**
 * Created by ricardo on 3/15/17.
 */

public interface NSSignUpHandler {

    void onSuccess(CognitoUser user, CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails);

    void onFailure(final Exception exception);
}
