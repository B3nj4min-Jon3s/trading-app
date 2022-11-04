package com.informed.trading.server;

import com.informed.trading.exception.DataAlreadyExistsException;
import com.informed.trading.exception.ItemNotFoundException;
import com.informed.trading.reference.transactionaldata.UniqueData;

import javax.persistence.Id;
import java.util.*;

public class Service implements ServiceInterface {

    private HashMap<Integer, UniqueData> dataStorage;

    public Service() {
    }

    @Override
    public Optional<UniqueData> getUniqueDataById(int id) {
        if(dataStorage.containsKey(id)) {
            return Optional.of(dataStorage.get(id));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void add(UniqueData data) {
        if(dataStorage.containsKey(data.getId())) {
            throw new DataAlreadyExistsException(data + ": already exists");
        } else {
            dataStorage.put(data.getId(), data);
        }
    }

    @Override
    public void addAll(List<? extends UniqueData> dataList) {
        if (dataStorage.size() > 0) {
            for (UniqueData data: dataList) {
                this.dataStorage.put(data.getId(), data);
            }
        }
    }

    @Override
    public void delete(UniqueData data) {
        int dataId = data.getId();
        if(this.dataStorage.containsKey(dataId)) {
            deleteById(dataId);
        } else {
            throw new ItemNotFoundException(data + ": not found in storage");
        }
    }

    @Override
    public void deleteById(int id) {
        if(dataStorage.containsKey(id)) {
            this.dataStorage.remove(id);
        } else {
            throw new ItemNotFoundException(id + ": not found in storage");
        }
    }

    @Override
    public List<? extends UniqueData> getAll() {
        if (this.dataStorage.size() > 0) {
            return this.dataStorage.values().stream().toList();
        } else {
            throw new ItemNotFoundException("Address storage is empty");
        }
    }
}
