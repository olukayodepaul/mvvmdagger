package com.mobiletraderv.paul.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.mobiletraderv.paul.data.DataRepository;
import com.mobiletraderv.paul.data.RegistrationEntityTable;

import java.util.List;

public class ListItemCollectionViewModel extends ViewModel {

    private DataRepository repository;


    ListItemCollectionViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<RegistrationEntityTable>> getListItems(int id) {
        return repository.findAllItem(id);
    }
}
