package com.coralogix.calculator;

import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Add a base path for your API endpoints
@CrossOrigin(origins = "http://localhost:5000") // Adjust the origin as per your frontend URL
public class SubController {

    @Autowired
    private SubService subService;

    @GetMapping("/sub") // Specify the full path for the sub operation
    public Result sub(@RequestParam int a, @RequestParam int b) {
        return subService.sub(a, b);
    }
}

