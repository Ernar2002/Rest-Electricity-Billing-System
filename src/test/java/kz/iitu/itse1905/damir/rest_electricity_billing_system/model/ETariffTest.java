package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ETariffTest {
    //Field TWOHUNDRED of type ETariff - was not mocked since Mockito doesn't mock enums
    //Field FIVEHUNDRED of type ETariff - was not mocked since Mockito doesn't mock enums
    //Field THOUSAND of type ETariff - was not mocked since Mockito doesn't mock enums

    @Test
    void testValues() {
        ETariff[] result = ETariff.values();
        Assertions.assertArrayEquals(new ETariff[]{ETariff.TWOHUNDRED}, result);
    }

    @Test
    void testValueOf() {
        ETariff result = ETariff.valueOf("name");
        Assertions.assertEquals(ETariff.TWOHUNDRED, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme