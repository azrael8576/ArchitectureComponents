package com.alex.architecturecomponents;


import android.os.Handler;

public class DataModel {

    public void retrieveData(final onDataReadyCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDataReady("New Data");
            }
        }, 3000);
    }

    interface onDataReadyCallback {
        void onDataReady(String data);
    }
}
