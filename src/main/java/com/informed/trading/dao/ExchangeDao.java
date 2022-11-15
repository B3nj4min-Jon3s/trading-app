package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.repo.ExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExchangeDao implements ExchangeDaoInterface {

    @Autowired
    private ExchangeRepo exchangeRepo;
    @Transactional
    public void addExchange(Exchange exchange) {
        this.exchangeRepo.save(exchange);
    }

    public List<Exchange> getAllExchanges() {
        Iterable<Exchange> searchResults = this.exchangeRepo.findAll();
        List<Exchange> exchanges = new ArrayList<>();
        searchResults.forEach(exchanges::add);
        return exchanges;
    }
    @Transactional
    public void deleteExchanges(Exchange exchange) {
        this.exchangeRepo.delete(exchange);
    }
    @Transactional
    public boolean deleteExchangeById(int id) {
        if(this.exchangeRepo.existsById(id)){
            this.exchangeRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
