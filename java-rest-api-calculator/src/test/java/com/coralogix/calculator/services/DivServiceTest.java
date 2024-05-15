package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivServiceTest {

    @Test
    public void divIntegers() {
        // given
        DivService service = new DivService();

        // when
        Result result = service.div(2, 3);

        // then
        assertEquals(result.getResult(), 0);
    }
}
