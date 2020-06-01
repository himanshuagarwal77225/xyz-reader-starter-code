package com.udacity.xyzreader.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.udacity.xyzreader.R;
import com.udacity.xyzreader.utils.Injection;
import com.udacity.xyzreader.utils.ViewModelFactory;

public class HomeActivity extends AppCompatActivity {

    public static ArticlesViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = Injection.provideViewModelFactory(activity);
        return ViewModelProviders.of(activity, factory).get(ArticlesViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
