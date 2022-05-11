package kz.iitu.itse1905.damir.rest_electricity_billing_system.service;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;

import java.util.List;

public interface BillService extends BaseService<Bill>{
    List<Bill> getBillsOfUser(User user);
}
