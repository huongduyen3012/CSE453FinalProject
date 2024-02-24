package com.project.testing.controller;

import com.project.testing.services.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommissionController {
    @Autowired private CommissionService commissionService;

    @GetMapping("/commission")
    public String generate()  {
        return "CommissionGenerator";
    }
}