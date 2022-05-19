package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Unitsrate;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.UnitsrateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class UnitsrateServiceImplTest {
    @Mock
    UnitsrateRepository unitsrateRepository;
    @InjectMocks
    UnitsrateServiceImpl unitsrateServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSave() {
        unitsrateServiceImpl.save(new Unitsrate(0, 0, 0));
    }

    @Test
    void testUpdate() {
        unitsrateServiceImpl.update(Long.valueOf(1), new Unitsrate(0, 0, 0));
    }

    @Test
    void testGetById() {
        Unitsrate result = unitsrateServiceImpl.getById(Long.valueOf(1));
        Assertions.assertEquals(new Unitsrate(0, 0, 0), result);
    }

    @Test
    void testDelete() {
        unitsrateServiceImpl.delete(Long.valueOf(1));
    }

    @Test
    void testGetAll() {
        List<Unitsrate> result = unitsrateServiceImpl.getAll();
        Assertions.assertEquals(Arrays.<Unitsrate>asList(new Unitsrate(0, 0, 0)), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme