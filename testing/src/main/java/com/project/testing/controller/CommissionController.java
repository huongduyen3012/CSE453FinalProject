package com.project.testing.controller;

import com.project.testing.services.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommissionController {
    @Autowired
    private CommissionService commissionService;

    @GetMapping("/commission")
    public String getCommission() {
        return "CommissionGenerator";
    }

    @GetMapping("/commission/generate")
    public String generate(Model model, @RequestParam("testType") String testType,
                           @RequestParam("fromLock") int fromLock, @RequestParam("toLock") int toLock,
                           @RequestParam("fromStock") int fromStock, @RequestParam("toStock") int toStock,
                           @RequestParam("fromBarrel") int fromBarrel, @RequestParam("toBarrel") int toBarrel) {
        commissionService.execute(testType, fromLock, toLock, fromStock, toStock, fromBarrel, toBarrel);

        model.addAttribute("commissions", commissionService.listAll());

        return "CommissionGenerator";
    }
}
