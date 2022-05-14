package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.BillRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.UserRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.BillService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.BillRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public void addBillToUser(BillRequest request, User user) {
        Bill bill = new Bill();
        bill.setUnits(request.getUnits());

        if(request.getTariff().equals(ETariff.TWOHUNDRED)){
            bill.setAmount(request.getUnits()*2);
        } else if(request.getTariff().equals(ETariff.FIVEHUNDRED)){
            bill.setAmount(request.getUnits()*5);
        } else {
            bill.setAmount(request.getUnits()*10);
        }

        bill.setStartDate(request.getStartDate());
        bill.setEndDate(request.getEndDate());
        user.addBill(bill);
        bill.setUser(user);
        bill.setStatus(EStatus.PENDING);
        bill.setActive(EActive.ACTIVE);
        Date currentDate = new Date();
        bill.setCreated(currentDate);

        billRepository.save(bill);

    }

    @Override
    public void deleteBillFromUser(Long billId, User user) {
        user.deleteBill(getById(billId));
        delete(billId);
    }

    @Override
    public void save(Bill bill) {
        bill.setStatus(EStatus.PENDING);
        bill.setActive(EActive.ACTIVE);
        Date currentDate = new Date();
        bill.setCreated(currentDate);
    }

    @Override
    public void update(Long id, Bill bill) {

    }

    @Override
    public Bill getById(Long id) {
        return billRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        billRepository.delete(getById(id));
    }

    @Override
    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> getBillsOfUser(User user) {
        return billRepository.getBillsByUser(user);
    }
}
