package com.amazonaws.mobile.ns;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by ricardo on 3/14/17.
 */

public interface NSFacebookLoginRequest {

    void request(Activity activity);

    void handleActivityResult(final int requestCode, final int resultCode, final Intent data);
}
