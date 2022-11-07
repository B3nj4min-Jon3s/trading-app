package com.informed.trading.repo;

import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.UniqueData;
import org.springframework.data.repository.CrudRepository;

public interface UniqueDataRepo extends CrudRepository<UniqueData, Integer> {}
