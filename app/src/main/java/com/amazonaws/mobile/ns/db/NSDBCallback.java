package com.amazonaws.mobile.ns.db;

/**
 * Created by ricardo on 3/18/17.
 */

public interface NSDBCallback {

    void onSuccess(Object result);

    void onFailure(Exception e);
}
