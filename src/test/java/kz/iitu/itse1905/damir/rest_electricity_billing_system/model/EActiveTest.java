package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EActiveTest {
    //Field ACTIVE of type EActive - was not mocked since Mockito doesn't mock enums
    //Field NOT_ACTIVE of type EActive - was not mocked since Mockito doesn't mock enums
    //Field DELETED of type EActive - was not mocked since Mockito doesn't mock enums

    @Test
    void testValues() {
        EActive[] result = EActive.values();
        Assertions.assertArrayEquals(new EActive[]{EActive.ACTIVE}, result);
    }

    @Test
    void testValueOf() {
        EActive result = EActive.valueOf("name");
        Assertions.assertEquals(EActive.ACTIVE, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme