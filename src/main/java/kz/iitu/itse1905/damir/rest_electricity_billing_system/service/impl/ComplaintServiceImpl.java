package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.ComplaintRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public void save(Complaint complaint) {

    }

    @Override
    public void update(Long id, Complaint complaint) {

    }

    @Override
    public Complaint getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getComplaintsOfUser(User user) {
        return complaintRepository.getComplaintsByUser(user);
    }
}
