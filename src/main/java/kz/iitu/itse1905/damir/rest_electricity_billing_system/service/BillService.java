package kz.iitu.itse1905.damir.rest_electricity_billing_system.service;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.BillRequest;

import java.util.List;

public interface BillService extends BaseService<Bill>{
    List<Bill> getBillsOfUser(User user);
    void saveBill(BillRequest request, User user);
}
