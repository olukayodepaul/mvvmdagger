package com.mobiletraderv.paul.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.mobiletraderv.paul.data.DataRepository;
import com.mobiletraderv.paul.di.scope.ApplicationScope;

import javax.inject.Inject;

import io.reactivex.annotations.Nullable;


@ApplicationScope
public class CustomViewModelFactory implements ViewModelProvider.Factory {

    private final DataRepository repository;

    @Inject
    public CustomViewModelFactory(DataRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ListItemCollectionViewModel(repository);
    }
}