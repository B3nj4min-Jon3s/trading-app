package com.informed.trading.repo;

import com.informed.trading.reference.transactionalData.CounterParty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterPartyRepo extends CrudRepository<CounterParty, Integer> {}
