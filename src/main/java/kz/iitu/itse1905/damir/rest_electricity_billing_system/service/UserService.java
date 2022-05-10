package kz.iitu.itse1905.damir.rest_electricity_billing_system.service;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;

public interface UserService extends BaseService<User>{

    User findByEmail(String email);

    User findByIIN(String iin);
}
