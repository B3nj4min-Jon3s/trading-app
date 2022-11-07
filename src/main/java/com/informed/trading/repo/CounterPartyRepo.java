package com.informed.trading.repo;

import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.CounterParty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterPartyRepo extends CrudRepository<CounterParty, Integer> {}
