package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EActive;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.ComplaintRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.UserRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.ComplaintService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.ComplaintRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    @Autowired
    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            UserRepository userRepository
    ) {
        this.complaintRepository = complaintRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(Complaint complaint) {
        complaint.setCreated(new Date());
        complaint.setActive(EActive.ACTIVE);
        complaintRepository.save(complaint);
    }

    @Override
    public void update(Long id, Complaint complaint) {

    }

    @Override
    public Complaint getById(Long id) {
        return complaintRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        complaintRepository.delete(getById(id));
    }

    @Override
    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getComplaintsOfUser(User user) {
        return complaintRepository.getComplaintsByUser(user);
    }

    @Override
    public void addComplaintToUser(ComplaintRequest request, User user) {

        Complaint complaint = new Complaint();
        complaint.setText(request.getText());
        complaint.setCreated(new Date());
        complaint.setActive(EActive.ACTIVE);
        user.addComplaint(complaint);
        complaint.setUser(user);

        userRepository.save(user);
        complaintRepository.save(complaint);
    }

    @Override
    public void removeComplaintFromUser(Long complaintId, User user) {
        Complaint complaint = getById(complaintId);
        user.removeComplaint(complaint);
        delete(complaintId);
        userRepository.save(user);
    }


}
