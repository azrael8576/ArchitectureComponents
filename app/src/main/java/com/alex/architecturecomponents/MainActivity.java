package com.alex.architecturecomponents;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alex.architecturecomponents.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        GithubViewModelFactory factory = new GithubViewModelFactory(new DataModel());
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
        binding.setViewModel(viewModel);

        // TODO: 使用Data Binding訂閱ViewModel中的資料以更新畫面
    }
}
