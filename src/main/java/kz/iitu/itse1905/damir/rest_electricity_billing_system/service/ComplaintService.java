package kz.iitu.itse1905.damir.rest_electricity_billing_system.service;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.ComplaintRequest;

import java.util.List;

public interface ComplaintService extends BaseService<Complaint> {
    List<Complaint> getComplaintsOfUser(User user);
    void addComplaintToUser(ComplaintRequest request, User user);
    void removeComplaintFromUser(Long complaintId, User user);
}
