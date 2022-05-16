package kz.iitu.itse1905.damir.rest_electricity_billing_system.service;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    void save(MultipartFile file);
    List<User> getAllUsers();
}
