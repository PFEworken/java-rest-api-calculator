package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubServiceTest {

    @Test
    public void subIntegers() {
        // given
        SubService service = new SubService();

        // when
        Result result = service.sub(2, 3);

        // then
        assertEquals(result.getResult(), -1);
    }
}
