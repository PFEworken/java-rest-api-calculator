package com.coralogix.calculator;

import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Add a base path for your API endpoints
@CrossOrigin(origins = "http://localhost:5000") // Adjust the origin as per your frontend URL
public class AddController {

    @Autowired
    private AddService addService;

    @GetMapping("/add") // Specify the full path for the add operation
    public Result add(@RequestParam int a, @RequestParam int b) {
        return addService.add(a, b);
    }
}
