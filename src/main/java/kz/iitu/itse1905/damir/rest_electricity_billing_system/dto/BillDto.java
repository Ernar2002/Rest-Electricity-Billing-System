package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EStatus;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Transaction;
import lombok.Data;

import javax.naming.ldap.HasControls;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class BillDto {
    private int units;
    private double amount;
    private EStatus status;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;
    private Set<TransactionDto> transactions;

    public static BillDto fromBill(Bill bill){
        BillDto billDto = new BillDto();

        billDto.setUnits(bill.getUnits());
        billDto.setAmount(bill.getAmount());
        billDto.setStatus(bill.getStatus());
        billDto.setStartDate(bill.getStartDate());
        billDto.setEndDate(bill.getEndDate());

        Set<Transaction> transactions = bill.getTransactions();
        Set<TransactionDto> transactionDtos = new HashSet<>();

        for(Transaction transaction: transactions){
            transactionDtos.add(TransactionDto.fromTransaction(transaction));
        }

        billDto.setTransactions(transactionDtos);

        return billDto;
    }

}
