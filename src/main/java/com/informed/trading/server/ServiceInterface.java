package com.informed.trading.server;

import com.informed.trading.reference.transactionaldata.UniqueData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceInterface {

    Optional<UniqueData> getUniqueDataById(int id);

    void add(UniqueData data);

    void addAll(List<? extends UniqueData> data);

    void delete(UniqueData data);

    void deleteById(int id);

    List<? extends UniqueData> getAll();

}
