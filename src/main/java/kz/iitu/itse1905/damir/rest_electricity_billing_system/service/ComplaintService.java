package kz.iitu.itse1905.damir.rest_electricity_billing_system.service;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;

import java.util.List;

public interface ComplaintService extends BaseService<Complaint> {

    List<Complaint> getComplaintsOfUser(User user);
}
