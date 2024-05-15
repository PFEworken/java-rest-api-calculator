package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiServiceTest {

    @Test
    public void multIntegers() {
        // given
        MultipleService service = new MultipleService();

        // when
        Result result = service.multi(2, 3);

        // then
        assertEquals(result.getResult(), 6);
    }
}
