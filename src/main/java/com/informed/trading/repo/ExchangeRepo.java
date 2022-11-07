package com.informed.trading.repo;

import com.informed.trading.reference.tradedata.Exchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepo extends CrudRepository<Exchange, Integer> {}
