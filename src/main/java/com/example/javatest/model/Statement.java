package com.example.javatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    LocalDate datefield;
    Double amount;
}
