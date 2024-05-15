package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Result;
import org.springframework.stereotype.Service;

@Service
public class SubService {
    public Result sub(int a, int b) {
        int sum = a - b;
        return new Result(sum);
    }
}
