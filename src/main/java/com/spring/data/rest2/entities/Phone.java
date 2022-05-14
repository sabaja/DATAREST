package com.spring.data.rest2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Phone")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Phone {
    @Id
    private Long id;

    private Long age;

    private String name;

    private String snippet;
}
