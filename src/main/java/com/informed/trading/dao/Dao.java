package com.informed.trading.dao;

import com.informed.trading.reference.transactionaldata.UniqueData;

import java.util.List;

public interface Dao {

    void add(UniqueData data);
    List<? extends UniqueData> getAll();
    void delete(int id);

}
