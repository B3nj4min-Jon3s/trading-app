package com.informed.trading.repo;

import com.informed.trading.reference.transactionalData.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {}
