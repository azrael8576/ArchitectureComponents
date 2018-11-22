package com.alex.architecturecomponents;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alex.architecturecomponents.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用Data Binding訂閱ViewModel中的資料以更新畫面
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        GithubViewModelFactory factory = new GithubViewModelFactory(new DataModel());
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
        binding.setViewModel(viewModel);

        viewModel.mData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String data) {
                binding.txtHelloWord.setText(data);
            }
        });
        viewModel.toastText.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String text) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
