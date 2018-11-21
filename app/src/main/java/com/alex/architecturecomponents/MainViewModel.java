package com.alex.architecturecomponents;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import java.util.Observable;

public class MainViewModel extends ViewModel {
    //Data Binding Observable
    public final ObservableField<String> mData = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private DataModel dataModel;
    /*extends AndroidViewModel
    private final Context mContext; // To avoid leaks, this must be an Application Context.
    public MainViewModel(@NonNull Application application) {
        super(application);
        mContext = application.getApplicationContext();// Force use of Application Context.
    }
    */
    public MainViewModel(DataModel dataModel){
        super();
        this.dataModel = dataModel;
    }


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
