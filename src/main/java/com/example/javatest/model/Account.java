package com.example.javatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String accountType;
    String accountNumber;

    @OneToMany(targetEntity = Statement.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    List<Statement> statements;

}
