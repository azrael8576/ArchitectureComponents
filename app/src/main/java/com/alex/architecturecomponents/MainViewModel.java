package com.alex.architecturecomponents;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import java.util.Observable;

public class MainViewModel extends ViewModel {
    /*
    LiveData跟Data Binding角色有一點重疊，
    一般而言我會讓Data Binding處理元件的visible這類屬性，
    而主要顯示在UI的資料用LiveData以免除各種lifecycle衍生的問題。
    */

    //Data Binding Observable
    //public final ObservableField<String> mData = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);
    //LiveData
    public final MutableLiveData<String> mData = new MutableLiveData<>();
    //SingleLiveEvent 避免了configuration change後又顯示一次同樣內容的問題
    public final SingleLiveEvent<String> toastText = new SingleLiveEvent<>();

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
                mData.setValue(data);
                toastText.setValue("下載完成");
                isLoading.set(false);
            }
        });
    }
}
