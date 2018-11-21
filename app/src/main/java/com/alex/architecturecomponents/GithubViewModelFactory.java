package com.alex.architecturecomponents;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class GithubViewModelFactory implements ViewModelProvider.Factory {
    private DataModel dateModel;
    public GithubViewModelFactory(DataModel dateModel){
        this.dateModel = dateModel;
    }
    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            return (T) new MainViewModel(dateModel);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
