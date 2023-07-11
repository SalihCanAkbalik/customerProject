package com.MySpringBoot.canakbalik.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Customer")
@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;
    private String email;
    private int budget;

    public static boolean isPresent() {
        return true;
    }

}
