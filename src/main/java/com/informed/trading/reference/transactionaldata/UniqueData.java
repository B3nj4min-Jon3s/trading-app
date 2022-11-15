package com.informed.trading.reference.transactionaldata;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class UniqueData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public UniqueData() {}

    public UniqueData(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
