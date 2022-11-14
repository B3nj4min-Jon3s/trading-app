package com.informed.trading.repo;

import com.informed.trading.reference.transactionalData.UniqueData;
import org.springframework.data.repository.CrudRepository;

public interface UniqueDataRepo extends CrudRepository<UniqueData, Integer> {}
