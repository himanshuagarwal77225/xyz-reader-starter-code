package com.udacity.xyzreader.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.udacity.xyzreader.data.model.Article;
import com.udacity.xyzreader.remote.ArticleService;
import com.udacity.xyzreader.utils.AppExecutors;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ArticlesRepository {

    private static volatile ArticlesRepository sInstance;

    private final AppExecutors mExecutors;

    private final ArticleService mArticleService;

    private ArticlesRepository(ArticleService articleService,
                               AppExecutors executors) {
        mArticleService = articleService;
        mExecutors = executors;
    }

    public static ArticlesRepository getInstance(ArticleService articleService,
                                                 AppExecutors executors) {
        if (sInstance == null) {
            synchronized (ArticlesRepository.class) {
                if (sInstance == null) {
                    sInstance = new ArticlesRepository(articleService, executors);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<Article>> getAllArticles() {
        final MutableLiveData<List<Article>> articleListLiveData = new MutableLiveData<>();
        mArticleService.getAllArticles().enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.isSuccessful()) {
                    List<Article> data = response.body();
                    List<Article> articleList = data != null ? data : Collections.<Article>emptyList();
                    Timber.d("Parsing finished. number of articles: %s", articleList.size());
                    articleListLiveData.postValue(articleList);
                } else {
                    Timber.d("error code: %s", response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Timber.d("unknown error: %s", t.getMessage());
            }
        });
        return articleListLiveData;
    }
}
