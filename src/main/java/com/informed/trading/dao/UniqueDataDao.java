package com.informed.trading.dao;

import com.informed.trading.reference.transactionaldata.UniqueData;
import com.informed.trading.repo.UniqueDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class UniqueDataDao implements Dao{

    @Autowired
    private UniqueDataRepo uniqueDataRepo;

    public List<UniqueData> getAll(){
        Iterable<UniqueData> searchResults = this.uniqueDataRepo.findAll();
        List<UniqueData> uniqueDataList = new ArrayList<>();
        searchResults.forEach(uniqueDataList::add);
        return uniqueDataList;
    }

    @Transactional
    public void add(UniqueData uniqueData) {
        this.uniqueDataRepo.save(uniqueData);
    }

    @Transactional
    public void delete(int id) {
        this.uniqueDataRepo.deleteById(id);
    }
}
