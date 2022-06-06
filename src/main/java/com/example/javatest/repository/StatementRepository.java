package com.example.javatest.repository;

import com.example.javatest.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StatementRepository extends JpaRepository<Statement,Integer> {


}
