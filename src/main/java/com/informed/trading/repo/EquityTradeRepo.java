package com.informed.trading.repo;

import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.EquityTrade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquityTradeRepo extends CrudRepository<EquityTrade, Integer> {}
