package com.coralogix.calculator;

import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.ModService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Add a base path for your API endpoints
@CrossOrigin(origins = "http://localhost:5000") // Adjust the origin as per your frontend URL
public class ModController {

    @Autowired
    private ModService ModService;

    @GetMapping("/mod") // Specify the full path for the sub operation
    public Result div(@RequestParam int a, @RequestParam int b) {
        return ModService.mod(a, b);
    }
}

