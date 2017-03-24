package com.amazonaws.mobile.ns.db;

import android.os.AsyncTask;


/**
 * Created by ricardo on 3/18/17.
 */

public class NSDynamonDBTaskRunner extends AsyncTask {

    private static final String LOG_TAG = NSDynamonDBTaskRunner.class.getSimpleName();
    private NSDBCallback callback;

    public static interface  NSDynamonDBTask {
        Object execute();
    }

    private NSDynamonDBTask task;

    public NSDynamonDBTaskRunner(NSDBCallback callback, NSDynamonDBTask task){
        this.task = task;
        this.callback = callback;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            return task.execute();
        }catch (Exception e){
            return  e;
        }
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);

        if(result instanceof Exception){
            callback.onFailure((Exception)result);
        }else{
            callback.onSuccess(result);
        }
    }
}
