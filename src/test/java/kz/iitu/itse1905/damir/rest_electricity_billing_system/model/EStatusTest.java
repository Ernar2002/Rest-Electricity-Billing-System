package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EStatusTest {
    //Field PROCESSED of type EStatus - was not mocked since Mockito doesn't mock enums
    //Field PENDING of type EStatus - was not mocked since Mockito doesn't mock enums

    @Test
    void testValues() {
        EStatus[] result = EStatus.values();
        Assertions.assertArrayEquals(new EStatus[]{EStatus.PROCESSED}, result);
    }

    @Test
    void testValueOf() {
        EStatus result = EStatus.valueOf("name");
        Assertions.assertEquals(EStatus.PROCESSED, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme