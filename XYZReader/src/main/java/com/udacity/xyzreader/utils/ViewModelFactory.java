package com.udacity.xyzreader.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.udacity.xyzreader.data.ArticlesRepository;
import com.udacity.xyzreader.ui.ArticlesViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final ArticlesRepository repository;

    private ViewModelFactory(ArticlesRepository repository) {
        this.repository = repository;
    }

    public static ViewModelFactory getInstance(ArticlesRepository repository) {
        return new ViewModelFactory(repository);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ArticlesViewModel.class)) {
            //noinspection unchecked
            return (T) new ArticlesViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
