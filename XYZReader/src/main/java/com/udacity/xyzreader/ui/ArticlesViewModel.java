package com.udacity.xyzreader.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.udacity.xyzreader.data.ArticlesRepository;
import com.udacity.xyzreader.data.model.Article;

import java.util.List;

public class ArticlesViewModel extends ViewModel {

    private LiveData<List<Article>> articlesListLiveData;
    private int currentPosition;

    public ArticlesViewModel(ArticlesRepository articlesRepository) {
        articlesListLiveData = articlesRepository.getAllArticles();
    }

    public LiveData<List<Article>> getArticlesListLiveData() {
        return articlesListLiveData;
    }

    public int getCurrentSelectedPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int position) {
        currentPosition = position;
    }
}
