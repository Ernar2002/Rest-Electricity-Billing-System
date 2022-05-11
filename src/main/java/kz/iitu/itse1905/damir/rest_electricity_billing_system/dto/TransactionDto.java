package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EStatus;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Transaction;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class TransactionDto {
    private double payable;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date pDate;
    private EStatus status;

    public static TransactionDto fromTransaction(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setPayable(transaction.getPayable());
        transactionDto.setPDate(transaction.getPDate());
        transactionDto.setStatus(transaction.getStatus());

        return transactionDto;
    }
}
