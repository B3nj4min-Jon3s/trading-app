package com.informed.trading.controller;

import com.informed.trading.exception.ItemNotFoundException;
import com.informed.trading.reference.transactionalData.CounterParty;
import com.informed.trading.service.CounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("trader")
public class CounterPartyController {

        private CounterPartyService counterPartyService;

        @Autowired
        public void setCounterPartyService(CounterPartyService counterPartyService) {
        this.counterPartyService = counterPartyService;
    }

        @GetMapping("/counter_party/list")
        @ResponseStatus(HttpStatus.OK)
        public List<CounterParty> getCounterParty() {
        System.out.println("CounterPartyController.getCounterParty()");
        return counterPartyService.getAllCounterParties();
    }


        @GetMapping("/counter_party/{id}")
        @ResponseStatus(HttpStatus.OK)
        public CounterParty getCounterParty(@PathVariable int id) {
        System.out.println("CounterPartyController.getCounterParty()");
        Optional<CounterParty> counterParty = counterPartyService.getCounterPartyById(id);
        if (counterParty.isPresent()) {
            return counterParty.get();
        }
        else {
            throw new ItemNotFoundException("counter party not found with id: " + id);
        }
    }

        @PostMapping("/counter_party")
        @ResponseStatus(HttpStatus.CREATED)
        public void addCounterParty(@RequestBody CounterParty counterParty) {
        System.out.println("CounterPartyController.addCounterParty(" + counterParty + ")");
        counterPartyService.addCounterParties(counterParty);
    }

        @PutMapping("/counter_party")
        @ResponseStatus(HttpStatus.CREATED)
        public void updateCounterParty(@RequestBody CounterParty counterParty) {
        System.out.println("CounterPartyController.updateCounterParty(" + counterParty + ")");
        counterPartyService.addCounterParties(counterParty);
    }

        @DeleteMapping("/counter_party/{id}")
        @ResponseStatus(HttpStatus.OK)
        public void deleteCounterPartyByID(@PathVariable int id) {
        if(!counterPartyService.deleteCounterPartyById(id)){
            throw new ItemNotFoundException("counter party not found with id: " + id);
        }
    }

        @ExceptionHandler(ItemNotFoundException.class)
        @ResponseStatus(
                value = HttpStatus.NOT_FOUND,
                reason = "Invalid Request")
        public void itemNotFoundFailure() {
        System.out.println("Handling error");
    }

}
