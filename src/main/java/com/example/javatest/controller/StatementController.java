package com.example.javatest.controller;

import com.example.javatest.dto.StatementDto;
import com.example.javatest.exception.BadRequestException;
import com.example.javatest.repository.AccountRepository;
import com.example.javatest.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statement")
public class StatementController {

    @Autowired
    StatementRepository statementRepository;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_Admin') || (hasRole('ROLE_User') && #fromDate==null && #toDate==null && #fromAmount==null && #toAmount==null)")
    public List<StatementDto> getStatement(@RequestParam(value = "accountId", required = true) Integer accountId, @RequestParam(value = "fromDate", required = false) LocalDate fromDate, @RequestParam(value = "toDate", required = false) LocalDate toDate,
                                           @RequestParam(value = "fromAmount", required = false) Double fromAmount, @RequestParam(value = "toAmount", required = false) Double toAmount) throws Exception {
        if (accountId != null) {

            if (accountId < 1) {
              throw  new BadRequestException("Invalid Account Id");
            }

            else if (fromDate != null && toDate != null) {
                return accountRepository.findByAccountIdAndDateBetween(accountId, fromDate, toDate);
            }

            if (fromAmount != null && toAmount != null) {
                return accountRepository.findByAccountIdAndAmountBetween(accountId, fromAmount, toAmount);
            }
            if(fromAmount==null && toAmount ==null && fromDate==null && toDate==null){
                return accountRepository.findByAccountIdAndDateBetween(accountId, LocalDate.now(), LocalDate.now().minusMonths(3));
            }
            else{
                throw new BadRequestException("Invalid Request Parameters");
            }

        }
        else{
            throw new BadRequestException("Invalid Request Parameters");
        }

}

}
