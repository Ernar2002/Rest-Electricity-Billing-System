package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EActive;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EStatus;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Transaction;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.BillRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.TransactionRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final BillRepository billRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(
            BillRepository billRepository,
            TransactionRepository transactionRepository
    ){
        this.billRepository = billRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void save(Transaction transaction) {
        Date date = new Date();
        transaction.setActive(EActive.ACTIVE);
        transaction.setCreated(date);

        transactionRepository.save(transaction);
    }

    @Override
    public void update(Long id, Transaction transaction) {

    }

    @Override
    public Transaction getById(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        transactionRepository.delete(getById(id));
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public void addToBill(double payable, Bill bill) {
        Transaction transaction = new Transaction();
        transaction.setPayable(payable);
        transaction.setStatus(EStatus.PROCESSED);
        transaction.setPDate(new Date());
        transaction.setBill(bill);

        bill.setStatus(EStatus.PROCESSED);
        bill.addTransactions(transaction);
        billRepository.save(bill);
        transactionRepository.save(transaction);
    }
}
