package com.informed.trading.repo;

import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.transactionaldata.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquityRepo extends CrudRepository<Equity, Integer> {}
