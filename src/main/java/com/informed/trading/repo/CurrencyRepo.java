package com.informed.trading.repo;

import com.informed.trading.reference.tradedata.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends CrudRepository<Currency, Integer> {}