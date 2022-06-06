package com.example.javatest.repository;

import com.example.javatest.dto.StatementDto;
import com.example.javatest.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    @Query("Select new com.example.javatest.dto.StatementDto(s.id,a.id, s.datefield, s.amount) from Account a JOIN a.statements s where a.id =?1")
    public List<StatementDto> findByAccountId(Integer id);

    @Query("Select new com.example.javatest.dto.StatementDto(s.id,a.id, s.datefield, s.amount) from Account a JOIN a.statements s where a.id =?1 AND s.amount between ?2 AND ?3")
    public List<StatementDto> findByAccountIdAndAmountBetween(Integer id,Double fromAmount,Double toAmount);

    @Query("Select new com.example.javatest.dto.StatementDto(s.id,a.id, s.datefield, s.amount) from Account a JOIN a.statements s where a.id =?1 AND s.datefield between ?2 AND ?3")
    public List<StatementDto> findByAccountIdAndDateBetween(Integer id, LocalDate fromDate, LocalDate toDate);

}
