package com.informed.trading.service;

import com.informed.trading.reference.transactionaldata.UniqueData;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {

    Optional<UniqueData> getUniqueDataById(int id);

    void add(UniqueData data);

    void addAll(List<? extends UniqueData> data);

    void delete(UniqueData data);

    void deleteById(int id);

    List<? extends UniqueData> getAll();

}
