package com.udacity.xyzreader.utils;

import android.content.Context;

import com.udacity.xyzreader.data.ArticlesRepository;
import com.udacity.xyzreader.remote.ApiClient;
import com.udacity.xyzreader.remote.ArticleService;

public class Injection {

    public static ViewModelFactory provideViewModelFactory(Context context) {
        ArticlesRepository repository = provideArticlesRepository(context);
        return ViewModelFactory.getInstance(repository);
    }

    public static ArticlesRepository provideArticlesRepository(Context context) {
        ArticleService apiService = ApiClient.getInstance();
        AppExecutors executors = AppExecutors.getInstance();
        return ArticlesRepository.getInstance(
                apiService,
                executors
        );
    }
}
