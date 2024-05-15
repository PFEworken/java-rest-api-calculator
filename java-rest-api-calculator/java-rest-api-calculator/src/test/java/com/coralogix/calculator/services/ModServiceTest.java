package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//mod service
public class ModServiceTest {

    @Test
    public void modtIntegers() {
        // given
        ModService service = new ModService();

        // when
        Result result = service.mod(2, 3);

        // then
        assertEquals(result.getResult(), 2);
    }
}
