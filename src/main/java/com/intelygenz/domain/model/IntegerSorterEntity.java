package com.intelygenz.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "NUMBERS")
public class IntegerSorterEntity {
    @Id
    @Column(name= "id")
    private int id;

    @Column(name = "integers")
    private String integers;
}
