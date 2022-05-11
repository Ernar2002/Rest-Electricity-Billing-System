package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.BillRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public void save(Bill bill) {

    }

    @Override
    public void update(Long id, Bill bill) {

    }

    @Override
    public Bill getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Bill> getAll() {
        return null;
    }

    @Override
    public List<Bill> getBillsOfUser(User user) {
        return billRepository.getBillsByUser(user);
    }
}
