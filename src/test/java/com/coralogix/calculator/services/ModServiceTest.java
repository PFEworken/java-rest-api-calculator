package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModServiceTest {

    @Test
    public void modIntegers() {
        // given
        ModService service = new ModService();

        // when
        Result result = service.mod(2, 3);

        // then
        assertEquals(result.getResult(), 2);
    }
}
