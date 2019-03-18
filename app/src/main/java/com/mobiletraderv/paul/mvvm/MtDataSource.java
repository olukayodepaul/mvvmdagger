package com.mobiletraderv.paul.mvvm;

import com.mobiletraderv.paul.data.MtDao;
import com.mobiletraderv.paul.data.MtRepository;

import javax.inject.Inject;

public class MtDataSource implements MtRepository {

    private MtDao mtDao;

    @Inject
    public MtDataSource(MtDao mtDao) {
        this.mtDao = mtDao;
    }
}
