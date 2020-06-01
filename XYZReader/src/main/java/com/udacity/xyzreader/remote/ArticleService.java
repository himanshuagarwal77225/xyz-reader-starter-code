package com.udacity.xyzreader.remote;

import com.udacity.xyzreader.data.model.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticleService {

    @GET("data.json")
    Call<List<Article>> getAllArticles();
}
