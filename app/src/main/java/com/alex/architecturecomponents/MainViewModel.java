package com.alex.architecturecomponents;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import java.util.Observable;

public class MainViewModel extends ViewModel {
    //Data Binding Observable
    public final ObservableField<String> mData = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private DataModel dataModel = new DataModel();

    public void refresh() {
        //Data Binding Observable
        isLoading.set(true);

        dataModel.retrieveData(new DataModel.onDataReadyCallback() {
            @Override
            public void onDataReady(String data) {
                // TODO: exposes data to View
                mData.set(data);
                isLoading.set(false);
            }
        });
    }
}
