package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EActive;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Unitsrate;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.UnitsrateRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UnitsrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UnitsrateServiceImpl implements UnitsrateService {

    private final UnitsrateRepository unitsrateRepository;

    @Autowired
    public UnitsrateServiceImpl(
            UnitsrateRepository unitsrateRepository
    ){
        this.unitsrateRepository = unitsrateRepository;
    }

    @Override
    public void save(Unitsrate unitsrate) {
        unitsrate.setActive(EActive.ACTIVE);
        unitsrate.setCreated(new Date());

        unitsrateRepository.save(unitsrate);
    }

    @Override
    public void update(Long id, Unitsrate unitsrate) {

    }

    @Override
    public Unitsrate getById(Long id) {
        return unitsrateRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        unitsrateRepository.delete(getById(id));
    }

    @Override
    public List<Unitsrate> getAll() {
        return unitsrateRepository.findAll();
    }
}
